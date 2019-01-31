package space.straylense.cactus.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class PostEntity {

  @Id
  @NonNull
  private UUID postId;
  private Date postDate;
  private String postBody;
  private Blob image;
  private List<CommentEntity> comments;
}
