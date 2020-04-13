package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.IncomeEntity;

public interface IncomeRepository extends MongoRepository<IncomeEntity, String> {

}
