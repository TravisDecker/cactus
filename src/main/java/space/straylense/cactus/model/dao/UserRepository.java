package space.straylense.cactus.model.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  UserEntity findAllByUserId(UUID userID);

  UserEntity findAllByUserName(String userName);

  List<UserEntity> findAllByUserNameContains(String userName);

  List<UserEntity> findAllByFirstNameContainsOrLastNameContains(String firstName, String lastName);

  List<UserEntity> findAllByFirstNameContains(String firstName);

  List<UserEntity> findAllByLastNameContains(String lastName);


}

