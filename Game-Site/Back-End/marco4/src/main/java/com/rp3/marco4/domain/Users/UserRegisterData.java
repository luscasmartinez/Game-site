package com.rp3.marco4.domain.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record UserRegisterData(
    
    @NotBlank
    String username,

    @NotBlank
    String password,

    @NotNull
    Category category
    ) {
}
