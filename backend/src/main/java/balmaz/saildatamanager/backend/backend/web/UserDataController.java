package balmaz.saildatamanager.backend.backend.web;

import balmaz.saildatamanager.backend.backend.data.StatisticData;
import balmaz.saildatamanager.backend.backend.data.UserData;
import balmaz.saildatamanager.backend.backend.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userdata")
public class UserDataController {
	@Autowired
	private UserDataRepository repository;

	@PostMapping
	public ResponseEntity<?> postUserData(@RequestBody UserData userData) {
		repository.save(userData);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<StatisticData> getById(@PathVariable String id) {
		List<UserData> data = repository.findByInstrumentId(id);
		if (!data.isEmpty()){
			return new ResponseEntity<>(new StatisticData(data), HttpStatus.OK);
		}
		else
			return ResponseEntity.notFound().build();
	}

}
