package kodlamaio.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

    private int id;
    private String employerCompanyName;
    private String jobDescription;
    private String jobName;
    private java.sql.Date createdAt;
    private String cityName;
    private Date endDate;

}
