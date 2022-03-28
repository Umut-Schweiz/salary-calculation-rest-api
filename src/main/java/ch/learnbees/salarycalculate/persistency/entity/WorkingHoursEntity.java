package ch.learnbees.salarycalculate.persistency.entity;

import ch.learnbees.salarycalculate.persistency.dto.WorkingHourDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "WorkingHours")
public class WorkingHoursEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weekNumber;
    private Double hours;
    @ManyToOne
    private WorkerEntity workerEntity;

    public static WorkingHoursEntity from(WorkingHourDto workingHourDto){
        WorkingHoursEntity workingHours = new WorkingHoursEntity();
        workingHours.setWeekNumber(workingHourDto.getWeekNumber());
        workingHours.setHours(workingHourDto.getHours());

        return workingHours;
    }

}
