package unimagdalena.edu.actividad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import unimagdalena.edu.actividad.entidades.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
