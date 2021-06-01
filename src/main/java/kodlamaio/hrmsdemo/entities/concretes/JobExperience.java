package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_job_experiances ")
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @Column(name = "workplace_name")
    @NotBlank(message = "boş geçilmez")
    private String workplaceName;


    @ManyToOne(targetEntity = Job.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id", referencedColumnName = "id", nullable = false)
    @NotBlank(message = "boş geçilmez")
    private  Job job;

    @Column(name = "started_date")
    @NotBlank(message = "boş geçilmez")
    private LocalDate startedDate;

    @Column(name = "ended_date")
    private LocalDate endedDate;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
