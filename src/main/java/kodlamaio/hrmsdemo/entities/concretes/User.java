package kodlamaio.hrmsdemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email(message = "Geçerli bir mail adresi giriniz")
    @NotBlank(message="Email Alanı Boş olamaz")
    @Column(name="email_address")
    private String emailAdress;

    @NotBlank(message="Şifre Alanı Boş olamaz")
    @Size(min=6, max=16, message="Şifre en az 6, en fazla 16 karakterden oluşabilir")
    @Column(name="password")
    private String password;

    @NotBlank(message="Şifre Alanı Boş olamaz")
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password")
    private String passwordRepeat;
    
}
