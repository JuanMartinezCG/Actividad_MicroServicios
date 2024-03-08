package edu.unimagdalena.actividad.repository;

import edu.unimagdalena.actividad.AbstractIntegrationDBTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unimagdalena.edu.actividad.entidades.Usuario;
import unimagdalena.edu.actividad.repository.UsuarioRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioRepositoryTest extends AbstractIntegrationDBTest {


    UsuarioRepository repo;

    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository repo){
        this.repo=repo;
    }

    void initMockUsuarios(){
        Usuario usuario = Usuario.builder().nombre("julian").apellido("Pizarro").username("julianpizarro").password("123").build();
                /*.nombre("Julian")
                .apellido("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();*/
        repo.save(usuario);

        Usuario usuario2 = Usuario.builder().nombre("Jose")
                .apellido("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        repo.save(usuario2);
        repo.flush();
    }

    @BeforeEach
    void setUp() {

        repo.deleteAll();

    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellido("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        //when
        Usuario userSaved = repo.save(usuario);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellido("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        repo.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .nombre("Jose")
                .apellido("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        repo.save(usuario2);
        repo.flush();
        //WHEN
        List<Usuario> usuarios = repo.findAll();

        //THEN
        assertThat(usuarios).hasSize(2);
    }
    @Test
    void givenUsuarios_whenBuscarPorNombreyApellido_thenObtienesUnaListaDeUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Julian")
                .apellido("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        repo.save(usuario);
        Usuario usuario2 = Usuario.builder().nombre("Jose")
                .apellido("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        repo.save(usuario);

        List<Usuario> usuarios = repo.findByNombreAndApellido("Julian", "Pizarro");

        assertThat(usuarios).isNotEmpty();
        assertThat(usuarios).first().hasFieldOrPropertyWithValue("nombre","Julian");
    }



}
