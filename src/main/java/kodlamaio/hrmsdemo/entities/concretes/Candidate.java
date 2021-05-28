package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
public class Candidate extends User {


    @NotBlank(message = "İsim alanı boş bırakılmaz")
    @Size(min = 3, message = "İsim alanında en az 3 karakter kullanmanız gerekiyor")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Soyisim alanı boş bırakılmaz")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Tc kimlik numarası alanı boş bırakılmaz")
    @Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
    @Column(name = "identification_number")
    private String identificationNumber;

    @NotBlank(message = "Doğum tarihi boş bırakılmaz")
    @Column(name = "birth_date")
    private Date birthDate;
}
