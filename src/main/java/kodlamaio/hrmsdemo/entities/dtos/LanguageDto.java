package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    @JsonIgnore
    private int id;
    private int cvId;

    @NotBlank(message = "dil adı boş bırakılamaz")
    private String languageName;

    @Min(value = 1, message = "minimum 1")
    @Max(value = 5, message = "maximum 5")
    private short langLevel;

    private LocalDateTime createdDate;
}
