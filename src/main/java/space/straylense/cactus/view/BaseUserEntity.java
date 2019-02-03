package space.straylense.cactus.view;

import java.util.Date;
import java.util.UUID;

public interface BaseUserEntity {

  public UUID getUserId();

  public String getScreenName();

  public String getProfilePicture();

  public boolean getReportFlag();

  public String getFirstName();

  public String getLastName();

  public String getOccupation();

  public Date getBirthDay();

}
