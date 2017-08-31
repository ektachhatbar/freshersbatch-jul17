package com.spring.AdvertisementServices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.AdvertisementServices.collections.LoginCollection;

public interface LoginRepository extends MongoRepository<LoginCollection, String> {
	@Query(value="{id:?0}")
	public List<LoginCollection> getToken(String authToken);
}
