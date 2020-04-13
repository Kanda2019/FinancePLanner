package com.personal.financeplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.personal.financeplanner.entity.IncomeEntity;
import com.personal.financeplanner.model.Income;

@Service
public class IncomeService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;
	
	public List<Income> getIncomeDetails() {
		List<Income> incomeList = new ArrayList<Income>();
		List<IncomeEntity> incomeEntityList =  mongoTemplate.findAll(IncomeEntity.class, "incomeList");
		for (IncomeEntity incomeEntity : incomeEntityList) {
			Income income = modelMapper.map(incomeEntity,Income.class);
			income.setIncomeId(incomeEntity.getId());
			incomeList.add(income);
		}
		return incomeList;
	}

	public void createIncomeDetails(List<Income> incomeList) {
		for (Income income : incomeList) {
			IncomeEntity incomeEntity = modelMapper.map(income,IncomeEntity.class);
			incomeEntity.setId(income.getIncomeId());
			mongoTemplate.save(incomeEntity, "incomeList");
		}
	}

	public void deleteIncomeDetails(String incomeId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(incomeId));
		mongoTemplate.remove(query, IncomeEntity.class);
	}

}
