package ch.learnbees.salarycalculate.persistency.entity;

import ch.learnbees.salarycalculate.persistency.dto.WorkerDto;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String type;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name= "worker_id")
    private List<WorkingHoursEntity> workingHoursEntities = new ArrayList<>();

    public void addWorkingHour(WorkingHoursEntity workingHours){
        workingHoursEntities.add(workingHours);
    }

    public void removeWorkingHour(WorkingHoursEntity workingHours){
        workingHoursEntities.remove(workingHours);
    }

    public static WorkerEntity from(WorkerDto workerDto){
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setFirstname(workerDto.getFirstname());
        workerEntity.setLastname(workerDto.getLastname());
        workerEntity.setType(workerDto.getType());
        return workerEntity;
    }
}

