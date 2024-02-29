package unimagdalena.edu.actividad.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String creador;

    @Column
    private String deporte;

    @Column
    private String ciudad;

    @Column
    private String provincia;

    @Column
    private LocalDate fecha;

    @Column
    private LocalTime hora_comienzo;

    @Column
    private LocalTime hora_final;

    @Column
    private Integer  participantes;

    @Column
    private Integer suplentes;

    @Column
    private String varchar;

    @ManyToMany(mappedBy = "partidas")
    private Set<Usuario> usuarios;
    
}
