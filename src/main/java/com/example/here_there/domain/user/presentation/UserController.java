package com.example.here_there.domain.user.presentation;

import com.example.here_there.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.here_there.domain.user.presentation.dto.request.UpdateUserInterestRequest;
import com.example.here_there.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.here_there.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.here_there.domain.user.presentation.dto.response.TokenResponse;
import com.example.here_there.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.here_there.domain.user.service.UpdateUserImageService;
import com.example.here_there.domain.user.service.UpdateUserInfoService;
import com.example.here_there.domain.user.service.UpdateUserInterestService;
import com.example.here_there.domain.user.service.UserInfoService;
import com.example.here_there.domain.user.service.UserLoginService;
import com.example.here_there.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserSignupService userSignupService;
    private final UserInfoService userInfoService;
    private final UpdateUserInfoService updateUserInfoService;
    private final UserLoginService userLoginService;
    private final UpdateUserInterestService updateUserInterestService;
    private final UpdateUserImageService updateUserImageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @GetMapping("/profile")
    public UserInfoResponse userInfo() {
        return userInfoService.execute();
    }

    @PatchMapping("profile")
    public void userInfoUpdate(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request){
        return userLoginService.execute(request);
    }

    @PatchMapping("/interest")
    public void updateUserInterest(@RequestBody @Valid UpdateUserInterestRequest request) {
        updateUserInterestService.execute(request);
    }

    @PatchMapping("/image")
    public void updateUserImage(@RequestParam("file") MultipartFile file) throws Exception{
        updateUserImageService.execute(file);
    }
}
