package com.rp3.marco4.domain.Users;

import jakarta.validation.constraints.NotNull;

public record UpdateUserData(
        
        @NotNull
        Long id,
        String username,
        String password, 
        Category category
    ) {

}
