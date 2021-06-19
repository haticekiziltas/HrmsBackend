package kodlamaio.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    private int id;
    private String employerCompanyName;
    private String jobDescription;
    private String jobName;
    private LocalDateTime createdAt= LocalDateTime.now();
    private String cityName;
    private int numberOfOpenPosition;
    private String workingTimeTitle;
    private String wayOfWorkingTitle;
    private Date endDate;
    private  boolean active;

}
