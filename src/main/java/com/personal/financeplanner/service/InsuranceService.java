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
import com.personal.financeplanner.entity.InsuranceEntity;
import com.personal.financeplanner.model.Insurance;

@Service
public class InsuranceService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;

	public List<Insurance> getInsuranceDetails() {
		List<Insurance> insuranceList = new ArrayList<Insurance>();
		List<InsuranceEntity> insuranceEntityList =  mongoTemplate.findAll(InsuranceEntity.class, "insuranceList");
		for (InsuranceEntity insuranceEntity : insuranceEntityList) {
			Insurance insurance = modelMapper.map(insuranceEntity,Insurance.class);
			insurance.setInsuranceId(insuranceEntity.getId());
			insuranceList.add(insurance);
		}
		return insuranceList;
	}

	public void createInsuranceDetails(List<Insurance> insuranceList) {
		for (Insurance insurance : insuranceList) {
			InsuranceEntity insuranceEntity = modelMapper.map(insurance,InsuranceEntity.class);
			insuranceEntity.setId(insurance.getInsuranceId());
			mongoTemplate.save(insuranceEntity, "insuranceList");
		}
	}

	public void deleteInsuranceDetails(String insuranceId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(insuranceId));
		mongoTemplate.remove(query, IncomeEntity.class);
	}

}
