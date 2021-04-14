package um.practicas.metaenlace.servicies;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.practicas.metaenlace.entities.Diagnostico;
import um.practicas.metaenlace.entities.Cita;

import um.practicas.metaenlace.repositories.ICita;
import um.practicas.metaenlace.repositories.IDiagnostico;

@Service
@Transactional
public class DiagnosticoService {

	@Autowired
	private IDiagnostico diagnosticoRepository;

	@Autowired
	private ICita citaRepository;

	public boolean create(Diagnostico d, String idCita) {

		if (d.getIdDiagnostico() == 0 && citaRepository.existsById(Integer.valueOf(idCita))) {

			Cita c = citaRepository.findById(Integer.valueOf(idCita)).orElse(null);
			c.setDiagnostico(d);
			d.setCita(c);
			diagnosticoRepository.save(d);
			
			return true;
		}
		return false;
	}

	public boolean delete(int id) {

		if (diagnosticoRepository.existsById(id)) {
			Cita c = citaRepository.findById(diagnosticoRepository.findById(id).orElse(null).getCita().getIdCita()).orElse(null);
			c.setDiagnostico(null);
			citaRepository.save(c);
			
			return true;
		}
		return false;
	}

	public boolean update(Diagnostico d) {

		if (diagnosticoRepository.existsById(d.getIdDiagnostico())) {
			diagnosticoRepository.save(d);
			return true;
		}
		return false;
	}

	public Diagnostico get(int id) {
		return diagnosticoRepository.findById(id).orElse(null);
	}

	public List<Diagnostico> listAll() {
		return diagnosticoRepository.findAll();
	}
}
