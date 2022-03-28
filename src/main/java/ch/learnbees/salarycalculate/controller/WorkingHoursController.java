package ch.learnbees.salarycalculate.controller;

import ch.learnbees.salarycalculate.persistency.dto.WorkingHourDto;
import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import ch.learnbees.salarycalculate.service.WorkingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/working-hours")
public class WorkingHoursController {

    private final WorkingHoursService workingHoursService;

    @Autowired
    public WorkingHoursController(WorkingHoursService workingHoursService) {
        this.workingHoursService = workingHoursService;
    }

    @PostMapping
    public ResponseEntity<WorkingHourDto> addWorkingHour(@RequestBody final WorkingHourDto workingHourDto) {
        //dto => Date Transfer Object
        WorkingHoursEntity workingHours = workingHoursService.addWorkingHours(WorkingHoursEntity.from(workingHourDto));
        return new ResponseEntity<>(WorkingHourDto.from(workingHours),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkingHourDto>> getWorkingHours(){
        List<WorkingHoursEntity> workingHoursEntities = workingHoursService.getWorkingsHours();
        List<WorkingHourDto> workingHoursDto = workingHoursEntities.stream().map(WorkingHourDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(workingHoursDto,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<WorkingHourDto> getWorkingHour(@PathVariable final Long id) {
        WorkingHoursEntity workingHours = workingHoursService.getWorkingHour(id);
        return new ResponseEntity<>(WorkingHourDto.from(workingHours),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<WorkingHourDto> deleteWorkingHour(@PathVariable final Long id) {
        WorkingHoursEntity workingHours = workingHoursService.deleteWorkingHour(id);
        return new ResponseEntity<>(WorkingHourDto.from(workingHours),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<WorkingHourDto> updateWorkingHour(@PathVariable final Long id,
                                                            @RequestBody final WorkingHourDto workingHourDto) {
        WorkingHoursEntity updatedWorkingHour = workingHoursService.updateWorkingHour(id, WorkingHoursEntity.from(workingHourDto));
        return new ResponseEntity<>(WorkingHourDto.from(updatedWorkingHour),HttpStatus.OK);
    }

}
