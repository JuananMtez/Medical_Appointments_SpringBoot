package um.practicas.metaenlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.practicas.metaenlace.entities.Medico;



@Repository
public interface IMedico extends JpaRepository<Medico, Integer> {

}
