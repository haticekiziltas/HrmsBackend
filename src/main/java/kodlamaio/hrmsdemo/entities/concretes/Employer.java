package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@NoArgsConstructor
@AllArgsConstructor

public class Employer extends User {
    @NotBlank(message="Şirket İsmi Alanı Boş Olamaz")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message="Web sitesi Alanı Boş Olamaz")
    @NotNull(message = "Web Adresi Alanı Boş olamaz")
    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "verify")
    private boolean verify=false;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;


    @Column(name = "phone_number")
    private String phoneNumber;





}
