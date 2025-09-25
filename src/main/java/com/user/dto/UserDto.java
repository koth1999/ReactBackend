package com.user.dto;

import com.constant.Existence;
import com.constant.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    private String userId;
    private String password;
    private String phone;
    private String email;
    private String name;
    private LocalDate birth;
    private LocalDate signUpTime;
    private Gender gender;
    private Existence existence;
}
