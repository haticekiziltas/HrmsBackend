package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Language {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Cv.class)
    @JoinColumn(name = "cv_id")
    private Cv cv;

    @NotBlank(message = "Dil  adı boş geçilemez")
    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    @Min(value = 1, message = "Minimum 1 ")
    @Max(value = 5, message = "Maximum 5")
    private short languageLevel;

    @Column(name = "created_date")
    private final LocalDateTime createdDate =LocalDateTime.now();
}
