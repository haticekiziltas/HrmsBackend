package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates_cv ")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Candidate.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
    private Candidate candidate;

    @Column(name = "github_address")
    private String githubAddress;

    @Column (name = "linkedin_address")
    private  String linkedinAddress;

    @Column(name = "description")
    private  String description;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column (name = "is_active")
    private boolean isActive;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "cv")
    private List<Talent> talents;

    @OneToMany(mappedBy = "cv")
    private List<Education> educations;

    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;




}
