package com.example.todo.game.repository;

import com.example.todo.game.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    // 連勝数順 → レベル順
    List<Ranking> findTop10ByOrderByWinsDescLevelDesc();
}