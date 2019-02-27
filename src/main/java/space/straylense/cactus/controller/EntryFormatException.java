package space.straylense.cactus.controller;

public class EntryFormatException extends RuntimeException {

  public EntryFormatException() {
    super("Invalid entry formatting");
  }
}
