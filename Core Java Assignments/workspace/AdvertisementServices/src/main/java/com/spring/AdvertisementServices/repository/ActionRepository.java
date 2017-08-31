package com.spring.AdvertisementServices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.AdvertisementServices.collections.ActionCollection;

public interface ActionRepository extends MongoRepository<ActionCollection, String>{

}
