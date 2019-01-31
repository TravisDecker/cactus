package space.straylense.cactus.model;

import java.util.Date;
import java.util.UUID;

public interface BaseUserEntity {

  public UUID getUserId();

  public String getScreenName();

  public boolean getReportFlag();

  public String getFirstName();

  public String getLastName();

  public String getOccupation();

  public Date getBirthDay();

}
