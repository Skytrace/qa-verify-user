package com.userservice.models;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class UserResponseDTO {
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String password;
    private Long id;
    private String createdAt;
}
