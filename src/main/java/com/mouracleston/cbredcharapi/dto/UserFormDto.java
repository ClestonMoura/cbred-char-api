package com.mouracleston.cbredcharapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserFormDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
