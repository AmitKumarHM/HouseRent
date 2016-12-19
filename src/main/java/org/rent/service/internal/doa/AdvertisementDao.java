package org.rent.service.internal.doa;

import java.util.List;

import org.rent.model.Advertisement;

public interface AdvertisementDao {

Boolean remove(Integer id);
List<Advertisement> findByUserId(Integer userId);
Advertisement findById(Integer id);
Advertisement update(Advertisement advertisement);
Integer save(Advertisement advertisement);

}
