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
import com.personal.financeplanner.model.FinancialGoal;

@Service
public class FinancialGoalService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;


	public List<FinancialGoal> getFinancialgoals() {

		List<FinancialGoal> financialGoalList = new ArrayList<FinancialGoal>();
		List<FinancialGoalEntity> financialGoalEntityList =  mongoTemplate.findAll(FinancialGoalEntity.class, "financialGoalList");
		for (FinancialGoalEntity financialGoalEntity : financialGoalEntityList) {
			FinancialGoal financialGoal = modelMapper.map(financialGoalEntity,FinancialGoal.class);
			financialGoal.setGoalId(financialGoalEntity.getId());
			financialGoalList.add(financialGoal);
		}
		return financialGoalList;
	}

	public void createFinancialgoals(List<FinancialGoal> financialGoalList) {
		for (FinancialGoal financialGoal : financialGoalList) {
			FinancialGoalEntity financialGoalEntity = modelMapper.map(financialGoal,FinancialGoalEntity.class);
			financialGoalEntity.setId(financialGoal.getGoalId());
			mongoTemplate.save(financialGoalEntity, "financialGoalList");
		}

	}

	public void deleteFinancialgoals(String financialGoalLId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(financialGoalLId));
		mongoTemplate.remove(query, FinancialGoalEntity.class);

	}

}
