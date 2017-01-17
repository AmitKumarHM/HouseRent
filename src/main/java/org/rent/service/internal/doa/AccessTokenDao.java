package org.rent.service.internal.doa;

import org.rent.model.AccessToken;

public interface AccessTokenDao {

	AccessToken validToken(AccessToken accessToken);
	AccessToken findById(Integer id);
	AccessToken update(AccessToken accessToken);
	Integer save(AccessToken accessToken);
	
}
