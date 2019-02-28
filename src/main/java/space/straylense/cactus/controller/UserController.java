package space.straylense.cactus.controller;

import java.util.ArrayList;
import java.util.List;
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
import space.straylense.cactus.model.dao.PostRepository;
import space.straylense.cactus.model.dao.UserRepository;
import space.straylense.cactus.model.entity.PostEntity;
import space.straylense.cactus.model.entity.UserEntity;

@RestController
@RequestMapping("/users")
@ExposesResourceFor(UserEntity.class)
public class UserController {

  private UserRepository userRepository;
  private PostRepository postRepository;

  @Autowired
  public UserController(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  //TODO Do something other than nothing when user attempts to post a duplicate user.
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserEntity> postUser(@RequestBody UserEntity user)
      throws DuplicateResourcesException {
    if (checkScreenName(user)) {
      user.setScreenName(user.getScreenName().toUpperCase());
      userRepository.save(user);
      return ResponseEntity.created(user.getHref()).body(user);
    }
    return null;
  }

  public boolean checkScreenName(UserEntity user)
      throws DuplicateResourcesException, EntryFormatException {
    if (user.getScreenName().contains(" ")) {
      throw new EntryFormatException();
    }
    if (userRepository.findAllByScreenName(user.getScreenName().toUpperCase()) != null) {
      throw new DuplicateResourcesException();
    }
    return true;
  }

  @PostMapping(value = "{userId}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PostEntity> postPost(@PathVariable("userId") UUID userId,
      @RequestBody PostEntity post) {
    UserEntity user = userRepository.findAllByUserId(userId);
    post.setUser(user);
    postRepository.save(post);
    return ResponseEntity.created(post.getHref()).body(post);
  }

  @GetMapping(value = "id/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserEntity getUserById(@PathVariable("userId") UUID userId) {
    return userRepository.findAllByUserId(userId);
  }

  @GetMapping(value = "{screenName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> getUserByScreenName(@PathVariable("screenName") String screenName) {
    return userRepository.findAllByScreenNameContaining(screenName);
  }

  @GetMapping(value = "searchbyname/{partialName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> getUserByPartialName(@PathVariable("partialName") String partialName) {
    List<UserEntity> result = new ArrayList<>();
    String[] names;
    if (partialName.contains(" ")) {
      names = partialName.split(" ");
      result = userRepository.findAllByFirstNameContainsOrLastNameContains(names[0], names[1]);
    } else {
      result.addAll(userRepository.findAllByFirstNameContains(partialName));
      result.addAll(userRepository.findAllByLastNameContains(partialName));
    }

    return result;
  }


  @PostMapping(value = "addfriend/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserEntity> addFriend(@PathVariable("userId") UUID userId,
      @RequestBody UserEntity friend) {
    UserEntity user = userRepository.findAllByUserId(userId);
    user.getFriends().add(friend);
    userRepository.save(user);
    return ResponseEntity.created(user.getHref()).body(user);
  }


  public List<UserEntity> getUserByLastName(String lastName) {
    return userRepository.findAllByLastNameContains(lastName);
  }

  public List<UserEntity> getUserByFirstName(String firstName) {
    return userRepository.findAllByFirstNameContains(firstName);
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Conflict, Duplicate Resource")
  @ExceptionHandler({DuplicateResourcesException.class})
  public void duplicateResource() {

  }

}
