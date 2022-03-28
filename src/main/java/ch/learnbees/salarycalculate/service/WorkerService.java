package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;

import java.util.List;

public interface WorkerService {

    WorkerEntity createWorker(WorkerEntity workerEntity);

    List<WorkerEntity> getWorkers();

    WorkerEntity getWorker(Long id);

    WorkerEntity deleteWorker(Long id);

    WorkerEntity updateWorker(Long id, WorkerEntity workerEntity);

    WorkerEntity addWorkingHoursToWorker(Long workerId, Long workingHourId);

    WorkerEntity removeWorkingHoursFromWorker(Long workerId, Long workingHourId);

}
