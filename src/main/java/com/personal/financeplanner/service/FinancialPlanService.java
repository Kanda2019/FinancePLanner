package com.personal.financeplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.personal.financeplanner.entity.FinancialGoalEntity;
import com.personal.financeplanner.entity.FinancialPlanEntity;
import com.personal.financeplanner.model.FinancialPlan;

@Service
public class FinancialPlanService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public List<FinancialPlan> getFinancialPlans() {
		List<FinancialPlan> financialPlanList = new ArrayList<FinancialPlan>();
		List<FinancialPlanEntity> financialPlanEntityList =  mongoTemplate.findAll(FinancialPlanEntity.class, "financialPlanList");
		for (FinancialPlanEntity financialPlanEntity : financialPlanEntityList) {
			FinancialPlan financialPlan = modelMapper.map(financialPlanEntity,FinancialPlan.class);
			financialPlan.setPlanId(financialPlanEntity.getId());
			financialPlanList.add(financialPlan);
		}
		return financialPlanList;
	}

	public void createFinancialPlan(List<FinancialPlan> financialPlanList) {
		for (FinancialPlan financialPlan : financialPlanList) {
			FinancialPlanEntity financialPlanEntity = modelMapper.map(financialPlan,FinancialPlanEntity.class);
			financialPlanEntity.setId(financialPlan.getPlanId());
			mongoTemplate.save(financialPlanEntity, "financialPlanList");
		}
	}

	public void deleteFinancialplan(String planId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(planId));
		mongoTemplate.remove(query, FinancialGoalEntity.class);
	}

}
