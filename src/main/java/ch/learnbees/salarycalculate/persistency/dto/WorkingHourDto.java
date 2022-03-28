package ch.learnbees.salarycalculate.persistency.dto;

import ch.learnbees.salarycalculate.persistency.entity.WorkingHoursEntity;
import lombok.Data;

@Data
public class WorkingHourDto {

    private Long id;
    private Double weekNumber;
    private Double hours;

    public static WorkingHourDto from(WorkingHoursEntity workingHours) {
        WorkingHourDto workingHourDto = new WorkingHourDto();

        workingHourDto.setId(workingHours.getId());
        workingHourDto.setWeekNumber(workingHours.getWeekNumber());
        workingHourDto.setHours(workingHours.getHours());

        return workingHourDto;
    }
}
