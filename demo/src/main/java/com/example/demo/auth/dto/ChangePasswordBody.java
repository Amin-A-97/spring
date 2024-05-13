package com.example.demo.auth.dto;

import lombok.Data;

@Data
public class ChangePasswordBody {
    private String username;
    private String currentPassword;
    private String newPassword;
    private String confrimPassword;
}
