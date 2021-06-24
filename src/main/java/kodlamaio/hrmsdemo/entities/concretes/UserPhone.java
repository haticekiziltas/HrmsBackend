package kodlamaio.hrmsdemo.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_phones")
public class UserPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userPhone;

    @Column (name = "phone_number")
    private String phoneNumber;
}
