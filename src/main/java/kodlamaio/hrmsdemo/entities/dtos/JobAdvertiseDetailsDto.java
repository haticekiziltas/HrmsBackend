package kodlamaio.hrmsdemo.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertiseDetailsDto {

    private int id;
    private String companyName;
    private String jobDescription;
    private String jobName;
    private LocalDateTime createdAt;
    private String cityName;
    private LocalDate applicationDeadLine;

}
