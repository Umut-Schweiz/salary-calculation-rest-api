package ch.learnbees.salarycalculate.controller.model;

public class WorkingHoursViewModel {

    private Double weekNumber;
    private Double hours;

    public WorkingHoursViewModel() {
    }

    public WorkingHoursViewModel(Double weekNumber, Double hours) {
        this.weekNumber = weekNumber;
        this.hours = hours;
    }

    public Double getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Double weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }
}
