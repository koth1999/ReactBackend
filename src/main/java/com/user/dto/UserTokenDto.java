package com.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokenDto {

    private String grantType;
    private String accessToken; // 토큰의 유형(Bearer)
    private String refreshToken; // 통신으로 주고 받을 엑세스 토큰
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn; // 만료 시간
    private String authority;
}
