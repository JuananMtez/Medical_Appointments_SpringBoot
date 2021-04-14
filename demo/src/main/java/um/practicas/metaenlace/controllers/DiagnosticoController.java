package um.practicas.metaenlace.controllers;

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

import um.practicas.metaenlace.servicies.DiagnosticoService;
import um.practicas.metaenlace.servicies.dto.DiagnosticoDTO;
import um.practicas.metaenlace.servicies.dto.PacienteDTO;
import um.practicas.metaenlace.entities.Diagnostico;
import um.practicas.metaenlace.entities.Paciente;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

	@Autowired
	private DiagnosticoService diagnosticoService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<DiagnosticoDTO>> list() {

		return ResponseEntity
				.ok(diagnosticoService.listAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DiagnosticoDTO> get(@PathVariable("id") Integer id) {
		Diagnostico d = diagnosticoService.get(id);
		if (d != null)
			return ResponseEntity.ok(convertToDTO(d));
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (diagnosticoService.delete(id))
			return ResponseEntity.ok("Diagnostico eliminado correctamente");
		return ResponseEntity.notFound().build();	
		
	}

	@PostMapping
	public  ResponseEntity<String> insert(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		
		//Diagnostico diagnostico = convertToEntity(diagnosticoDTO);
		Diagnostico diagnostico = new Diagnostico(diagnosticoDTO.getValoracionEspecialista(), diagnosticoDTO.getEnfermedad());
		if (diagnosticoService.create(diagnostico, diagnosticoDTO.getIdCita()))
			return ResponseEntity.ok("Diagnostico creado correctamente");
		return ResponseEntity.status(409).build();
		
		
		
		
	}

	
	
	@PutMapping
	public ResponseEntity<String> modify(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		if (diagnosticoService.update(convertToEntity(diagnosticoDTO)))
			return ResponseEntity.ok("Diagnostico modificado correctamente");
		return ResponseEntity.notFound().build();
	}

	private DiagnosticoDTO convertToDTO(Diagnostico diagnostico) {

		DiagnosticoDTO dDTO = modelMapper.map(diagnostico, DiagnosticoDTO.class);
		return dDTO;
	}
	
	private Diagnostico convertToEntity(DiagnosticoDTO diagnosticoDTO) {
		Diagnostico d = new Diagnostico(diagnosticoDTO.getValoracionEspecialista(), diagnosticoDTO.getEnfermedad());
		d.setIdDiagnostico(Integer.valueOf(diagnosticoDTO.getIdDiagnostico()));
		return d;
	}
	
}