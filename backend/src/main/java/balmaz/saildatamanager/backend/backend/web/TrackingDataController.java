package balmaz.saildatamanager.backend.backend.web;

import balmaz.saildatamanager.backend.backend.data.TrackingData;
import balmaz.saildatamanager.backend.backend.data.UserData;
import balmaz.saildatamanager.backend.backend.repositories.TrackingDataRepository;
import balmaz.saildatamanager.backend.backend.repositories.UserDataRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trackingdata")
public class TrackingDataController {
	@Autowired
	private TrackingDataRepository repository;
	@Autowired
	private UserDataRepository userDataRepository;

	@PostMapping
	public ResponseEntity<?> postTrackingData(@RequestBody TrackingData trackingData){
		repository.save(trackingData);
		System.out.println("Tracking data saved at "+trackingData.getStartTime());
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ArrayList<TrackingData>> getById(@PathVariable String id) {
		ArrayList<TrackingData> data = new ArrayList<>(repository.findByInstrumentId(id));
		for (TrackingData t: data) {
			t.setTrackedUserData(new ArrayList<>(userDataRepository.findBetweenPeriod(t.getStartTime(),t.getEndTime())));
		}
		if (!data.isEmpty()){
			ResponseEntity<ArrayList<TrackingData>> response = new ResponseEntity<>(data, HttpStatus.OK);
			return response;
		}

		else
			return ResponseEntity.notFound().build();
	}

}