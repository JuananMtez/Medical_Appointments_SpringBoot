package um.practicas.metaenlace.servicies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.practicas.metaenlace.entities.Usuario;
import um.practicas.metaenlace.repositories.IUsuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private IUsuario usuarioRepository;

	public boolean create(Usuario u) {

		if (u.getIdUsuario() == 0) {
			usuarioRepository.save(u);
			return true;
		}
		return false;

	}

	public boolean delete(int id) {

		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
/*
	public boolean update() {
		if (usuarioRepository.existsById(u.getIdUsuario())) {
			usuarioRepository.save(u);
			return true;
		} 
		return false;
	}
*/
	public Usuario get(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public List<Usuario> listAll() {
		return usuarioRepository.findAll();

	}

}
