package edu.miu.waa.lab5.controller;


import edu.miu.waa.lab5.domain.dto.request.LoginRequest;
import edu.miu.waa.lab5.domain.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab5.domain.dto.response.LoginResponse;
import edu.miu.waa.lab5.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
