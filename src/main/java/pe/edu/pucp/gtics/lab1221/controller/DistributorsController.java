package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/distribuidoras")
public class DistributorsController {

    @Autowired
    DistributorsRepository distribuidorasRepository;


    @GetMapping("/lista")
    public String listaDistribuidoras(Model model){
        List<Distributors> listaDistribuidoras = distribuidorasRepository.findAll(Sort.by("nombre"));
        model.addAttribute("lista",listaDistribuidoras);
        return "distribuidoras/lista";
    }


    @GetMapping("/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDistribuidora(Distributors distribuidora){
        distribuidorasRepository.save(distribuidora);
        return "redirect:/distribuidoras/lista";
    }

    @GetMapping("/editar")
    public String editarDistribuidoras(@RequestParam("id") String id, Model model){
        Optional<Distributors> distribuidora = distribuidorasRepository.findById(Integer.parseInt(id));

        if(distribuidora.isPresent()){
            Distributors distribuidora1 = distribuidora.get();
            model.addAttribute("distribuidora",distribuidora1);
            return "distribuidoras/editar";
        }
        return "redirect:/distribuidoras/lista";
    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") String id){
        Optional<Distributors> distribuidora = distribuidorasRepository.findById(Integer.parseInt(id));

        if(distribuidora.isPresent()){
            distribuidorasRepository.deleteById(Integer.parseInt(id));
            return "redirect:/distribuidoras/lista";
        }
        return "redirect:/distribuidoras/lista";
    }


}
