package org.rent.base;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.rent.model.AccessToken;
import org.rent.model.User;
import org.rent.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class BaseController.
 */
public abstract class BaseController {	
	

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
		accessToken.setUser(user);		
		return accessToken;
		
	}
	
	protected String getAccsessToken(String accessToken) {	

		String[] bearerToken=accessToken.split(" ");
		return bearerToken[1];
		
	}
	
	
	
}
