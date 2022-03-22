package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.controller.model.WorkingHoursViewModel;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.repository.WorkingHoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultWorkingHoursService implements WorkingHoursService {

    private final WorkingHoursRepository workingHoursRepository;

    public DefaultWorkingHoursService(WorkingHoursRepository repository) {
        this.workingHoursRepository = repository;
    }


    @Override
    public List<WorkingHoursEntity> getListOfWorkingHoursAllWorkers() {

        return (List<WorkingHoursEntity>) this.workingHoursRepository.findAll();
    }

    @Override
    public WorkingHoursEntity findWorker(Long id) {
        return this.workingHoursRepository.findById(id).get();
    }

    /*
    @Override
    public Double getTotalWorkingHoursOfAllWorkers() {
        return null;
    }

    @Override
    public Double totalWorkingHoursOfAWorker(Long id) {
        Optional<WorkingHoursEntity> totalHoursOfAWorker = Optional.ofNullable(this.workingHoursRepository.findById(id).orElse(null));
        return totalHoursOfAWorker.get().getHours();
    }

    @Override
    public WorkingHoursEntity create(WorkingHoursViewModel workingHoursViewModel) {
        return this.workingHoursRepository
                .save(new WorkingHoursEntity(workingHoursViewModel.getWeekNumber(),workingHoursViewModel.getHours()));
    }

    @Override
    public Double getTotalWagesOfAllWorkers() {

        Iterable<WorkingHoursEntity> totalWagesOfAllWorker = this.workingHoursRepository.findAll();
        Double result = 0.0;

        for(WorkingHoursEntity workingHours: totalWagesOfAllWorker){
            result+=workingHours.getHours()*15*workingHours.getWeekNumber();
        }
        return result;
    }

    @Override
    public Double getTotalWagesOfAWorker(Long id) {
        Optional<WorkingHoursEntity> totalWagesOfAWorker = Optional.ofNullable(this.workingHoursRepository.findById(id).orElse(null));
        return totalWagesOfAWorker.get().getHours() * totalWagesOfAWorker.get().getWeekNumber() * 15;
    }


    public long getTotalWage() {
        this.hours = hours;
        this.weekNumber = weekNumber;

        long totalWage = 0;

        switch (this.type) {
            case "lazyWorker":
                totalWage = weekNumber * 23 * 20;
                hours= 20L;
                break;
            case "childWorker":
                totalWage = weekNumber * 10 * 30 ;
                hours= 30L;
                break;
            case "goodWorker":
                totalWage = weekNumber * 160;
                hours= 40L;
                break;
            case "disabledWorker":
                totalWage = weekNumber * 100;
                hours= 10L;
                break;
        }
        return totalWage;
    }


    */
}
