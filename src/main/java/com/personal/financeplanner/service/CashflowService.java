package com.personal.financeplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.personal.financeplanner.entity.CashflowEntity;
import com.personal.financeplanner.model.Cashflow;

@Service
public class CashflowService {

	Logger logger = LoggerFactory.getLogger(CashflowService.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public List<Cashflow> getAllCashflows() {
		List<Cashflow> cashflowList = new ArrayList<Cashflow>();
		List<CashflowEntity> cashflowEntityList =  mongoTemplate.findAll(CashflowEntity.class, "cashflowList");
		for (CashflowEntity cashflowEntity : cashflowEntityList) {
			Cashflow cashflow = modelMapper.map(cashflowEntity,Cashflow.class);
			cashflow.setCashflowId(cashflowEntity.getId());
			cashflowList.add(cashflow);
		}
		return cashflowList;
	}

	public void createCashflow(List<Cashflow> cashflowList) {
		for (Cashflow cashflow : cashflowList) {
			CashflowEntity cashflowEntity = modelMapper.map(cashflow,CashflowEntity.class);
			cashflowEntity.setId(cashflow.getCashflowId());
			mongoTemplate.save(cashflowEntity, "cashflowList");
		}

	}

	public void deleteCashflow(String cashflowId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(cashflowId));
		mongoTemplate.remove(query, CashflowEntity.class);

	}

}
