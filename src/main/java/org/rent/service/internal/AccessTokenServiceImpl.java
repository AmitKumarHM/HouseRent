package org.rent.service.internal;

import org.rent.model.AccessToken;
import org.rent.service.AccessTokenService;
import org.rent.service.internal.doa.AccessTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
	private AccessTokenDao accessTokenDao;

	
	@Override
	public Boolean validToken(AccessToken accessToken) {
		return (accessTokenDao.validToken(accessToken) != null)?true:false;
	}

	@Override
	public AccessToken getById(Integer id) {
		return accessTokenDao.findById(id);
	}

	@Override
	public Boolean update(AccessToken accessToken) {
		return accessTokenDao.update(accessToken) != null?true:false;
	}

	@Override
	public Integer save(AccessToken accessToken) {
		return accessTokenDao.save(accessToken);
	}

}
