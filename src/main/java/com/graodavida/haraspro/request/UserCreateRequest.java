package com.graodavida.haraspro.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
