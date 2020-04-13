package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.AssetEntity;

public interface AssetRepository extends MongoRepository<AssetEntity, String> {

}
