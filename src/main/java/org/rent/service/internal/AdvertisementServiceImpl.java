package org.rent.service.internal;

import java.util.List;

import org.rent.model.Advertisement;
import org.rent.service.AdvertisementService;
import org.rent.service.internal.doa.AdvertisementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private AdvertisementDao advertisementDao;
	
	@Override
	public Boolean remove(Integer id) {
		return null;
	}

	@Override
	public List<Advertisement> getByUserId(Integer userId) {
		return null;
	}

	@Override
	public Advertisement getById(Integer id) {
		return null;
	}

	@Override
	public Boolean update(Advertisement advertisement) {
		return null;
	}

	@Override
	public Integer save(Advertisement advertisement) {
		return null;
	}

	@Override
	public List<Advertisement> get() {
		return advertisementDao.find();
	}

}
