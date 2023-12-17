package com.roderly.microbiomelabufu.login.repository;

import com.roderly.microbiomelabufu.login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    UserDetails findByUsuario(String usuario);
}
