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
public class PacienteService {

	@Autowired
	private IPaciente pacienteRepository;
	@Autowired
	private IMedico medicoRepository;

	public boolean create(Paciente p, List<String> idMedicos) {

		p.setMedicos(new HashSet<Medico>());

		int cont = 0;
		for (String id : idMedicos) {
			if (medicoRepository.existsById(Integer.valueOf(id)))
				cont++;
		}

		if (cont == idMedicos.size()) {
			for (String id : idMedicos) {

				Medico m = medicoRepository.findById(Integer.valueOf(id)).orElse(null);
				p.addMedico(m);
				m.addPaciente(p);
			}

			pacienteRepository.save(p);
			return true;
		}
		return false;
	}

	public boolean delete(int id) {

		if (pacienteRepository.existsById(id)) {

			pacienteRepository.deleteById(id);
			return true;
		}
		return false;

	}

	public boolean update(Paciente p) {

		Paciente p2 = pacienteRepository.findById(p.getIdUsuario()).orElse(null);

		if (p2 != null) {

			if (p.getUsuario() != null)
				p2.setUsuario(p.getUsuario());

			if (p.getClave() != null)
				p2.setUsuario(p.getUsuario());

			if (p.getDireccion() != null)
				p2.setDireccion(p.getDireccion());

			if (p.getTelefono() != null)
				p2.setTelefono(p.getTelefono());

			pacienteRepository.save(p2);
			return true;
		}
		return false;
	}

	public Paciente get(int id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	public List<Paciente> listAll() {
		return pacienteRepository.findAll();
	}
}
