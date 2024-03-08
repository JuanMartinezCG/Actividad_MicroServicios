package unimagdalena.edu.actividad.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Partidas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String creador;

    @Column
    private String deporte;

    @Column
    private String ciudad;

    @Column
    private String provincia;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDate fecha;
    @Temporal(TemporalType.TIME)
    @Column
    private LocalTime hora_comienzo;
    @Temporal(TemporalType.TIME)
    @Column
    private LocalTime hora_final;

    @Column
    private Integer  participantes;

    @Column
    private Integer suplentes;

    @Column
    private String varchar;

    @ManyToMany(mappedBy = "partidas")
    private List<Usuario> usuarios;
    
}
