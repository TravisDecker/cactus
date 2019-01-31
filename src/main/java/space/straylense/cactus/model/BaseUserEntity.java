package space.straylense.cactus.model;

import java.util.Date;
import java.util.UUID;

public interface BaseUserEntity {

  UUID getUserId();

  String getFirstName();

  String getLastName();

  String getOccupation();

  Date getBirthDay();

}
