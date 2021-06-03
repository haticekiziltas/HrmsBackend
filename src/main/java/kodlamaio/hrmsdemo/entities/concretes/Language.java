package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv_languages")
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
    @Min(1) @Max(5)
    private int languageLevel;
}
