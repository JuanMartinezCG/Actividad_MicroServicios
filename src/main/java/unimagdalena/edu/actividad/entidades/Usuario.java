package unimagdalena.edu.actividad.entidades;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;


    @Column
    private String username;

    @Column
    private Integer edad;

    @Column
    private String password;

    @Column
    private String password_again;

    @Column
    private Boolean enabled;

    @Column
    private String foto;

    @Column
    private String rol;

    @Column
    private LocalDate create_at;

    @OneToMany
    @JoinColumn(name ="usuario_id")
    private Set<Sugeriencia> sugerencias;

    @OneToMany
    @JoinColumn(name ="usuario_id")
    private Set<Mensaje> mensajes;


    @ManyToMany
    @JoinTable(
        name = "partidos por usuarios",
        joinColumns = @JoinColumn(name="usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "partida_id")
    )
    private Set<Partida> partidas;
    
}
