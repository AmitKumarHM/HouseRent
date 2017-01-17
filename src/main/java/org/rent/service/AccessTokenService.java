package org.rent.service;

import org.rent.model.AccessToken;

public interface AccessTokenService {

AccessToken validToken(AccessToken accessToken);
AccessToken getById(Integer id);
Boolean update(AccessToken accessToken);
Integer save(AccessToken accessToken);

}
