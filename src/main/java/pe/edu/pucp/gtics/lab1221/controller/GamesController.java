package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;

import java.util.List;

@Controller
@RequestMapping("/juegos")
public class GamesController {

    @Autowired
    GamesRepository gamesRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){
        List<Games> listaJuegos = gamesRepository.findAll();
        model.addAttribute("listaJuegos",listaJuegos);
        return "juegos/lista";
    };

    public String editarJuegos(){
        return "";
    };

    public String guardarJuegos(){
        return "";
    };

}
