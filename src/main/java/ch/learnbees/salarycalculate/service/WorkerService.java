package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.controller.model.WorkerViewModel;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;

import java.util.List;

public interface WorkerService {

    WorkerEntity create(WorkerViewModel workerViewModel);

    WorkerEntity findWorker(Long id);

    List<WorkerEntity> getListOfWorkers();

    void deleteWorker(Long id);

    WorkerEntity save(WorkerEntity workerEntity);
}
