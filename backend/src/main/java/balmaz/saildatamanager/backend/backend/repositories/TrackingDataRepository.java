package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.TrackingData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
public interface TrackingDataRepository extends MongoRepository<TrackingData, Long>, TrackingDataRepositoryCustom{

}
