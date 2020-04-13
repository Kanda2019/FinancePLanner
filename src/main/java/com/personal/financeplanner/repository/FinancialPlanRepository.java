package com.personal.financeplanner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.personal.financeplanner.entity.FinancialPlanEntity;

public interface FinancialPlanRepository extends MongoRepository<FinancialPlanEntity, String> {

}
