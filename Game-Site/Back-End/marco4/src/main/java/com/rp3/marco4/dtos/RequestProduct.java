package com.rp3.marco4.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
        String id,

        @NotBlank(message = "O nome não pode estar em branco")
        String name,
        @NotNull(message = "O preço do produto é obrigatório" )
        Integer price_in_cents,

        String imageurl
) {
}
