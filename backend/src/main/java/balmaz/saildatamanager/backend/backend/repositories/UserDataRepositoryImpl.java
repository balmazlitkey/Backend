package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserDataRepositoryImpl implements UserDataRepositoryCustom {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<UserData> findByInstrumentId(String instrumentId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("instrumentID").is(instrumentId));
		return mongoTemplate.find(query, UserData.class);
	}

	@Override
	public List<UserData> findBetweenPeriod(String startTime, String endtime) {
		Query query = new Query();
		query.addCriteria(Criteria.where("timestamp").gte(startTime).andOperator(Criteria.where("timestamp").lte(endtime)));
		return mongoTemplate.find(query, UserData.class);
	}

}
