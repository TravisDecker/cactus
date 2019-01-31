package space.straylense.cactus.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
public class CommentEntity {

  @Id
  @NonNull
  private UUID commentId;
  @NonNull
  private boolean reportFlag;
  @NonNull
  private UserEntity user;
  @NonNull
  private Date date;
  @NonNull
  private String comment;

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
}
