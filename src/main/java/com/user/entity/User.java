package com.user.entity;

import com.constant.Existence;
import com.constant.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.factory.spi.GeneratorDefinitionResolver;

import java.time.LocalDate;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNum;
    @Column(name = "USER_ID", unique = true)
    private String userId;
    private String name;
    private String password;
    private String phone;
    private LocalDate birth;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Existence existence;
    private LocalDate signUpTime;

    @Builder
    public User(String userId, String password, String name, String phone, LocalDate birth, String email, Gender gender, Existence existence, LocalDate signUpTime) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.gender = gender;
        this.existence = existence;
        this.signUpTime = signUpTime;
    }
}
