package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "cv_educations")
public class Education {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @Column(name = "school_name")
    @NotBlank(message = "  Okul adı boş geçilemez")
    private String schoolName;


    @ManyToOne(targetEntity = Graduate.class)
    @JoinColumn(name = "graduate_id", referencedColumnName = "id", nullable = false)
    private Graduate graduate;

    @Column(name = "school_department")
    @NotBlank(message = "Bölüm adı boş geçilemez")
    private String schoolDepartment;

    @Column(name = "started_date")
    private LocalDate StartedDate;

    @Column(name = "ended_date")
    private LocalDate endedDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    /*    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private java.util.Date createdDate;
    Database'de timestamp with time zone
    */
}
