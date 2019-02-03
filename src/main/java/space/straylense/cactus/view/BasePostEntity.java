package space.straylense.cactus.view;

import java.util.Date;
import java.util.UUID;
import space.straylense.cactus.model.UserEntity;

public interface BasePostEntity {

  public UUID getPostId();

  public UserEntity getUser();

  public boolean getReportFlag();

  public Date getPostDate();

  public String getPostBody();

  public String getImage();
}
