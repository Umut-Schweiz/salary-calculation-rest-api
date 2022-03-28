package ch.learnbees.salarycalculate.persistency.repository;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {

      WorkerEntity findById(long id);
}
