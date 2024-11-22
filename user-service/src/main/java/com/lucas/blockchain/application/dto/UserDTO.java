package com.lucas.blockchain.application.dto;

import jakarta.validation.constraints.NotNull;

public record UserDTO(
        @NotNull String username,
        @NotNull String password) {
}
