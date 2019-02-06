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
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import space.straylense.cactus.view.BasePostEntity;
import space.straylense.cactus.view.BaseUserEntity;

@Entity
@Component
public class UserEntity implements BaseUserEntity {

  private static EntityLinks entityLinks;

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;
  @NonNull
  private String screenName;
  @NonNull
  private String profilePicture;
  @NonNull
  private boolean reportFlag = false;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  private String occupation;
  private Date birthDay;
  private Date dateCreated = new Date();

  @JsonSerialize(contentAs = BasePostEntity.class)
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<PostEntity> posts = new LinkedList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<CommentEntity> comments = new LinkedList<>();

  @JsonSerialize(contentAs = BaseUserEntity.class)
  @OneToMany(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<UserEntity> friends = new LinkedList<>();

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    UserEntity.entityLinks = entityLinks;
  }

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(UserEntity.class, userId).toUri();
  }

  @Override
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  @Override
  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  @Override
  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  @Override
  public boolean getReportFlag() {
    return reportFlag;
  }

  public void setReportFlag(boolean reportFlag) {
    this.reportFlag = reportFlag;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  @Override
  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  @Override
  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public List<PostEntity> getPosts() {
    return posts;
  }

  public List<CommentEntity> getComments() {
    return comments;
  }

  public List<UserEntity> getFriends() {
    return friends;
  }
}
