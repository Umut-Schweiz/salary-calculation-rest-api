package ch.learnbees.salarycalculate.service;

import ch.learnbees.salarycalculate.controller.model.WorkerViewModel;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.persistency.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultWorkerService implements WorkerService{

    private final WorkerRepository workerRepository;

    public DefaultWorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerEntity> getListOfWorkers() {
        return (List<WorkerEntity>) this.workerRepository.findAll();
    }

    @Override
    public WorkerEntity create(WorkerViewModel workerViewModel) {
        return this.workerRepository
                .save(new WorkerEntity(workerViewModel.getFirstname(), workerViewModel.getLastname(), workerViewModel.getType()));
    }

    @Override
    public WorkerEntity findWorker(Long id) {
        return this.workerRepository.findById(id).get();
    }

    @Override
    public void deleteWorker(Long id) {
        this.workerRepository.deleteById(id);
    }

    @Override
    public WorkerEntity save(WorkerEntity workerEntity) {

        return workerRepository.save(workerEntity);
    }


}
