package com.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserRefreshToken {

    @Id
    @GeneratedValue
    @Column(name = "token_num")
    private Long num;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userRefreshToken;

    public UserRefreshToken(String userId, String userRefreshToken) {
        this.userId = userId;
        this.userRefreshToken = userRefreshToken;
    }

    public UserRefreshToken setRefreshToken(String newRefreshToken) {
        this.userRefreshToken = userRefreshToken;
        return this;
    }
}
