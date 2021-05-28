package kodlamaio.hrmsdemo.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message="Email Alanı Boş olamaz")
    @Column(name="email_address")
    private String emailAdress;

    @NotBlank(message="Şifre Alanı Boş olamaz")
    @Column(name="password")
    private String password;
    
}
