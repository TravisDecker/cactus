package space.straylense.cactus.controller;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.straylense.cactus.model.dao.PostRepository;
import space.straylense.cactus.model.dao.ReportRepository;
import space.straylense.cactus.model.dao.UserRepository;
import space.straylense.cactus.model.entity.PostEntity;
import space.straylense.cactus.model.entity.ReportEntity;

@RestController
@RequestMapping("/report")
@ExposesResourceFor(ReportEntity.class)
public class ReportController {

  private UserRepository userRepository;
  private PostRepository postRepository;
  private ReportRepository reportRepository;

  public ReportController(UserRepository userRepository,
      PostRepository postRepository,
      ReportRepository reportRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.reportRepository = reportRepository;
  }

  @PostMapping(value = "{postId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ReportEntity> postReportPost(@RequestBody ReportEntity report) {
    PostEntity postEntity = report.getReportedPost();
    postEntity.setReportFlag(true);
    postRepository.save(postEntity);

    return ResponseEntity.created(report.getHref()).body(report);
  }
}
