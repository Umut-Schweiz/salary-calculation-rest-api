package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;

import java.util.List;

public interface WorkingHoursService {

    WorkingHoursEntity addWorkingHours(WorkingHoursEntity workingHours);

    List<WorkingHoursEntity> getWorkingsHours();

    WorkingHoursEntity getWorkingHour(Long id);

    WorkingHoursEntity deleteWorkingHour(Long id);

    WorkingHoursEntity updateWorkingHour(Long id, WorkingHoursEntity workingHours);

}
