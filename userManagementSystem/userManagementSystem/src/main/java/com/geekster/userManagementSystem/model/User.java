package com.geekster.userManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    @NotEmpty
    private String userId;
    @NotNull
    private String name;
    @Email
    @NotEmpty
    private String username;




    private String address;
    @Size(min=10,max=12)
    @Pattern(regexp="^[0-9]+$")
    private String phoneNo;


    public User(String userId, String name, String username, String address, String phoneNo) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phoneNo = phoneNo;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


}
