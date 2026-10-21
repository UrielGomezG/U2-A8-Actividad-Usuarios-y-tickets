package edu.utez.mx.tickets.repository;

import edu.utez.mx.tickets.model.Tickets.Ticket;
import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUsuario(Usuarios usuario);
}