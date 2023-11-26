package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.service;

import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Rol;
import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Usuario;
import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService  implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomusuario(username);
        return autenticacionUsuario(
                usuario,
                obtenerListaRolesPorUsuario(usuario.getRoles())
        );
    }
    private List<GrantedAuthority> obtenerListaRolesPorUsuario(
            Set<Rol> roles){
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for(Rol rol: roles){
            grantedAuthoritySet.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        return new ArrayList<>(grantedAuthoritySet);
    }
    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return new User(
                usuario.getNomusuario(),usuario.getPassword(),
                usuario.isActivo(), true,
                true,true,
                authorityList);
    }

}
