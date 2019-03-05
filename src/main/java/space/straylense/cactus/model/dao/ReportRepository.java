package space.straylense.cactus.model.dao;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import space.straylense.cactus.model.entity.ReportEntity;

public interface ReportRepository extends CrudRepository<ReportEntity, UUID> {

  ReportEntity findAllByReportID(UUID reportId);

  List<ReportEntity> findAllByReportReviewedOrderByReportDateDesc();
}
