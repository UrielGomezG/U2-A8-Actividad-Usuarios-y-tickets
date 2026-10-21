package edu.utez.mx.tickets.controller;

import edu.utez.mx.tickets.DTO.Ticket.CreateTicketDTO;
import edu.utez.mx.tickets.DTO.Ticket.UpdatePrioridadDTO;
import edu.utez.mx.tickets.model.Tickets.Ticket;
import edu.utez.mx.tickets.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> crearTicket(@Valid @RequestBody CreateTicketDTO dto) {
        return new ResponseEntity<>(ticketService.crearTicket(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Ticket> actualizarEstado(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.actualizarEstadoTicket(id));
    }

    @PatchMapping("/{id}/prioridad")
    public ResponseEntity<Ticket> reasignarPrioridad(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePrioridadDTO dto
    ) {
        return ResponseEntity.ok(ticketService.reasignarPrioridad(id, dto));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Ticket>> obtenerTicketsPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(ticketService.obtenerTicketsUsuario(usuarioId));
    }
}