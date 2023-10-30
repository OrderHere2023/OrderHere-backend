package com.backend.OrderHere.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
