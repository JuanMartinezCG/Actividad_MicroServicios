package unimagdalena.edu.actividad.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String creador;

    @Column
    private String destinatario;

    @Column
    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDate create_at;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    
    
}
