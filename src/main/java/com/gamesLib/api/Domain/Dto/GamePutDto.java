package com.gamesLib.api.Domain.Dto;

import java.util.Date;
import java.util.List;

public record GamePutDto(String name,
                         Date releaseDate,
                         Double metacritic,
                         List<String> platforms,
                         String developer,
                         String poster) {
}
