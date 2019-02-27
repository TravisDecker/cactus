package space.straylense.cactus.controller;

public class DuplicateResourcesException extends RuntimeException {

  public DuplicateResourcesException() {
    super("Duplicate Resource");
  }
}
