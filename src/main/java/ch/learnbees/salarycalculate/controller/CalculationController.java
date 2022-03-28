package ch.learnbees.salarycalculate.controller;

import ch.learnbees.salarycalculate.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculates")
public class CalculationController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(value = "{workerId}/hours")
    public ResponseEntity getTotalHoursOfAWorker(@PathVariable final Long workerId){
        Double result = calculationService.getTotalHoursOfAWorker(workerId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping(value = "{workerId}/costs")
    public ResponseEntity getTotalCostsOfAWorker(@PathVariable final Long workerId){
        Double result = calculationService.getTotalCostsOfAWorker(workerId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
