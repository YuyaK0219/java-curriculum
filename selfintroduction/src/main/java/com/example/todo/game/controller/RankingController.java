package com.example.todo.game.controller;

import com.example.todo.game.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping
    public String showRanking(Model model) {
        model.addAttribute("rankingList", rankingService.getTop10());
        return "game/ranking";
    }

    @PostMapping("/delete")
    public String deleteRanking(@RequestParam("id") Long id) {
        rankingService.deleteById(id);
        return "redirect:/ranking";
    }
}