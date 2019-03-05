package space.straylense.cactus.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import space.straylense.cactus.view.BasePostEntity;
import space.straylense.cactus.view.BaseUserEntity;

@Entity
@Component
public class ReportEntity {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID reportId;

  private Date reportDate = new Date();

  private boolean reportReviewed = false;

  private String repoertComment;

  @OneToOne
  @JsonSerialize(contentAs = BaseUserEntity.class)
  private UserEntity reportedUser;

  @OneToOne
  @JsonSerialize(contentAs = BasePostEntity.class)
  private PostEntity reportedPost;

  @OneToOne
  private CommentEntity reportedComment;

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    ReportEntity.entityLinks = entityLinks;
  }

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(UserEntity.class, reportId).toUri();
  }

  public UUID getReportId() {
    return reportId;
  }

  public void setReportId(UUID reportId) {
    this.reportId = reportId;
  }

  public Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  public String getRepoertComment() {
    return repoertComment;
  }

  public void setRepoertComment(String repoertComment) {
    this.repoertComment = repoertComment;
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
