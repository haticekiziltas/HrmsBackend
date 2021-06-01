package kodlamaio.hrmsdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
    @NotBlank(message = "İsim Alanı Boş Bırakılamaz")
    @Column(name="first_name")
    private String firstName;


    @NotBlank(message = "Soyisim Alanı Boş Bırakılamaz")
    @Column(name = "last_name")
    private String lastName;
}
