package um.practicas.metaenlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.practicas.metaenlace.entities.Cita;



@Repository
public interface ICita extends JpaRepository<Cita, Integer> {

	
}
