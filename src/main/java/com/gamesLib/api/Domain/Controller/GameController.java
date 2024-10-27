package com.gamesLib.api.Domain.Controller;

import com.gamesLib.api.Domain.Dto.GameGetDto;
import com.gamesLib.api.Domain.Dto.GamePostDto;
import com.gamesLib.api.Domain.Dto.GamePutDto;
import com.gamesLib.api.Domain.Dto.GameReturnDto;
import com.gamesLib.api.Domain.Model.GameModel;
import com.gamesLib.api.Domain.Service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping()
    @Transactional
    public ResponseEntity<GameReturnDto> createGame(@RequestBody @Valid GamePostDto data){
        return service.recordGame(new GameModel(data));
    }

    @GetMapping("/allGames")
    public ResponseEntity<Page<GameGetDto>> readAllGames(Pageable pageable){
        return service.returnAllGames(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameReturnDto> getGameById(@PathVariable Long id){
        return service.getGameById(id);
    }

    @GetMapping("/platform")
    public ResponseEntity<Page<GameReturnDto>> returnByPlatforms(@RequestParam String platform, @PageableDefault(size = 10) Pageable pageable){
        return service.getByPlatforms(platform, pageable);
    }

    @GetMapping("/metacritic")
    public ResponseEntity<Page<GameReturnDto>> getByMetacritic(@RequestParam Double note, @PageableDefault(size = 10) Pageable pageable){
        return service.getByMetacritic(note, pageable);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<GameReturnDto> updateGameById(@PathVariable Long id, @RequestBody GamePutDto data){
        return service.updateGame(id, data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteGameById(@PathVariable Long id){
        return service.deleteGameById(id);
    }

}
