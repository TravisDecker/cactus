package space.straylense.cactus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import space.straylense.cactus.model.dao.PostRepository;
import space.straylense.cactus.model.dao.UserRepository;
import space.straylense.cactus.model.entity.PostEntity;
import space.straylense.cactus.model.entity.UserEntity;

@RestController
@RequestMapping("/home")
@ExposesResourceFor(PostEntity.class)
public class HomeController {

  private UserRepository userRepository;
  private PostRepository postRepository;

  @Autowired
  public HomeController(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  @GetMapping(value = "{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PostEntity> getHome(@PathVariable("userId") UUID userId) {
    UserEntity user = userRepository.findAllByUserId(userId);
    List<PostEntity> feed = new ArrayList<>();
    for (UserEntity freind : user.getFriends()
    ) {
      feed.addAll(postRepository.findAllByUserOrderByPostDate(user));
    }
    return feed;
  }

//  @PostMapping(value = "{userId}",
//      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity<PostEntity> postPost(@PathVariable("userId") UUID userId,
//      @RequestBody PostEntity post) {
//    UserEntity user = userRepository.findAllByUserId(userId);
//    post.setUser(user);
//    postRepository.save(post);
//    return ResponseEntity.created(post.getHref()).body(post);
//  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}