package com.user.repository;

import com.user.entity.UserRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshToken, Long> {

    Optional<UserRefreshToken> findByUserId(String userId);

    Optional<UserRefreshToken> findByUserRefreshToken(String userRefreshToken);
}
