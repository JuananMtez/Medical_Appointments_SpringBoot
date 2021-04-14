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
import um.practicas.metaenlace.entities.Paciente;
import um.practicas.metaenlace.servicies.PacienteService;
import um.practicas.metaenlace.servicies.dto.PacienteDTO;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> list() {

		return ResponseEntity
				.ok(pacienteService.listAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> get(@PathVariable("id") Integer id) {
		Paciente p = pacienteService.get(id);
		if (p != null)
			return ResponseEntity.ok(convertToDTO(p));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {

		if (pacienteService.delete(id))
			return ResponseEntity.ok("Paciente eliminado correctamente");
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody PacienteDTO pacienteDTO) {

		Paciente paciente = convertToEntity(pacienteDTO);
		if (pacienteService.create(paciente, pacienteDTO.getMedicosIdUsuario()))
			return ResponseEntity.ok("Paciente insertado correctamente");
		return ResponseEntity.status(409).build();

	}

	@PutMapping
	public ResponseEntity<String> modify(@RequestBody PacienteDTO p) {

		if (pacienteService.update(convertToEntity(p)))
			return ResponseEntity.ok("Paciente modificado correctamente");
		return ResponseEntity.notFound().build();
	}

	private PacienteDTO convertToDTO(Paciente paciente) {

		PacienteDTO p = modelMapper.map(paciente, PacienteDTO.class);

		if (!paciente.getMedicos().isEmpty()) {
			List<String> tmpMedicosIdUsuario = new ArrayList<>();
			paciente.getMedicos().forEach(a -> {
				tmpMedicosIdUsuario.add(String.valueOf(a.getIdUsuario()));
			});
			p.setMedicosIdUsuario(tmpMedicosIdUsuario);
		}

		return p;
	}

	private Paciente convertToEntity(PacienteDTO pacienteDTO) {
		Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);

		return paciente;
	}

}
