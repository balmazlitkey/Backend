package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.TrackingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class TrackingDataRepositoryImpl implements TrackingDataRepositoryCustom {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<TrackingData> findByInstrumentId(String instrumentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("instrumentId").is(instrumentId));
		List<TrackingData> result = mongoTemplate.find(query, TrackingData.class);
		return result;
	}
}