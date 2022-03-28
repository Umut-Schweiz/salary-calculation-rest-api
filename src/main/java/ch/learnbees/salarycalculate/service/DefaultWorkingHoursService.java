package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.exception.WorkingHoursNotFoundException;
import ch.learnbees.salarycalculate.persistency.repository.WorkingHoursRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultWorkingHoursService implements WorkingHoursService {

    private final WorkingHoursRepository workingHoursRepository;
    public DefaultWorkingHoursService(WorkingHoursRepository repository) {
        this.workingHoursRepository = repository;
    }

    @Override
    public WorkingHoursEntity addWorkingHours(WorkingHoursEntity workingHours) {
        return workingHoursRepository.save(workingHours);
    }

    @Override
    public List<WorkingHoursEntity> getWorkingsHours() {
        return StreamSupport
                .stream(workingHoursRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public WorkingHoursEntity getWorkingHour(Long id) {
        return workingHoursRepository.findById(id).orElseThrow(() ->
                new WorkingHoursNotFoundException(id));
    }

    @Override
    public WorkingHoursEntity deleteWorkingHour(Long id) {
        WorkingHoursEntity workingHours = getWorkingHour(id);
        workingHoursRepository.delete(workingHours);
        return workingHours;
    }

    @Transactional
    @Override
    public WorkingHoursEntity updateWorkingHour(Long id, WorkingHoursEntity workingHours) {
        WorkingHoursEntity workingHoursToUpdate = getWorkingHour(id);
        workingHoursToUpdate.setWeekNumber(workingHours.getWeekNumber());
        workingHoursToUpdate.setHours(workingHours.getHours());
        return workingHoursToUpdate;
    }
}
