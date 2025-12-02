package com.example.xml.dto;

import com.example.xml.Model.RoleEnum;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String userName,
        String password,
        Set<RoleEnum> authorities

) {

}
