package com.example.demo.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
public class RegisterBody {


    private String email;
    private String uName;
    private String pWord;
    private String rolle;
}
