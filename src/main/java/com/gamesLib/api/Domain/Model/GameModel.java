package com.gamesLib.api.Domain.Model;

import com.gamesLib.api.Domain.Dto.GamePostDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Games")
@Table(name = "games")
@EqualsAndHashCode(of = "id")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date releaseDate;
    private Double metacritic;

    @ElementCollection
    private List<String> platforms;
    private String developer;
    private String poster;

    public GameModel(GamePostDto data){
        this.name = data.name();
        this.releaseDate = data.releaseDate();
        this.metacritic = data.metacritic();
        this.platforms = data.platforms();
        this.developer = data.developer();
        this.poster = data.poster();
    }



}
