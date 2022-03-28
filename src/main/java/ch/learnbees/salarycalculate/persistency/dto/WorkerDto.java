package ch.learnbees.salarycalculate.persistency.dto;

import ch.learnbees.salarycalculate.persistency.entity.WorkerEntity;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class WorkerDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String type;
    private List<WorkingHourDto> workingHoursDto = new ArrayList<>();

    public static WorkerDto from(WorkerEntity workerEntity) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(workerEntity.getId());
        workerDto.setFirstname(workerEntity.getFirstname());
        workerDto.setLastname(workerEntity.getLastname());
        workerDto.setType(workerEntity.getType());
        workerDto.setWorkingHoursDto(workerEntity.getWorkingHoursEntities().stream().map(WorkingHourDto::from).collect(Collectors.toList()));
        return workerDto;
    }
}
