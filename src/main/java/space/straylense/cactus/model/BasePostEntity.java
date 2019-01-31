package space.straylense.cactus.model;

import java.util.Date;
import java.util.UUID;

public interface BasePostEntity {

  public UUID getPostId();

  public UserEntity getUser();

  public boolean getReportFlag();

  public Date getPostDate();

  public String getPostBody();

  public String getImage();
}
