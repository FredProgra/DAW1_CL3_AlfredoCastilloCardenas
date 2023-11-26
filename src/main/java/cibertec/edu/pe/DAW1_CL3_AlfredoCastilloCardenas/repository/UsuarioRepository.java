package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.repository;

import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByNomusuario(String nomusuario);
}
