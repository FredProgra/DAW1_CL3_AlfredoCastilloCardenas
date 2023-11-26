package cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.repository;

import cibertec.edu.pe.DAW1_CL3_AlfredoCastilloCardenas.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByNomrol(String nomrol);
}
