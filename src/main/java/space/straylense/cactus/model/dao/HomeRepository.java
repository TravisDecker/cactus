package space.straylense.cactus.model.dao;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.UserEntity;

public interface HomeRepository extends CrudRepository<UserEntity, UUID> {

}
