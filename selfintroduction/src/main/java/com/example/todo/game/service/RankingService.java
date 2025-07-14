package com.example.todo.game.service;

import com.example.todo.game.dto.PlayerDto;
import com.example.todo.game.entity.Ranking;
import com.example.todo.game.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking save(PlayerDto player) {
        if (player == null) return null;

        Ranking r = new Ranking();
        r.setPlayerName(player.getName());
        r.setJob(player.getJob());
        r.setLevel(player.getLevel());
        r.setWins(player.getWins());
        return rankingRepository.save(r);
    }

    public List<Ranking> getTop10() {
        // ★ 修正：連勝数が多い順に並べる
        return rankingRepository.findTop10ByOrderByWinsDescLevelDesc();
    }

    public void deleteById(Long id) {
        rankingRepository.deleteById(id);
    }
}