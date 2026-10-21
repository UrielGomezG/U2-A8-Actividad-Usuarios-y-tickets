package edu.utez.mx.tickets.DTO.Usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateUsuarioDTO {
    @NotBlank(message = "El usuario no puede estar vacio")
    String nombre;
}
