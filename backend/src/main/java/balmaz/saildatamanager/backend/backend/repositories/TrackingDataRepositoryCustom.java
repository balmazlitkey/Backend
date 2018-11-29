package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.TrackingData;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TrackingDataRepositoryCustom {
	List<TrackingData> findByInstrumentId(String instrumentId);

}
