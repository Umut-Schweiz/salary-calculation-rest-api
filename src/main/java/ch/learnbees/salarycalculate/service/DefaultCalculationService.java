package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.exception.WorkerNotFoundException;
import ch.learnbees.salarycalculate.persistency.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCalculationService implements CalculationService{

    private final double COST_PER_HOUR_OF_DISABLED = 10;
    private final double COST_PER_HOUR_OF_LAZY = 23;
    private final double COST_PER_HOUR_OF_CHILD = 10;
    private final double COST_PER_HOUR_OF_GOOD = 40;

    private final WorkerRepository workerRepository;
    private final WorkingHoursService workingHoursService;

    @Autowired
    public DefaultCalculationService(WorkerRepository workerRepository, WorkingHoursService workingHoursService) {
        this.workerRepository = workerRepository;
        this.workingHoursService = workingHoursService;
    }

    @Override
    public Double getTotalHoursOfAWorker(Long id) {
        WorkerEntity worker = workerRepository.findById(id).orElseThrow( () ->
                new WorkerNotFoundException(id));
        List<WorkingHoursEntity> workingHours = worker.getWorkingHoursEntities();
        double totalWorkingHoursOfAWorker = 0;

        for (int index = 0; index < workingHours.size(); index++) {
            totalWorkingHoursOfAWorker += workingHours.get(index).getHours();
        }

        return totalWorkingHoursOfAWorker;
    }

    @Override
    public Double getTotalCostsOfAWorker(Long id) {
        WorkerEntity worker = workerRepository.findById(id).orElseThrow( () ->
                new WorkerNotFoundException(id));
        List<WorkingHoursEntity> workingHours = worker.getWorkingHoursEntities();

        double totalWorkingCostsOfAWorker = 0;

        for (int index = 0; index < workingHours.size(); index++) {

            String workerType = worker.getType();

            switch (workerType){
                case "Disabled":
                    totalWorkingCostsOfAWorker += workingHours.get(index).getHours() * COST_PER_HOUR_OF_DISABLED;
                    break;
                case "Lazy":
                    totalWorkingCostsOfAWorker += workingHours.get(index).getHours() * COST_PER_HOUR_OF_LAZY;
                    break;
                case "Child":
                    totalWorkingCostsOfAWorker += workingHours.get(index).getHours() * COST_PER_HOUR_OF_CHILD;
                    break;
                case "Good":
                    totalWorkingCostsOfAWorker += workingHours.get(index).getHours() * COST_PER_HOUR_OF_GOOD;
                    break;
            }
        }

        return totalWorkingCostsOfAWorker;
    }
}
