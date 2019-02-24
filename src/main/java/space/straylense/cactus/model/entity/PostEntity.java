package space.straylense.cactus.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import space.straylense.cactus.view.BasePostEntity;
import space.straylense.cactus.view.BaseUserEntity;

@Entity
@Component
public class PostEntity implements BasePostEntity, Comparable<PostEntity> {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID postId;

  @NonNull
  @JsonSerialize(contentAs = BaseUserEntity.class)
  @ManyToOne(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private UserEntity user;

  @NonNull
  private boolean reportFlag = false;

  @NonNull
  private int bumps;

  @NonNull
  private Date postDate = new Date();

  @NonNull
  private String postBody;

  private String image;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "post",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<CommentEntity> comments = new LinkedList<>();

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    PostEntity.entityLinks = entityLinks;
  }

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(PostEntity.class, postId).toUri();
  }

  @Override
  public UUID getPostId() {
    return postId;
  }

  public void setPostId(UUID postId) {
    this.postId = postId;
  }


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

  @Override
  public int getBumps() {
    return bumps;
  }

  public void setBumps(int bumps) {
    this.bumps = bumps;
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

  @Override
  public int compareTo(PostEntity post) {
    return getPostDate().compareTo(post.getPostDate());
  }

}
