package com.sber.BackModule.Controller;

import com.sber.BackModule.Config.jwt.JwtProvider;
import com.sber.BackModule.Entity.UserEntity;
import com.sber.BackModule.Repository.UserEntityRepository;
import com.sber.BackModule.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            UserEntity u = new UserEntity();
            u.setPassword(registrationRequest.getPassword());
            u.setUsername(registrationRequest.getLogin());
            userService.saveUser(u);
            return new ResponseEntity<>("Success!",HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>("Error: "+exception,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUsername());
        return new AuthResponse(token);
    }


    //--------------------------Simple core controllers-----------------------

    @GetMapping("/api/get")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> usersList = new ArrayList<>();

        Iterable<UserEntity> iterable = userEntityRepository.findAll();
        iterable.forEach(usersList::add);
        return usersList;
    }
}
