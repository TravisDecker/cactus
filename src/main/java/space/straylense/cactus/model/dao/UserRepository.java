package space.straylense.cactus.model.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  UserEntity findAllByUserId(UUID userID);

  List<UserEntity> findAllByScreenNameContaining(String screenName);

  UserEntity findAllByScreenName(String screenName);

  List<UserEntity> findAllByFirstNameContainsOrLastNameContains(String firstlName, String lastName);

  List<UserEntity> findAllByFirstNameContains(String firstName);

  List<UserEntity> findAllByLastNameContains(String lastName);


}

