package um.practicas.metaenlace.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.practicas.metaenlace.entities.Medico;
import um.practicas.metaenlace.entities.Paciente;
import um.practicas.metaenlace.servicies.MedicoService;
import um.practicas.metaenlace.servicies.dto.MedicoDTO;
import um.practicas.metaenlace.servicies.dto.PacienteDTO;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> list() {

		return ResponseEntity.ok(medicoService.listAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> get(@PathVariable("id") Integer id) {

		Medico m = medicoService.get(id);
		if (m != null)
			return ResponseEntity.ok(convertToDTO(m));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (medicoService.delete(id))
			return ResponseEntity.ok("Medico eliminado correctamente");
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody MedicoDTO medicoDTO) {

		Medico medico = convertToEntity(medicoDTO);
		if (medicoService.create(medico, medicoDTO.getPacientesIdUsuario()))
			return ResponseEntity.ok("Medico insertado correctamente");
		return ResponseEntity.status(409).build();
	}

	@PutMapping
	public ResponseEntity<String> modify(@RequestBody MedicoDTO medicoDTO) {

		if (medicoService.update(convertToEntity(medicoDTO)))
			return ResponseEntity.ok("Medico modificado correctamente");
		return ResponseEntity.notFound().build();
	}

	private MedicoDTO convertToDTO(Medico medico) {
		MedicoDTO m = modelMapper.map(medico, MedicoDTO.class);

		if (!medico.getPacientes().isEmpty()) {
			List<String> tmpPacientesIdUsuario = new ArrayList<>();
			medico.getPacientes().forEach(a -> {
				tmpPacientesIdUsuario.add(String.valueOf(a.getIdUsuario()));
			});
			m.setPacientesIdUsuario(tmpPacientesIdUsuario);
		}

		return m;
	}

	private Medico convertToEntity(MedicoDTO medicoDTO) {
		return modelMapper.map(medicoDTO, Medico.class);

	}

}
