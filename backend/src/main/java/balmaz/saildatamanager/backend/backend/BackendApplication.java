package balmaz.saildatamanager.backend.backend;

import balmaz.saildatamanager.backend.backend.repositories.UserDataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

	}
}
