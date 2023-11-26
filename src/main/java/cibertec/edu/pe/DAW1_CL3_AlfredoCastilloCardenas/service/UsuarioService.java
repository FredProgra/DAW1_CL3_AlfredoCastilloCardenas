package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.service;

import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Rol;
import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Usuario;
import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.repository.RolRepository;
import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bcryptPasswordEnconder
            = new BCryptPasswordEncoder();

    public Usuario saveUser(Usuario usuario){
        usuario.setPassword(
                bcryptPasswordEnconder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }
}
