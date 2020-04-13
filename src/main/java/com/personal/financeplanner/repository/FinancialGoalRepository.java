package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.FinancialGoalEntity;

public interface FinancialGoalRepository extends MongoRepository<FinancialGoalEntity, String> {

}
