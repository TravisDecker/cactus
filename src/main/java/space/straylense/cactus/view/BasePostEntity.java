package space.straylense.cactus.view;

import java.util.Date;
import java.util.UUID;

public interface BasePostEntity {

  public UUID getPostId();

  public boolean getReportFlag();

  public int getBumps();

  public Date getPostDate();

  public String getPostBody();

  public String getImage();
}
