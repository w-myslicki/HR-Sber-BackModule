package com.sber.BackModule.Controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
