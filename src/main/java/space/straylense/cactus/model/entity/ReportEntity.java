package space.straylense.cactus.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import space.straylense.cactus.view.BasePostEntity;
import space.straylense.cactus.view.BaseUserEntity;

@Entity
@Component
public class ReportEntity {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID reportID;

  private Date reportDate = new Date();

  private boolean reportReviewed = false;

  @JsonSerialize(contentAs = BaseUserEntity.class)
  private UserEntity reportedUser;

  @JsonSerialize(contentAs = BasePostEntity.class)
  private PostEntity reportedPost;

  private CommentEntity reportedComment;

  public UUID getReportID() {
    return reportID;
  }

  public void setReportID(UUID reportID) {
    this.reportID = reportID;
  }

  public Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  public boolean isReportReviewed() {
    return reportReviewed;
  }

  public void setReportReviewed(boolean reportReviewed) {
    this.reportReviewed = reportReviewed;
  }

  public UserEntity getReportedUser() {
    return reportedUser;
  }

  public void setReportedUser(UserEntity reportedUser) {
    this.reportedUser = reportedUser;
  }

  public PostEntity getReportedPost() {
    return reportedPost;
  }

  public void setReportedPost(PostEntity reportedPost) {
    this.reportedPost = reportedPost;
  }

  public CommentEntity getReportedComment() {
    return reportedComment;
  }

  public void setReportedComment(CommentEntity reportedComment) {
    this.reportedComment = reportedComment;
  }
}
