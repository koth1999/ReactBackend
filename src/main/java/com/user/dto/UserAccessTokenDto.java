package com.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccessTokenDto {

    private String tokenType;
    private String accessToken;
    private String refreshToken;
    private String accessTokenExpiresIn;
    private String refreshTokenExpireseIn;

    public UserAccessTokenDto(String accessToken) {
        accessToken = this.accessToken;
    }
}
