package um.practicas.metaenlace.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import um.practicas.metaenlace.entities.Cita;
import um.practicas.metaenlace.entities.Medico;
import um.practicas.metaenlace.entities.Paciente;
import um.practicas.metaenlace.servicies.CitaService;
import um.practicas.metaenlace.servicies.dto.CitaDTO;
import um.practicas.metaenlace.servicies.dto.MedicoDTO;
import um.practicas.metaenlace.servicies.dto.PacienteDTO;

@CrossOrigin(origins = "http://localhost:4200", maxAge =3600)
@RestController
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<CitaDTO>> listAll() {
		return ResponseEntity.ok(citaService.listAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CitaDTO> get(@PathVariable("id") Integer id) {

		Cita c = citaService.get(id);
		if (c != null)
			return ResponseEntity.ok(convertToDTO(c));

		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/listarbymedico/{idMedico}")
	public ResponseEntity<List<CitaDTO>> listIdMedico(@PathVariable("idMedico") Integer idMedico) {
		return ResponseEntity.ok(citaService.listbyIdMedico(idMedico).stream().map(this::convertToDTO).collect(Collectors.toList()));
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (citaService.delete(id))
			return ResponseEntity.ok("Cita eliminada correctamente");
		return ResponseEntity.notFound().build();	
	}

	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody CitaDTO citaDTO, @RequestBody PacienteDTO pacienteDTO, @RequestBody MedicoDTO medicoDTO) {
		
		if (citaService.create(convertToEntity(citaDTO), convertToEntity(pacienteDTO), convertToEntity(medicoDTO)))
			return ResponseEntity.ok("Cita insertada correctamente");
		return ResponseEntity.status(409).build();
	}
	
	
	@PostMapping("/{idPaciente}/{idMedico}")
	public ResponseEntity<String> insert(@RequestBody CitaDTO citaDTO, @PathVariable int idPaciente, @PathVariable int idMedico) {
		
		Cita c = convertToEntity(citaDTO);
		
		
		if (citaService.create(c, idPaciente, idMedico))
			return ResponseEntity.ok("Cita insertada correctamente");
		return ResponseEntity.status(409).build();
	}
	
	
	@PutMapping
	public ResponseEntity<String> modify(@RequestBody CitaDTO citaDTO) {
		if(citaService.update(convertToEntity(citaDTO)))
			return ResponseEntity.ok("Cita modificada correctamente"); 
		return ResponseEntity.notFound().build();
	}

	private CitaDTO convertToDTO(Cita cita) {

		return modelMapper.map(cita, CitaDTO.class);
	}
	private Cita convertToEntity(CitaDTO citaDTO) {
		
		return modelMapper.map(citaDTO, Cita.class);

	}
	
	private Medico convertToEntity(MedicoDTO medicoDTO) {
		return modelMapper.map(medicoDTO, Medico.class);

	}
	

	private Paciente convertToEntity(PacienteDTO pacienteDTO) {
		Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);

		return paciente;
	}
	
}
