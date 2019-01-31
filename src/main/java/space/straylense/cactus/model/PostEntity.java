package space.straylense.cactus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class PostEntity implements BasePostEntity {

  @Id
  @NonNull
  private UUID postId;
  private Date postDate;
  private String postBody;
  //Image is String temporarily
  private String image;
  private List<CommentEntity> comments;

  @Override
  public UUID getPostId() {
    return postId;
  }

  @Override
  public Date getPostDate() {
    return postDate;
  }

  @Override
  public String getPostBody() {
    return postBody;
  }

  @Override
  public String getImage() {
    return image;
  }

  public List<CommentEntity> getComments() {
    return comments;
  }

}
