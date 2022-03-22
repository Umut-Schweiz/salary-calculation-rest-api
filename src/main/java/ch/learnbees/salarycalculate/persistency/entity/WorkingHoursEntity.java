package ch.learnbees.salarycalculate.persistency.entity;

import javax.persistence.*;

@Entity
@Table (name = "workingHours")
public class WorkingHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weekNumber;
    private Double hours;

    @OneToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity workerEntity;

    public WorkingHoursEntity() {
    }

    public WorkingHoursEntity(Double weekNumber, Double hours ) {
        this.weekNumber = weekNumber;
        this.hours = hours;
    }

    public WorkingHoursEntity(WorkerEntity worker1, double v, double v1) {
    }

    public Long getId() {
        return id;
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

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }
}
