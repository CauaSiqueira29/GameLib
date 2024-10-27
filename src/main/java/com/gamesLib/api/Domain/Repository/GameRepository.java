package com.gamesLib.api.Domain.Repository;

import com.gamesLib.api.Domain.Model.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<GameModel, Long> {

    @Query("SELECT g FROM Games g JOIN g.platforms p WHERE LOWER(p) = LOWER(:platform)")
    Page<GameModel> findByPlatform(@Param("platform") String platform, Pageable pageable);

    @Query("SELECT g FROM Games g WHERE g.metacritic >= :note")
    Page<GameModel> findByMetacritic(@Param("note") Double note, Pageable pageable);

}
