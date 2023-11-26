package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.controller.frontoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @GetMapping("/frmusuario")
    public String frmusurio(){
        return "/administracion/frmusuario";
    }

}
