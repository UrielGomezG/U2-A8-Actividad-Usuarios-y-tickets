package edu.utez.mx.tickets.DTO.Ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdatePrioridadDTO {
    @NotBlank(message = "La prioridad es obligatoria")
    @Pattern(regexp = "^(BAJA|MEDIA|ALTA)$", message = "La prioridad debe ser BAJA, MEDIA o ALTA")
    private String prioridad;
}
