package com.example.todo.game.controller;

import com.example.todo.game.dto.PlayerDto;
import com.example.todo.game.entity.Enemy;
import com.example.todo.game.service.GameService;
import com.example.todo.game.service.RankingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private RankingService rankingService;

    @GetMapping("/top")
    public String topPage() {
        return "game/top";
    }

    @GetMapping("/start")
    public String start() {
        return "game/start";
    }

    @PostMapping("/selectJob")
    public String selectJob(@RequestParam("playerName") String playerName,
                            @RequestParam("job") String job, Model model, HttpSession session) {
        if (playerName == null || playerName.isBlank() || job == null || job.isBlank()) {
            model.addAttribute("error", "名前と職業を入力してください");
            return "game/start";
        }

        PlayerDto player = gameService.createPlayer(playerName.trim(), job);
        session.setAttribute("player", player);
        model.addAttribute("player", player);
        return "game/status";
    }

    @GetMapping("/battle")
    public String battle(Model model, HttpSession session) {
        PlayerDto player = (PlayerDto) session.getAttribute("player");
        if (player == null) return "redirect:/game/start";

        Enemy enemy = gameService.generateEnemy(player.getWins());
        session.setAttribute("enemy", enemy);

        gameService.clearLog(); // ログ初期化

        model.addAttribute("player", player);
        model.addAttribute("enemy", enemy);
        model.addAttribute("logLines", List.of(gameService.getBattleLog().split("<br>")));
        model.addAttribute("canUseItem", !player.isUsedRecovery());
        return "game/battle";
    }

    @PostMapping("/attack")
    public String attack(@RequestParam("action") String action, Model model, HttpSession session) {
        PlayerDto player = (PlayerDto) session.getAttribute("player");
        Enemy enemy = (Enemy) session.getAttribute("enemy");

        if (player == null || enemy == null) return "redirect:/game/start";

        if (player.getHp() <= 0 || enemy.getHp() <= 0) {
            model.addAttribute("player", player);
            model.addAttribute("enemy", enemy);
            model.addAttribute("logLines", List.of(gameService.getBattleLog().split("<br>")));
            model.addAttribute("canUseItem", !player.isUsedRecovery());
            model.addAttribute("isFinished", true);
            return "game/battle";
        }

        gameService.executeTurn(player, enemy, action);

        model.addAttribute("player", player);
        model.addAttribute("enemy", enemy);
        model.addAttribute("logLines", List.of(gameService.getBattleLog().split("<br>")));
        model.addAttribute("canUseItem", !player.isUsedRecovery());

        if (player.getHp() <= 0 || enemy.getHp() <= 0) {
            model.addAttribute("isFinished", true);
        }

        return "game/battle";
    }

    @PostMapping("/useItem")
    public String useItem(Model model, HttpSession session) {
        PlayerDto player = (PlayerDto) session.getAttribute("player");
        Enemy enemy = (Enemy) session.getAttribute("enemy");

        if (player != null && !player.isUsedRecovery()) {
            player.useRecoveryItem();
            gameService.appendPlayerLog("<span class='green'>💊 回復アイテムを使用！HP/MP全回復！</span>");
        }

        model.addAttribute("player", player);
        model.addAttribute("enemy", enemy);
        model.addAttribute("logLines", List.of(gameService.getBattleLog().split("<br>")));
        model.addAttribute("canUseItem", !player.isUsedRecovery());
        return "game/battle";
    }

    @PostMapping("/continue")
    public String next(HttpSession session) {
        return "redirect:/game/battle";
    }

    @PostMapping("/end")
    public String end(HttpSession session, Model model) {
        PlayerDto player = (PlayerDto) session.getAttribute("player");

        if (player != null) {
            System.out.printf("ランキング保存: %s / Lv: %d / Wins: %d%n",
                    player.getName(), player.getLevel(), player.getWins());

            rankingService.save(player);
            model.addAttribute("result", player);
        }

        return "game/result";
    }
}