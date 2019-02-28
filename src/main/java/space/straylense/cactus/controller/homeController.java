package space.straylense.cactus.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import space.straylense.cactus.model.entity.CommentEntity;
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


  //TODO needs further testing
  @GetMapping(value = "{userId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PostEntity> getFeed(@PathVariable("userId") UUID userId) {
    UserEntity user = userRepository.findAllByUserId(userId);
    List<PostEntity> feed = new ArrayList<>();
    for (UserEntity freind : user.getFriends()) {
      feed.addAll(postRepository.findAllByUserOrderByPostDate(freind));
      feed.addAll(postRepository.findAllByUserOrderByPostDate(user));
    }
    Collections.sort(feed);
    Collections.reverse(feed);
    return feed;
  }


  @GetMapping(value = "{postId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CommentEntity> getComments(@PathVariable("postId") UUID postId) {
    return postRepository.findAllByPostId(postId).getComments();
  }

  @PostMapping(value = "{postId}", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CommentEntity> postComment(@PathVariable("postId") UUID postID,
      @RequestBody CommentEntity comment) {
    PostEntity post = postRepository.findAllByPostId(postID);
    post.getComments().add(comment);
    postRepository.save(post);
    return ResponseEntity.created(comment.getHref()).body(comment);
  }


  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
