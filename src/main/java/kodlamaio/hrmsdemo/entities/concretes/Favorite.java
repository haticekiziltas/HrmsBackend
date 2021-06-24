package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne (targetEntity = JobAdvertisement.class)
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @Column(name = "created_date")
    private LocalDateTime  createdDate = LocalDateTime.now();
}
