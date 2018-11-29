package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.UserData;

import java.util.List;

public interface UserDataRepositoryCustom {
	List<UserData> findByInstrumentId(String instrumentId);

	List<UserData> findBetweenPeriod(String startTime, String Endtime);
}
