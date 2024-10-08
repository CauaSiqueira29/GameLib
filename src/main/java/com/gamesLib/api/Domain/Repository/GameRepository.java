package com.gamesLib.api.Domain.Repository;

import com.gamesLib.api.Domain.Model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
