package space.straylense.cactus.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
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
import space.straylense.cactus.view.BaseUserEntity;

@Entity
@Component
public class UserEntity implements BaseUserEntity {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;
  @NonNull
  private String screenName;
  @NonNull
  private String profilePicture;
  @NonNull
  private boolean reportFlag;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  private String occupation;
  private Date birthDay;
  @JsonSerialize(contentAs = BasePostEntity.class)
  private List<PostEntity> posts = new ArrayList<>();
  @JsonSerialize(contentAs = BaseUserEntity.class)
  private List<UserEntity> friends = new ArrayList<>();

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

  public List<PostEntity> getPosts() {
    return posts;
  }

  public List<UserEntity> getFriends() {
    return friends;
  }
}
