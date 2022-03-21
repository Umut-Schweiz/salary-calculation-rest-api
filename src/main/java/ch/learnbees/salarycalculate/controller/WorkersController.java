package ch.learnbees.salarycalculate.controller;


import ch.learnbees.salarycalculate.controller.model.WorkerViewModel;
import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersController {

    private final WorkerService workerService;

    public WorkersController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkerEntity>> getListOfWorkers(){
        System.out.println("get list of workers!");
        // get info from service
        List<WorkerEntity> workerEntityList = this.workerService.getListOfWorkers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(workerEntityList);
        //.body(Arrays.asList(new WorkersViewModel("marc", "zuckerberg" , "good")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerEntity> getWorkerById(@PathVariable("id") Long id){
        System.out.println("get a worker by his/her id");
        // get info from database
        WorkerEntity existingWorkerEntity = this.workerService.findWorker(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(existingWorkerEntity);
    }

    @PostMapping
    public ResponseEntity createAWorker(@RequestBody WorkerViewModel workerViewModel){
        System.out.println("create a new Worker" + workerViewModel);
        // save info into database
        WorkerEntity newWorkerEntity = this.workerService.create(workerViewModel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newWorkerEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateWorkerById(
            @PathVariable("id") Long workerId,
            @RequestBody WorkerViewModel workerViewModel
    ){

        WorkerEntity workerEntity = this.workerService.findWorker(workerId);
        workerEntity.setFirstname(workerViewModel.getFirstname());
        workerEntity.setLastname(workerViewModel.getLastname());
        workerEntity.setType(workerViewModel.getType());

        final WorkerEntity updatedWorker = workerService.save(workerEntity);

        System.out.println("replace worker!");
        // replace the entity in the database

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWorkerById(@PathVariable("id") Long id){
        System.out.println("delete worker!");
        // delete entity via service from the database
        this.workerService.deleteWorker(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
