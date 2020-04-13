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
import com.personal.financeplanner.entity.InvestmentEntity;
import com.personal.financeplanner.model.Investment;

@Service
public class InvestmentService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public List<Investment> getAllInvestments() {
		List<Investment> investmentList = new ArrayList<Investment>();
		List<InvestmentEntity> investmentEntityList =  mongoTemplate.findAll(InvestmentEntity.class, "investmentList");
		for (InvestmentEntity investmentEntity : investmentEntityList) {
			Investment investment  = modelMapper.map(investmentEntity,Investment.class);
			investment.setInvestmentId(investmentEntity.getId());
			investmentList.add(investment);
		}
		return investmentList;
	}

	public void createInvestmentDetails(List<Investment> investmentList) {
		for (Investment investment : investmentList) {
			InvestmentEntity investmentEntity = modelMapper.map(investment,InvestmentEntity.class);
			investmentEntity.setId(investment.getInvestmentId());
			mongoTemplate.save(investmentEntity, "investmentList");
		}
	}

	public void deleteInvestmentDetails(String investmentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(investmentId));
		mongoTemplate.remove(query, IncomeEntity.class);
	}

}
