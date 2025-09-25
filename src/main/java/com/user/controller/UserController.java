package com.user.controller;

import com.user.dto.UserTokenDto;
import com.user.dto.request.UserRequestDto;
import com.user.dto.response.UserResponseDto;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<UserTokenDto> userLogin(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.userLogin(userRequestDto));
    }

    // 회원가입
    @PostMapping("/new")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok((UserResponseDto) userService.signUp(userRequestDto));
    }

    // 회원가입 중복
    @GetMapping("/doubleCheck")
    public ResponseEntity<Boolean> doubleCheck(@RequestParam("userId") String userId) {
        boolean result = userService.checkUserIdExist(userId);
        if(result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

}
