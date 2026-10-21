package edu.utez.mx.tickets.DTO.Ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateTicketDTO {
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;
    @NotBlank (message = "No puede estar vacia la prioridad")
    @Pattern(regexp = "^(BAJA|MEDIA|ALTA)$", message = "La prioridad debe ser BAJA, MEDIA o ALTA")
    private String prioridad;
    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;
}
