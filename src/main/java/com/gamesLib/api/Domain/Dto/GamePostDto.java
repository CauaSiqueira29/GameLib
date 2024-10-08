package com.gamesLib.api.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record GamePostDto(@NotBlank String name,
                          @NotNull Date releaseDate,
                          @NotNull Double metacritic,
                          @NotNull String[] platforms,
                          @NotBlank String developer,
                          @NotBlank String poster) {
}
