package space.straylense.cactus.controller;

public class DupliacteResourcesException extends RuntimeException {

  public DupliacteResourcesException() {
    super("Duplicate Resource");
  }
}
