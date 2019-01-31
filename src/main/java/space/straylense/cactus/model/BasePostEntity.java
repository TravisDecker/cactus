package space.straylense.cactus.model;

import java.util.Date;
import java.util.UUID;

public interface BasePostEntity {

  public UUID getPostId();

  public Date getPostDate();

  public String getPostBody();

  public String getImage();
}
