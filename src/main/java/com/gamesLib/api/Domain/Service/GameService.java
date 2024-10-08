package com.gamesLib.api.Domain.Service;

import com.gamesLib.api.Domain.Dto.GameGetDto;
import com.gamesLib.api.Domain.Dto.GamePutDto;
import com.gamesLib.api.Domain.Dto.GameReturnDto;
import com.gamesLib.api.Domain.Model.GameModel;
import com.gamesLib.api.Domain.Repository.GameRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public ResponseEntity<GameReturnDto> recordGame(GameModel data){
        var game = repository.save(data);
        var returnGame = new GameReturnDto(game);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnGame);
    }

    public ResponseEntity<Page<GameGetDto>> returnAllGames(@PageableDefault(size = 10) Pageable pageable){
        var page = repository.findAll(pageable).map(GameGetDto::new);

        return ResponseEntity.ok().body(page);
    }

    public ResponseEntity<GameReturnDto> updateGame(Long id, GamePutDto data){
        Optional<GameModel> searchGame = repository.findById(id);

        if (searchGame.isPresent()){
            GameModel game = searchGame.get();
            if(data.name() != null){
                game.setName(data.name());
            }
            if(data.releaseDate() != null){
                game.setReleaseDate(data.releaseDate());
            }
            if(data.metacritic() != null){
                game.setMetacritic(data.metacritic());
            }
            if(data.platforms() != null){
                game.setPlatforms(data.platforms());
            }
            if(data.developer() != null){
                game.setDeveloper(data.developer());
            }
            if(data.poster() != null){
                game.setPoster(data.poster());
            }

            GameModel updatedGame = repository.save(game);
            var returnUpdatedGame = new GameReturnDto(updatedGame);
            return ResponseEntity.ok().body(returnUpdatedGame);

        }

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<String> deleteGameById(Long id){

        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>("Game deleted!", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Game id: " + id + "not found!", HttpStatus.NOT_FOUND);
        }

    }

}