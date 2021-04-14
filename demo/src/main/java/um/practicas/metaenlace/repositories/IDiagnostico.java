package um.practicas.metaenlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.practicas.metaenlace.entities.Diagnostico;

@Repository
public interface IDiagnostico extends JpaRepository<Diagnostico, Integer> {

}
