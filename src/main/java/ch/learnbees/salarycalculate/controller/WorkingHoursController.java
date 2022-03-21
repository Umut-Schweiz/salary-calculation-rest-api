package ch.learnbees.salarycalculate.controller;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.service.WorkingHoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculates")
public class WorkingHoursController {

    private final WorkingHoursService workingHoursService;

    public WorkingHoursController(WorkingHoursService workingHoursService) {
        this.workingHoursService = workingHoursService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkingHoursEntity>> getListOfWorkingHoursAllWorkers(){
        System.out.println("get list of workers!");
        // get info from service
        List<WorkingHoursEntity> workingHoursListOfAllWorkers = this.workingHoursService.getListOfWorkingHoursAllWorkers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(workingHoursListOfAllWorkers);
    }

    /*
    @GetMapping("/hours")
    public ResponseEntity<Double> getTotalWorkingHoursOfAllWorkers() {
        System.out.println("get  total working hours of all workers");
        // get info from service
        Double totalWorkingHoursOfWorkers = this.workingHoursService.getTotalWorkingHoursOfAllWorkers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(totalWorkingHoursOfWorkers);
        //.body("567");
    }

    @GetMapping("/hours/{id}")
    public ResponseEntity<Double> getTotalWorkingHoursOfAWorker(@PathVariable("worker_id") Long id) {
        System.out.println("get total working hours of a worker his/her id");
        // get info from database

        Double totalWorkingHoursOfAWorker = this.workingHoursService.totalWorkingHoursOfAWorker(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(totalWorkingHoursOfAWorker);
    }

    @GetMapping("/wages")
    public ResponseEntity<Double> getTotalWagesOfAllWorkers() {
        System.out.println("get  total wages of all workers");
        // get info from service
        Double totalWagesOfAllWorkers = this.workingHoursService.getTotalWagesOfAllWorkers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(totalWagesOfAllWorkers);
        //.body("567");
    }

    @GetMapping("/wages/{id}")
    public ResponseEntity<Double> getTotalWagesOfAWorker(@PathVariable("worker_id") Long id) {
        System.out.println("get total wages of a worker his/her id");
        // get info from database

        Double totalWagesOfAWorker = this.workingHoursService.getTotalWagesOfAWorker(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(totalWagesOfAWorker);
    }
    /*
    @PutMapping("/{id}")
    public ResponseEntity updateWorkerById(
            @PathVariable("id") Long workerId,
            @RequestBody WorkerViewModel workerViewModel
    ) {

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


    /*
    @PostMapping
    public ResponseEntity createWorkingHoursOfAWorker(@RequestBody WorkingHoursViewModel workingHoursViewModel) {
        System.out.println("create working hours of a worker" + workingHoursViewModel);
        // save info into database
        WorkingHoursEntity createdWorkingHoursEntity = this.workingHoursService.create(workingHoursViewModel);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdWorkingHoursEntity);
    }





    @DeleteMapping("/{id}")
    public ResponseEntity deleteWorkerById(@PathVariable("id") Long id) {
        System.out.println("delete worker!");
        // delete entity via service from the database
        this.workerService.deleteWorker(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
 */
}
