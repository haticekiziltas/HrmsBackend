package kodlamaio.hrmsdemo.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    @Type(type = "text")
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "number_of_open_position")
    private int numberOfOpenPosition;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private java.util.Date createdAt;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "application_deadline")
    private Date applicationDeadLine;


    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


}
