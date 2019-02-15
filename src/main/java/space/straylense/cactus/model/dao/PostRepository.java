package space.straylense.cactus.model.dao;

import java.util.List;
import java.util.UUID;
import org.hibernate.type.UUIDBinaryType;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.PostEntity;
import space.straylense.cactus.model.entity.UserEntity;

public interface PostRepository extends CrudRepository<PostEntity, UUIDBinaryType> {

  PostEntity findAllByUserAndPostIdOrderByPostDate(UUID userId, UUID postId);

  List<PostEntity> findAllByUserOrderByPostDate(UserEntity user);

}
