package ch.learnbees.salarycalculate.persistency.repository;

import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkingHoursRepository extends CrudRepository<WorkingHoursEntity, Long> {

    WorkingHoursEntity findById(long id);
}
