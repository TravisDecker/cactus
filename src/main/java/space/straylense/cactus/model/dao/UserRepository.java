package space.straylense.cactus.model.dao;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

  UserEntity findAllByUserId(UUID userID);

  UserEntity findAllByScreenName(String screenName);
}
