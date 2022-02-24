package pl.kkiomen.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kkiomen.game.generator.map.Chunks.Helper.Column;
import pl.kkiomen.game.generator.map.MapGenerator;

import java.util.ArrayList;

@Controller
public class MapController {
    @GetMapping("/map")
    public String home(Model model){

        //  Generator.init();

        ArrayList<Column> chunks = MapGenerator.render();
        model.addAttribute("chunks", chunks);
        return "index";
    }
}
