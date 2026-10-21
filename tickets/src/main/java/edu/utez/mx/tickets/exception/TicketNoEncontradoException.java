package edu.utez.mx.tickets.exception;

public class TicketNoEncontradoException extends RuntimeException {
    public TicketNoEncontradoException(String message) {
        super(message);
    }
}