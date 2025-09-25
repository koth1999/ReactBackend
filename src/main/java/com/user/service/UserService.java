package com.user.service;

import com.jwt.TokenProvider;
import com.user.dto.UserTokenDto;
import com.user.dto.request.UserRequestDto;
import com.user.dto.response.UserResponseDto;
import com.user.entity.User;
import com.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    // 회원 로그인
    public UserTokenDto userLogin(UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = userRequestDto.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateToken(authentication);
    }

    // 회원 가입
    public UserRepository signUp(UserRequestDto userRequestDto) {
        if(userRepository.existsByUserId(userRequestDto.getUserId())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        User user = userRequestDto.toUser(passwordEncoder);
        return (UserRepository) UserResponseDto.of(userRepository.save(user));
    }

    // 회원가입 여부
    public boolean checkUserIdExist(String userId) {
        Optional<User> userInfo = userRepository.findByUserId(userId);
        return userInfo.isPresent();
    }

    // 로그인 체크
    public boolean loginCheck(String userId, String password) {
        Optional<User> memberInfo = userRepository.findByUserIdAndPassword(userId, password);
        return memberInfo.isPresent();
    }

    // 유저 아이디로 유저 번호 조회
    public Long getUserNumByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isPresent()) {
            User user1 = user.get();
            return user1.getUserNum();
        }
        return null;
    }

    // 유저 아이디로 유저 이름 조회
    public String getUserNameByUserId(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isPresent()) {
            User user1 = user.get();
            return user1.getName();
        }
        return null;
    }

}
