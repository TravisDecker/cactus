package space.straylense.cactus.controller;

import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import space.straylense.cactus.model.UserEntity;
import space.straylense.cactus.model.dao.UserRepository;

@RestController
@RequestMapping("/users")
@ExposesResourceFor(UserEntity.class)
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserEntity> postUser(@RequestBody UserEntity user) {
    userRepository.save(user);
    return ResponseEntity.created(user.getHref()).body(user);
  }

  @GetMapping(value = "{userId}/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserEntity getUser(@PathVariable("userId") UUID userId) {
    return userRepository.findAllByUserId(userId);
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
