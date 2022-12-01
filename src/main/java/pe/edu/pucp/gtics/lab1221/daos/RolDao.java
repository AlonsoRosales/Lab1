package pe.edu.pucp.gtics.lab1221.daos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pe.edu.pucp.gtics.lab1221.entity.Api;
import pe.edu.pucp.gtics.lab1221.entity.Rol;
import pe.edu.pucp.gtics.lab1221.entity.Roles;

import java.util.Arrays;
import java.util.List;

@Component
public class RolDao {

    public Roles listarUsuario(String ip){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Roles> response = restTemplate.getForEntity(
                "http://10.20.12.182:8081/login/" + ip, Roles.class);
        return response.getBody();
    }

}
