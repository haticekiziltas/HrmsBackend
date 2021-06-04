package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_talents ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
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
    private final LocalDateTime createdDate =LocalDateTime.now();
}
