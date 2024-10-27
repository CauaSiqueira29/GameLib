package com.gamesLib.api.Domain.Dto;

import com.gamesLib.api.Domain.Model.GameModel;

import java.util.Date;
import java.util.List;

public record GameReturnDto(Long id,
                            String name,
                            Date releaseDate,
                            Double metacritic,
                            List<String> platforms,
                            String developer,
                            String poster) {

    public GameReturnDto(GameModel game){
        this(game.getId(), game.getName(), game.getReleaseDate(), game.getMetacritic(), game.getPlatforms(),
                game.getDeveloper(), game.getPoster());
    }
}
