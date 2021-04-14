package um.practicas.metaenlace.servicies;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.practicas.metaenlace.entities.Cita;
import um.practicas.metaenlace.entities.Medico;
import um.practicas.metaenlace.entities.Paciente;
import um.practicas.metaenlace.repositories.ICita;
import um.practicas.metaenlace.repositories.IMedico;
import um.practicas.metaenlace.repositories.IPaciente;

@Service
@Transactional
public class CitaService {

	@Autowired
	private ICita citaReporsitory;
	@Autowired
	private IPaciente pacienteRepository;
	@Autowired
	IMedico medicoRepository;

	public boolean create(Cita c, Paciente p, Medico m) {

		// TODO

		if (c.getIdCita() == 0 && p.getIdUsuario() == 0 && m.getIdUsuario() == 0) {

			p.addMedico(m);
			m.addPaciente(p);

			c.setPaciente(p);
			c.setMedico(m);

			pacienteRepository.save(p);

			return true;
		}
		return false;
	}

	public boolean create(Cita c, int idPaciente, int idMedico) {

		Paciente p = pacienteRepository.findById(idPaciente).orElse(null);
		Medico m = medicoRepository.findById(idMedico).orElse(null);

		if (p != null && m != null) {

			c.setPaciente(p);
			c.setMedico(m);

			p.addCita(c);
			m.addCita(c);

			c.setDiagnostico(null);

			citaReporsitory.save(c);

			return true;

		}
		return false;
	}
	
	
	
	

	public boolean delete(int id) {

		if (citaReporsitory.existsById(id)) {
			citaReporsitory.deleteById(id);
			return true;
		}
		return false;
	}

	public boolean update(Cita c) {

		Cita c2 = citaReporsitory.findById(c.getIdCita()).orElse(null);

		if (c2 != null) {

			if (c.getFechaHora() != null)
				c2.setFechaHora(c.getFechaHora());
			if (c.getMotivoCita() != null)
				c2.setMotivoCita(c.getMotivoCita());

			citaReporsitory.save(c2);

			return true;
		}

		return false;

	}

	public Cita get(int id) {
		return citaReporsitory.findById(id).orElse(null);
	}

	public List<Cita> listAll() {

		return citaReporsitory.findAll();
	}
	
	public List<Cita> listbyIdMedico(int idMedico) {
		return citaReporsitory.findAll().stream()
				.filter(c -> c.getMedico().getIdUsuario() == idMedico)
				.collect(Collectors.toList());
		
		
	}

}
