package ch.learnbees.salarycalculate.controller;

import ch.learnbees.salarycalculate.persistency.dto.WorkerDto;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workers")
public class WorkersController {

    private final WorkerService workerService;

    @Autowired
    public WorkersController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public ResponseEntity<WorkerDto> createWorker(@RequestBody final WorkerDto workerDto){
        WorkerEntity worker = workerService.createWorker(WorkerEntity.from(workerDto));
        return new ResponseEntity<>(WorkerDto.from(worker),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkerDto>> getWorkers(){
        List<WorkerEntity> workerEntities = workerService.getWorkers();
        List<WorkerDto> workerDtos = workerEntities.stream().map(WorkerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(workerDtos,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable final Long id){
       WorkerEntity worker = workerService.getWorker(id);
        return new ResponseEntity<>(WorkerDto.from(worker),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<WorkerDto> deleteWorker(@PathVariable final Long id){
        WorkerEntity worker = workerService.deleteWorker(id);
        return new ResponseEntity<>(WorkerDto.from(worker),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<WorkerDto> updateWorker(@PathVariable final Long id,
                                                  @RequestBody final WorkerDto workerDto){
        WorkerEntity worker = workerService.updateWorker(id, WorkerEntity.from(workerDto));
        return new ResponseEntity<>(WorkerDto.from(worker),HttpStatus.OK);
    }

    @PostMapping(value = "{workerId}/working-hours/{workingHourId}/add")
    public ResponseEntity<WorkerDto> addWorkingHoursToWorker(@PathVariable final Long workerId,
                                                             @PathVariable final Long workingHourId) {
        WorkerEntity worker = workerService.addWorkingHoursToWorker(workerId, workingHourId);
        return new ResponseEntity<>(WorkerDto.from(worker), HttpStatus.OK);
    }

    @DeleteMapping(value = "{workerId}/working-hours/{workingHourId}/remove")
    public ResponseEntity<WorkerDto> removeWorkingHoursFromWorker(@PathVariable final Long workerId,
                                                             @PathVariable final Long workingHourId) {
        WorkerEntity worker = workerService.removeWorkingHoursFromWorker(workerId, workingHourId);
        return new ResponseEntity<>(WorkerDto.from(worker), HttpStatus.OK);
    }

}
