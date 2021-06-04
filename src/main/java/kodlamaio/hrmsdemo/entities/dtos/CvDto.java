package kodlamaio.hrmsdemo.entities.dtos;

import kodlamaio.hrmsdemo.entities.concretes.Education;
import kodlamaio.hrmsdemo.entities.concretes.JobExperience;
import kodlamaio.hrmsdemo.entities.concretes.Language;
import kodlamaio.hrmsdemo.entities.concretes.Talent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
    private int id;
    private int candidateId;
    private String githubAddress;
    private String linkedinAddress;
    private String description;
    private String photo;
    private LocalDateTime createdDate;
    private Date updatedDate;
    private List<Language> languagesId;
    private List<Talent> talentsId;
    private List<Education> educationsId;
    private List<JobExperience> jobExperiencesId;
}
