package edu.utez.mx.tickets.service;

import edu.utez.mx.tickets.DTO.Ticket.CreateTicketDTO;
import edu.utez.mx.tickets.DTO.Ticket.UpdatePrioridadDTO;
import edu.utez.mx.tickets.exception.EstadoTicketInvalidoException;
import edu.utez.mx.tickets.exception.TicketNoEncontradoException;
import edu.utez.mx.tickets.exception.UsuarioInactivoException;
import edu.utez.mx.tickets.exception.UsuarioNoEncontradoException;
import edu.utez.mx.tickets.model.Tickets.Ticket;
import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import edu.utez.mx.tickets.repository.TicketRepository;
import edu.utez.mx.tickets.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;

    public TicketService(TicketRepository ticketRepository, UsuarioRepository usuarioRepository) {
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Ticket crearTicket(CreateTicketDTO dto) {
        Usuarios usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new UsuarioNoEncontradoException("El usuario ingresado no existe"));

        if (!usuario.isActivo()) {
            throw new UsuarioInactivoException("No se puede crear el ticket: el usuario no está activo");
        }

        Ticket ticket = new Ticket();
        ticket.setDescripcion(dto.getDescripcion());
        ticket.setEstado("ABIERTO");
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setUsuario(usuario);

        return ticketRepository.save(ticket);
    }

    public Ticket actualizarEstadoTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNoEncontradoException("El ticket con ID " + ticketId + " no existe"));

        switch (ticket.getEstado()) {
            case "ABIERTO" -> ticket.setEstado("EN_PROCESO");
            case "EN_PROCESO" -> ticket.setEstado("CERRADO");
            case "CERRADO" -> throw new EstadoTicketInvalidoException("El ticket ya está CERRADO y no se puede modificar");
            default -> throw new EstadoTicketInvalidoException("Estado no válido");
        }

        return ticketRepository.save(ticket);
    }

    public Ticket reasignarPrioridad(Long ticketId, UpdatePrioridadDTO dto) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNoEncontradoException("El ticket con ID " + ticketId + " no existe"));

        if ("CERRADO".equals(ticket.getEstado())) {
            throw new EstadoTicketInvalidoException("No se puede modificar la prioridad de un ticket CERRADO");
        }

        ticket.setPrioridad(dto.getPrioridad());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> obtenerTicketsUsuario(Long usuarioId) {
        Usuarios usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNoEncontradoException("El usuario ingresado no existe"));

        return ticketRepository.findByUsuario(usuario);
    }
}