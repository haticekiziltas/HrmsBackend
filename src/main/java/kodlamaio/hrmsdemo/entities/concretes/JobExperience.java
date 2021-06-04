package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_job_experiances ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @Column(name = "workplace_name")
    @NotBlank(message = "İş yeri adı boş geçilmez")
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

    @NotNull
    @Column(name = "created_date",columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdDate =LocalDateTime.now();
}
