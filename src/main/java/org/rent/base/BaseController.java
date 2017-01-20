package org.rent.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.rent.bucket.BucketImpl;
import org.rent.model.AccessToken;
import org.rent.model.User;
import org.rent.service.AccessTokenService;
import org.rent.utils.Constants;
import org.rent.utils.S3Util;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class BaseController.
 */
public abstract class BaseController {	

	private Boolean bucketStatus;

	// save uploaded file to new location
	public void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation,User user) {
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
				S3Util s3=new S3Util();
				if(!bucketStatus) 
				    bucketStatus=s3.createBucket(Constants.BUCKET_NAME);
				
				
				if(bucketStatus){
					s3.save(Constants.BUCKET_NAME, bucketImpl.keyName()+"/"+bucketImpl.fileName(uploadedFileLocation), new File(
							uploadedFileLocation));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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
