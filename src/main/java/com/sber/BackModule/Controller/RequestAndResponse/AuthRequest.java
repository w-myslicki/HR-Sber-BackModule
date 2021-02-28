package com.sber.BackModule.Controller.RequestAndResponse;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}