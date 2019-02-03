package space.straylense.cactus.model;

import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class CommentEntity {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID commentId;
  @NonNull
  private boolean reportFlag;
  @NonNull
  private UserEntity user;
  @NonNull
  private Date date;
  @NonNull
  private String comment;
  @NonNull
  private int Bumps;

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    CommentEntity.entityLinks = entityLinks;
  }

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(CommentEntity.class, commentId).toUri();
  }

  public UUID getCommentId() {
    return commentId;
  }

  public void setCommentId(UUID commentId) {
    this.commentId = commentId;
  }

  public boolean isReportFlag() {
    return reportFlag;
  }

  public void setReportFlag(boolean reportFlag) {
    this.reportFlag = reportFlag;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getBumps() {
    return Bumps;
  }

  public void setBumps(int bumps) {
    Bumps = bumps;
  }
}
