package space.straylense.cactus.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import space.straylense.cactus.view.BasePostEntity;

@Entity
@Component
public class PostEntity implements BasePostEntity {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID postId;
  @NonNull
  private UserEntity user;
  @NonNull
  private boolean reportFlag;
  @NonNull
  private Date postDate;
  @NonNull
  private String postBody;
  //Image is String temporarily
  private String image;
  private List<CommentEntity> comments;

  @Override
  public UUID getPostId() {
    return postId;
  }

  public void setPostId(UUID postId) {
    this.postId = postId;
  }

  @Override
  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  @Override
  public boolean getReportFlag() {
    return reportFlag;
  }

  public void setReportFlag(boolean reportFlag) {
    this.reportFlag = reportFlag;
  }

  @Override
  public Date getPostDate() {
    return postDate;
  }

  public void setPostDate(Date postDate) {
    this.postDate = postDate;
  }

  @Override
  public String getPostBody() {
    return postBody;
  }

  public void setPostBody(String postBody) {
    this.postBody = postBody;
  }

  @Override
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<CommentEntity> getComments() {
    return comments;
  }

}
