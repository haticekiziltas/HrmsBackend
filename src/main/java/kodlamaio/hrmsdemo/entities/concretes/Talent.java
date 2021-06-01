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
@Table(name = "cv_talents ")
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   @ManyToOne(targetEntity = Cv.class)
   @JoinColumn(name = "cv_id")
    private Cv cv;

    @Column(name = "talent_title")
    @NotBlank(message = "boş geçilmez")
    private String talentTitle;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
