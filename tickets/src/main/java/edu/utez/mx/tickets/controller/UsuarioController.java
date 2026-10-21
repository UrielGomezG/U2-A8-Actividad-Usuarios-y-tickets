package edu.utez.mx.tickets.controller;

import edu.utez.mx.tickets.DTO.Usuario.CreateUsuarioDTO;
import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import edu.utez.mx.tickets.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@Valid @RequestBody CreateUsuarioDTO dto) {
        return new ResponseEntity<>(usuarioService.crearUsuario(dto), HttpStatus.CREATED);
    }


    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Usuarios> desactivarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.desactivarUsuario(id));
    }
}