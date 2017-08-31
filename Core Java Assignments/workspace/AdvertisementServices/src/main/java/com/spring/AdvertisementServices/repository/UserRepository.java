package com.spring.AdvertisementServices.repository;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.AdvertisementServices.collections.UserCollection;

public interface UserRepository extends MongoRepository<UserCollection, String>{
	@Query(value="{userName:?0}, {password:?1}")
	public List<UserCollection> getUsers(String userName,String password);
}
