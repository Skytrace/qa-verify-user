package com.userservice.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class UserRequestDTO {
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String password;
}
