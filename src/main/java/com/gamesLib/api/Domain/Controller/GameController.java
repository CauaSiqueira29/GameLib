package com.gamesLib.api.Domain.Controller;

import com.gamesLib.api.Domain.Dto.GamePostDto;
import com.gamesLib.api.Domain.Dto.GameGetDto;
import com.gamesLib.api.Domain.Dto.GamePutDto;
import com.gamesLib.api.Domain.Dto.GameReturnDto;
import com.gamesLib.api.Domain.Model.GameModel;
import com.gamesLib.api.Domain.Service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Games")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<GameReturnDto> createGame(@RequestBody @Valid GamePostDto data){
        return service.recordGame(new GameModel(data));

    }

    @GetMapping("/getgame")
    public ResponseEntity<Page<GameGetDto>> readAllGames(Pageable pageable){
        return service.returnAllGames(pageable);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GameReturnDto> updateGameById(@PathVariable Long id, @RequestBody GamePutDto data){
        return service.updateGame(id, data);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGameById(@PathVariable Long id){
        return service.deleteGameById(id);

    }

}
