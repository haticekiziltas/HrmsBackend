package kodlamaio.hrmsdemo.entities.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementRequestDto {
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
   @PositiveOrZero
    private int max_salary;

    @NotNull
    @PositiveOrZero
    private int min_salary;


    private boolean active;

    @NotNull
    private int workingTimeId;
    @NotNull
    private int wayOfWorkingId;
}
