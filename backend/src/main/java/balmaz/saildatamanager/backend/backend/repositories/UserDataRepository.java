package balmaz.saildatamanager.backend.backend.repositories;

import balmaz.saildatamanager.backend.backend.data.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserData, Long>, UserDataRepositoryCustom{

}
