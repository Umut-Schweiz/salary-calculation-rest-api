package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.controller.model.WorkingHoursViewModel;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;

import java.util.List;

public interface WorkingHoursService {

    /*
    Double getTotalWorkingHoursOfAllWorkers();

    Double totalWorkingHoursOfAWorker(Long id);

    WorkingHoursEntity create(WorkingHoursViewModel workingHoursViewModel);

    Double getTotalWagesOfAllWorkers();

    Double getTotalWagesOfAWorker(Long id);

     */

    List<WorkingHoursEntity> getListOfWorkingHoursAllWorkers();

    WorkingHoursEntity findWorker(Long id);
}
