package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.InsuranceEntity;

public interface InsuranceRepository extends MongoRepository<InsuranceEntity, String> {

}
