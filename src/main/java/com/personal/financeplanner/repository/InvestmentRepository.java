package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.InvestmentEntity;

public interface InvestmentRepository extends MongoRepository<InvestmentEntity, String> {

}
