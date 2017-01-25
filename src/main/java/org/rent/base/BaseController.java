package org.rent.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rent.bucket.BucketImpl;
import org.rent.model.AccessToken;
import org.rent.model.Advertisement;
import org.rent.model.Image;
import org.rent.model.User;
import org.rent.service.AccessTokenService;
import org.rent.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.transfer.model.UploadResult;

/**
 * The Class BaseController.
 */
public abstract class BaseController {	

	/** The LOGGER. */
	private static Log LOGGER = LogFactory.getLog(BaseController.class);
	
	
	public Image writeToFileAdvertisement(InputStream fileInputString, String fileName, Advertisement adver,User user) {
		
		Image image=null;
		try {
			FileOutputStream out = new FileOutputStream(new File(
					fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = fileInputString.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			BucketImpl bucketImpl=new BucketImpl();
			TransferManager tm = new TransferManager(new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY));        
		    PutObjectRequest request= new PutObjectRequest(
		        		Constants.BUCKET_NAME,user.getUserId()+"/"+bucketImpl.keyName()+"/"+fileName, new File(fileName)).withCannedAcl(CannedAccessControlList.PublicRead);
		    image=new Image();
		    Upload upload = tm.upload(request);
		    try {
		        	UploadResult result=upload.waitForUploadResult();
		        	LOGGER.info("Upload complete.");
		        	result.getKey();
		        	tm.shutdownNow();
		        	image.setImageURL(Constants.AWS_URL+result.getBucketName()+"/"+result.getKey());
		        	image.setImageType(fileName.split(".")[1]);
		    } catch (AmazonClientException amazonClientException) {
		        	LOGGER.error("Unable to upload file, upload was aborted.");
		        	amazonClientException.printStackTrace();
		        } catch (InterruptedException e) {	
					e.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	
	
	// save uploaded file to new location
	public boolean writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation,User user) {

		boolean uploadStatus=false;
			try {
				FileOutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
				BucketImpl bucketImpl=new BucketImpl();
				TransferManager tm = new TransferManager(new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY));        
			    PutObjectRequest request= new PutObjectRequest(
			        		Constants.BUCKET_NAME,user.getUserId()+"/"+bucketImpl.keyName()+"/"+uploadedFileLocation, new File(uploadedFileLocation)).withCannedAcl(CannedAccessControlList.PublicRead);
			    Upload upload = tm.upload(request);
			    try {
			        	UploadResult result=upload.waitForUploadResult();
			        	LOGGER.info("Upload complete.");
			        	result.getKey();
			        	tm.shutdownNow();
			        	user.setProfileImage(Constants.AWS_URL+result.getBucketName()+"/"+result.getKey());
			        } catch (AmazonClientException amazonClientException) {
			        	LOGGER.error("Unable to upload file, upload was aborted.");
			        	amazonClientException.printStackTrace();
			        } catch (InterruptedException e) {	
						e.printStackTrace();
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return uploadStatus;
	}
	
	
	
	
	
	@Autowired
	protected AccessTokenService accessTokenService;
	
	protected AccessToken validateAccessToken(AccessToken accessToken) {
		AccessToken aToken = null;
		try {
			aToken = accessTokenService.validToken(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aToken;
	}

	/**
	 * Creates the accsess token.
	 *
	 * @param user the user
	 * @return the access tokens
	 */
	protected AccessToken createAccsessToken(User user) {	

		String random = UUID.randomUUID().toString();
		AccessToken accessToken = new AccessToken();
		accessToken.setCreatedDate(new Timestamp(new Date().getTime()));
		accessToken.setAccessToken(random);
		accessToken.setRefreshToken(random);
		user.setPassword("");
		accessToken.setUser(user);		
		return accessToken;
		
	}
	
	protected String getAccsessToken(String accessToken) {	
		String[] bearerToken=accessToken.split(" ");
		return bearerToken[1];
		
	}
	
	
	
}
