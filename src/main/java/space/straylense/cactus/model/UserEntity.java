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
public class UserEntity implements BaseUserEntity {

  @Id
  @NonNull
  private UUID userId;
  @NonNull
  private String screenName;
  @NonNull
  private boolean reportFlag;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  private String occupation;
  private Date birthDay;
  private List<PostEntity> posts;

  @Override
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  @Override
  public String getScreenName() {
    return null;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  @Override
  public boolean getReportFlag() {
    return false;
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

}
