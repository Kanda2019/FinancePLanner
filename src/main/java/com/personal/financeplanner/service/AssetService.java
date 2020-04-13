package com.personal.financeplanner.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.personal.financeplanner.entity.AssetEntity;
import com.personal.financeplanner.model.Asset;

@Service
public class AssetService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ModelMapper modelMapper;

	/***
	 * Method to fetch all the assets
	 * @return
	 */
	public List<Asset> getAssetDetails() {
		List<Asset> assetList = new ArrayList<Asset>();
		List<AssetEntity> assetEntityList =  mongoTemplate.findAll(AssetEntity.class, "assetList");
		for (AssetEntity assetEntity : assetEntityList) {
			Asset asset = modelMapper.map(assetEntity,Asset.class);
			asset.setAssetId(assetEntity.getId());
			assetList.add(asset);
		}
		return assetList;
	}

	/***
	 * Method to create the Assets
	 * @param assetList
	 */
	public void createAssets(List<Asset> assetList) {
		for (Asset asset : assetList) {
			AssetEntity assetEntity = modelMapper.map(asset,AssetEntity.class);
			assetEntity.setId(asset.getAssetId());
			mongoTemplate.save(assetEntity, "assetList");
		}

	}

	/***
	 * Method to delete an Asset based on Asset ID
	 * @param assetId
	 */
	public void deleteAssets(String assetId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(assetId));
		mongoTemplate.remove(query, AssetEntity.class);

	}

}
