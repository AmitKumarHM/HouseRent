package org.rent.service;

import java.util.List;

import org.rent.model.Advertisement;

public interface AdvertisementService {

Boolean remove(Integer id);
List<Advertisement> getByUserId(Integer userId);
Advertisement getById(Integer id);
Boolean update(Advertisement advertisement);
Integer save(Advertisement advertisement);
List<Advertisement> get();
}
