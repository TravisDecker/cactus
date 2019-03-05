package space.straylense.cactus.controller;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.straylense.cactus.model.dao.PostRepository;
import space.straylense.cactus.model.dao.ReportRepository;
import space.straylense.cactus.model.dao.UserRepository;
import space.straylense.cactus.model.entity.ReportEntity;

@RestController
@RequestMapping("/report")
@ExposesResourceFor(ReportEntity.class)
public class ReportController {

  private UserRepository userRepository;
  private PostRepository postRepository;
  private ReportRepository reportRepositor;

  public ReportController(UserRepository userRepository,
      PostRepository postRepository,
      ReportRepository reportRepositor) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.reportRepositor = reportRepositor;
  }


}
