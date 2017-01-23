package org.rent.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rent.bucket.BucketImpl;
import org.rent.utils.Constants;
import org.rent.utils.S3Util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class ImageUploaderTester {

	/** The LOGGER. */
	private static Log LOGGER = LogFactory.getLog(ImageUploaderTester.class);
	
	public static void main(String[] args) {
		    final ClientConfig config = new DefaultClientConfig();
	        final Client client = Client.create(config);
	        final WebResource resource = client.resource("http://localhost:8080/rent.api/rest/user/").path("upload");
	        final File fileToUpload = new File("/home/the_one/Devkit/FatBurningFoods.jpg");
	        final FormDataMultiPart multiPart = new FormDataMultiPart();
	        if (fileToUpload != null) {
	            multiPart.bodyPart(new FileDataBodyPart("image", fileToUpload,
	                    MediaType.APPLICATION_OCTET_STREAM_TYPE));
	        }
	        
	        final ClientResponse clientResp = resource.header("Authorization", "Bearer 09712b4f-7a0e-42fe-87ff-d4fd3ed15930").header("userId", 1).type(
	                MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
	                multiPart);
	        System.out.println("Response: " + clientResp.getClientResponseStatus());       
	        client.destroy();
	}

	public static void main1(String[] args) throws FileNotFoundException {
		boolean bucketStatus=false;
		 BucketImpl bucketImpl=new BucketImpl();
			S3Util s3=new S3Util();
			if(!bucketStatus) 
			    bucketStatus=s3.createBucket(Constants.BUCKET_NAME);
			
			System.out.println(1+"/"+bucketImpl.keyName()+"/"+bucketImpl.fileName("FatBurningFoods.jpg"));
			if(bucketStatus){
			bucketStatus=s3.save(Constants.BUCKET_NAME, bucketImpl.keyName()+"/", new FileInputStream(new File(
					"FatBurningFoods.jpg")),null);
			}
		
			
			   TransferManager tm = new TransferManager(new BasicAWSCredentials("AKIAJL6UWNUNC5ETDMUA", "TeWoXmauUAgea4Yn2J6td3qSMnM5GRVGp1Huds2D"));        
		       PutObjectRequest request= new PutObjectRequest(
		        		Constants.BUCKET_NAME,1+"/"+bucketImpl.keyName()+"/FatBurningFoods.jpg", new File("/home/the_one/Devkit/FatBurningFoods.jpg")).withCannedAcl(CannedAccessControlList.PublicRead);
		       Upload upload = tm.upload(request);
		        
		        
		        
		        try {
		        	// Or you can block and wait for the upload to finish
		        	com.amazonaws.services.s3.transfer.model.UploadResult result=upload.waitForUploadResult();
		        	System.out.println("Upload complete.");
		        	 tm.shutdownNow();
		        	 System.out.println(Constants.AWS_URL+result.getBucketName()+"/"+result.getKey());
		        } catch (AmazonClientException amazonClientException) {
		        	System.out.println("Unable to upload file, upload was aborted.");
		        	amazonClientException.printStackTrace();
		        } catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		
	}
}
