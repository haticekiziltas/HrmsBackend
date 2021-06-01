package kodlamaio.hrmsdemo.entities.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertismentRequestDto {
    @NotNull
    private int cityId;

    @NotNull
    private int employerId;

    @NotNull
    private int jobId;
    private int Id;

    @NotBlank
    @NotNull
    private String description;

    @NotNull
    private Date endDate;

    @NotNull
    @Min(1)
    private int max_salary;

    @NotNull
    @Min(1)
    private int min_salary;


    private boolean active;
}
