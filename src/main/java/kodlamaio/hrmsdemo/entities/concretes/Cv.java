package kodlamaio.hrmsdemo.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "candidate_cvs ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
    private Candidate candidate;

    @Column(name = "github_address")
    private String githubAddress;

    @Column (name = "linkedin_address")
    private  String linkedinAddress;

    @Length(max = 250)
    @Column(name = "description")
    private  String description;

    @Column(name = "created_date", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdDate = LocalDateTime.now();

    @Column (name = "is_active")
    private boolean isActive;

    @Column(name = "photo")
    private String photo;


    @OneToMany(mappedBy = "cv" , cascade = CascadeType.ALL )
    private List<Talent> talents;


    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL )
    private List<Education> educations;


    @OneToMany(mappedBy = "cv",  cascade = CascadeType.ALL )
    private List<JobExperience> jobExperiences;


    @OneToMany(mappedBy = "cv",  cascade = CascadeType.ALL )
    private List<Language> languages;




}
