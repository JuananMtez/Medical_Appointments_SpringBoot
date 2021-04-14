package um.practicas.metaenlace.servicies;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.practicas.metaenlace.entities.Medico;
import um.practicas.metaenlace.entities.Paciente;
import um.practicas.metaenlace.repositories.IMedico;
import um.practicas.metaenlace.repositories.IPaciente;

@Service
@Transactional
public class MedicoService {

	@Autowired
	private IMedico medicoRepository;
	@Autowired
	private IPaciente pacienteRepository;

	public boolean create(Medico m, List<String> idPacientes) {

		m.setPacientes(new HashSet<Paciente>());

		int cont = 0;
		for (String id : idPacientes) {
			if (pacienteRepository.existsById(Integer.valueOf(id)))
				cont++;
		}

		if (cont == idPacientes.size()) {

			for (String id : idPacientes) {

				Paciente p = pacienteRepository.findById(Integer.valueOf(id)).orElse(null);
				m.addPaciente(p);
				p.addMedico(m);
				
			}
			
			medicoRepository.save(m);
			return true;
		}
		return false;
	}

	public boolean delete(int id) {

		Medico m = medicoRepository.findById(id).orElse(null);

		if (m != null) {
			medicoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean update(Medico m) {

		Medico m2 = medicoRepository.findById(m.getIdUsuario()).orElse(null);

		if (m2 != null) {

			
			if (m.getUsuario() != null)
				m2.setUsuario(m.getUsuario());
			if (m.getClave() != null)
				m2.setClave(m.getClave());
			
			medicoRepository.save(m2);
			
			
			return true;
		}

		return false;
	}

	public Medico get(int id) {
		return medicoRepository.findById(id).orElse(null);
	}

	public List<Medico> listAll() {
		return medicoRepository.findAll();
	}

}
