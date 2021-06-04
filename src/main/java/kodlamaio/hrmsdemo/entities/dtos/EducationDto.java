package kodlamaio.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
    private int id;
    private int cvId;
    private String schoolName;
    private int graduateId;
    private String schoolDepartment;
    private LocalDate startedDate;
    private LocalDate endedDate;
    private LocalDateTime createdDate;
}
