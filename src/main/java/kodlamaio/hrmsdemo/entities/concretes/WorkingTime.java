package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "working_times")
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "working_time_title")
    private String workingTimeTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "workingTime")
    private List<JobAdvertisement> advertisement;
}

