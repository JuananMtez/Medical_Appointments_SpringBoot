package um.practicas.metaenlace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.practicas.metaenlace.entities.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer>{

}
