package kodlamaio.hrmsdemo.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvRequestDto {

    private int id;
    private int candidateId;
    private String linkedinAddress;
    private String githubAddress;
    private String photo;
    private String description;
}
