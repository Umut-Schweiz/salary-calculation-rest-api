package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.exception.WorkerNotFoundException;
import ch.learnbees.salarycalculate.persistency.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DefaultWorkerService implements WorkerService{

    private final WorkerRepository workerRepository;
    private final WorkingHoursService workingHoursService;

    @Autowired
    public DefaultWorkerService(WorkerRepository workerRepository, WorkingHoursService workingHoursService) {
        this.workerRepository = workerRepository;
        this.workingHoursService = workingHoursService;
    }

    @Override
    public WorkerEntity createWorker(WorkerEntity workerEntity) {
        return workerRepository.save(workerEntity);
    }

    @Override
    public List<WorkerEntity> getWorkers() {
        return StreamSupport
                .stream(workerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public WorkerEntity getWorker(Long id) {
        return workerRepository.findById(id).orElseThrow( () ->
                new WorkerNotFoundException(id));
    }

    @Override
    public WorkerEntity deleteWorker(Long id) {
        WorkerEntity worker = getWorker(id);
        workerRepository.delete(worker);
        return worker;
    }
    @Transactional
    @Override
    public WorkerEntity updateWorker(Long id, WorkerEntity workerEntity) {
        WorkerEntity workerToEdit = getWorker(id);
        workerToEdit.setFirstname(workerEntity.getFirstname());
        workerToEdit.setLastname(workerEntity.getLastname());
        workerToEdit.setType(workerEntity.getType());
        return workerToEdit;
    }
    @Transactional
    @Override
    public WorkerEntity addWorkingHoursToWorker(Long workerId, Long workingHourId) {
        WorkerEntity worker = getWorker(workerId);
        WorkingHoursEntity workingHours = workingHoursService.getWorkingHour(workingHourId);
        worker.addWorkingHour(workingHours);

        return worker;
    }
    @Transactional
    @Override
    public WorkerEntity removeWorkingHoursFromWorker(Long workerId, Long workingHourId) {
        WorkerEntity worker = getWorker(workerId);
        WorkingHoursEntity workingHours = workingHoursService.getWorkingHour(workingHourId);
        worker.removeWorkingHour(workingHours);
        return worker;
    }

}
