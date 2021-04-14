package um.practicas.metaenlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.practicas.metaenlace.entities.Paciente;


@Repository
public interface IPaciente extends JpaRepository<Paciente, Integer> {

}
