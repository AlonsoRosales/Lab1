package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/juegos")
public class GamesController {
    @Autowired
    GamesRepository juegosRepository;

    @Autowired
    PlatformsRepository plataformasRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){
        List<Games> listita = juegosRepository.findAll(Sort.by("precio"));
            model.addAttribute("lista",listita);
            return "juegos/lista";
    }

    @GetMapping("editar")
    public String editarJuegos(@RequestParam("id") String id, Model model){
        Optional<Games> juegito = juegosRepository.findById(Integer.parseInt(id));
        if(juegito.isPresent()){
            Games juegaso = juegito.get();
            model.addAttribute("juego",juegaso);
            List<Platforms> listaPlataformas = plataformasRepository.findAll();
            int index = 0;
            for(Platforms plataforma: listaPlataformas){
                if(plataforma.getId() == juegaso.getIdplataforma()){
                    break;
                }
                index++;
            }
            Platforms plataformita = listaPlataformas.remove(index);
            List<Platforms> listita = new ArrayList<>();
            listita.add(plataformita);


            for(Platforms plata: listaPlataformas){
                listita.add(plata);
            }
            model.addAttribute("listaPlataformas",listita);
            return "juegos/editar";
        }
        return "redirect:/juegos/lista";

    }

    @PostMapping("guardar")
    public String guardarJuegos(Games juego){
        System.out.println(juego.getId());
        System.out.println(juego.getDescripcion());
        System.out.println(juego.getNombre());
        System.out.println(juego.getPrecio());
        System.out.println(juego.getIdplataforma());
        juegosRepository.save(juego);
        return "redirect:/juegos/lista";
    }

    @GetMapping("/borrar")
    public String borrarJuegos(@RequestParam("id") String id){
        Optional<Games> juegos = juegosRepository.findById(Integer.parseInt(id));

        if(juegos.isPresent()){
            juegosRepository.deleteById(Integer.parseInt(id));
            return "redirect:/juegos/lista";
        }
        return "redirect:/juegos/lista";

    }
}
