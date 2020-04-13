package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.CashflowEntity;

public interface CashflowRepository extends MongoRepository<CashflowEntity, String> {

}
