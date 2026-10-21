package edu.utez.mx.tickets.service;

import edu.utez.mx.tickets.DTO.Usuario.CreateUsuarioDTO;
import edu.utez.mx.tickets.exception.UsuarioNoEncontradoException;
import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import edu.utez.mx.tickets.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuarios crearUsuario(CreateUsuarioDTO dto) {
        Usuarios usuario = new Usuarios();
        usuario.setName(dto.getNombre());
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    public Usuarios desactivarUsuario(Long usuarioId) {
        Usuarios usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNoEncontradoException("El usuario con ID " + usuarioId + " no existe"));

        usuario.setActivo(false);
        return usuarioRepository.save(usuario);
    }
}