package com.sber.BackModule.Controller.RequestAndResponse;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegistrationRequest {

    @NotEmpty(message = "Login must not be empty!")
    @Size(min = 4, max = 30, message = "Login must be at least 4 and more than 30 characters!")
    private String username;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 8, max =70, message = "Password must be at least 8 characters long!")
    private String password;
}