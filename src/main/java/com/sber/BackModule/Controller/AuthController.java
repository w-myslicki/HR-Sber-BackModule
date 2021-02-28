package com.sber.BackModule.Controller;

import com.sber.BackModule.Config.Jwt.JwtProvider;
import com.sber.BackModule.Controller.RequestAndResponse.AuthRequest;
import com.sber.BackModule.Controller.RequestAndResponse.AuthResponse;
import com.sber.BackModule.Controller.RequestAndResponse.RegistrationRequest;
import com.sber.BackModule.Entity.UserEntity;
import com.sber.BackModule.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity user = new UserEntity();
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getUsername());

        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUsername());
        return new AuthResponse(token);
    }
}
