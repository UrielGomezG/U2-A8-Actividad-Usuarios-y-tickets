package edu.utez.mx.tickets.repository;

import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
}