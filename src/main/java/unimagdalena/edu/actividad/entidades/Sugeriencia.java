package unimagdalena.edu.actividad.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="sugerencias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sugeriencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private LocalDate create_at;

    @ManyToOne
    @JoinColumn(name = "id_usuario" , nullable = false)
    private Usuario usuarios;
    
    
}
