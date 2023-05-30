package com.project.eIASbackend.dto;

import com.project.eIASbackend.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends User {
    String token;
}
