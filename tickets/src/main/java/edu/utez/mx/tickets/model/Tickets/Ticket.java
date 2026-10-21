package edu.utez.mx.tickets.model.Tickets;

import edu.utez.mx.tickets.model.Usuarios.Usuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String descripcion;
    @Column
    private String estado;
    @Column
    private String prioridad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuarios usuario;
}
