package com.process.shop.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String fullName;
    private Date birthDay;
    private String typeIdentification;
    private String identification;
    private String phone;
    private String email;
    private String password;
    private String address;
}
