package com.gamesLib.api.Domain.Dto;

import java.util.Date;

public record GamePutDto(String name,
                         Date releaseDate,
                         Double metacritic,
                         String[] platforms,
                         String developer,
                         String poster) {
}
