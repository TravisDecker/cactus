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
  private String firstName;
  private String lastName;
  private String occupation;
  private Date birthDay;
  private List<PostEntity> posts;


  @Override
  public UUID getUserId() {
    return null;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  @Override
  public String getFirstName() {
    return null;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return null;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String getOccupation() {
    return null;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  @Override
  public Date getBirthDay() {
    return null;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public List<PostEntity> getPosts() {
    return posts;
  }

}
