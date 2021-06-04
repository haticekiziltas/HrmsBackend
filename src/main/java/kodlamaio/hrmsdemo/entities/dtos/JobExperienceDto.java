package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
    @JsonIgnore
    private int id;
    private int cvId;
    private String companyName;
    private LocalDate startedDate;
    private LocalDate endedDate;
    private int jobTitleId;
    @JsonIgnore
    private LocalDateTime createdDate = LocalDateTime.now();
}
