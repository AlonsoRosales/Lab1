package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.pucp.gtics.lab1221.daos.RolDao;
import pe.edu.pucp.gtics.lab1221.entity.Alumno;
import pe.edu.pucp.gtics.lab1221.entity.Api;
import pe.edu.pucp.gtics.lab1221.entity.Rol;
import pe.edu.pucp.gtics.lab1221.entity.Roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class AlumnoController {

    @Autowired
    RolDao rolDao;

    List<Alumno> listaAlumnos = new ArrayList<>();

    @GetMapping("")
    public String homeDistribuidoras(){
        HashMap<String, Object> lista = new HashMap<>();
        lista.put("alumno","listar");
        lista.put("egresado","listar");
        lista.put("profesor","listar,agregar");
        lista.put("administrador","listar,agregar,borrar");
        Alumno a1 = new Alumno();
        a1.setNombre("Luis");
        a1.setApellido("Ramos");
        a1.setEdad(22);
        a1.setCodigoPucp("20171198");
        Alumno a2 = new Alumno();
        a2.setNombre("Leonardo");
        a2.setApellido("Ayala");
        a2.setEdad(20);
        a2.setCodigoPucp("20191253");
        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listaDistribuidoras(Model model){
        model.addAttribute("lista",listaAlumnos);
        return "alumnos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevaDistribuidora(){
        return "alumnos/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDistribuidora(Alumno alumno, RedirectAttributes attr){
        String ip  = "10.8.0.34";
        Roles listaroles = rolDao.listarUsuario(ip);
        int bandera = 0;
        for(Rol r : listaroles.getRoles()){
            if(r.getRol().equals("Profesor")||r.getRol().equals("Administrador")){
                bandera = 1;
                listaAlumnos.add(alumno);
                break;
            }
        }
        if(bandera==1){
            attr.addFlashAttribute("msg","Alumno agregado exitosamente");
        }else{
            attr.addFlashAttribute("msg1","No tiene los permisos necesarios");
        }
        return "redirect:/lista";
    }

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("codigo") String codigo,RedirectAttributes attr){
        String ip  = "10.8.0.34";
        Roles listaroles = rolDao.listarUsuario(ip);
        int bandera = 0;
        for(Rol r : listaroles.getRoles()){
            if(r.getRol().equals("Administrador")){
                for(Alumno i : listaAlumnos) {
                    if(i.getCodigoPucp().equals(codigo)){
                        bandera = 1;
                        listaAlumnos.remove(i);
                    }
                }
            }
        }
        if(bandera==1){
            attr.addFlashAttribute("msg2","Alumno borrado exitosamente");
        }else{
            attr.addFlashAttribute("msg1","No tiene los permisos necesarios");
        }
        return "redirect:/lista";
    }

}
