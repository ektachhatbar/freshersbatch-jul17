package com.spring.AdvertisementServices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.AdvertisementServices.collections.CategoriesCollection;


public interface CategoryRepository extends MongoRepository<CategoriesCollection, String>{

}
