package kodlamaio.hrmsdemo.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table (name = "job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertises"})
@AllArgsConstructor
@NoArgsConstructor
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
	private int id;
	
	@Column (name ="position")
	@NotBlank(message="Başlık Alanı Boş olamaz")
	private String jobName;

    @JsonIgnore
	@OneToMany(mappedBy = "job")
	private List<JobAdvertisement> jobAdvertisements;
	
	 
}
