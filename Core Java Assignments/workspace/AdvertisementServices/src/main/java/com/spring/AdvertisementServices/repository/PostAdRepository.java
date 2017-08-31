package com.spring.AdvertisementServices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.AdvertisementServices.collections.PostAdCollection;

public interface PostAdRepository extends MongoRepository<PostAdCollection, String>{

}
