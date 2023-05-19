package com.mouracleston.cbredcharapi.mapper;

import com.mouracleston.cbredcharapi.dto.UserFormDto;
import com.mouracleston.cbredcharapi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserFormDto userFormDto) {
        return User.builder()
                .email(userFormDto.email())
                .userName(userFormDto.username())
                .password(userFormDto.password())
                .build();
    }

}
