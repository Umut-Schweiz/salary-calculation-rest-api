package ch.learnbees.salarycalculate.service;

public interface CalculationService {

    Double getTotalHoursOfAWorker(Long id);
    Double getTotalCostsOfAWorker(Long id);
}
