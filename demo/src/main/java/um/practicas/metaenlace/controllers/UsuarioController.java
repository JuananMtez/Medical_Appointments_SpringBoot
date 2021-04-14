package um.practicas.metaenlace.controllers;

import java.util.List;
import java.util.stream.Collector;
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
import um.practicas.metaenlace.entities.Usuario;
import um.practicas.metaenlace.servicies.UsuarioService;
import um.practicas.metaenlace.servicies.dto.PacienteDTO;
import um.practicas.metaenlace.servicies.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> list() {
		return ResponseEntity
				.ok(usuarioService.listAll().stream().map(this::convertToDTO).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> get(@PathVariable("id") Integer id) {
		Usuario u = usuarioService.get(id);
		if (u != null)
			return ResponseEntity.ok(convertToDTO(u));
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (usuarioService.delete(id))
			return ResponseEntity.ok("Usuario eliminado correctamente");
		return ResponseEntity.notFound().build();
	}
/*
	@PostMapping
	public void insert(@RequestBody UsuarioDTO usuarioDTO) {
		
		if (pacienteService.create(convertToEntity(usuarioDT), pacienteDTO.getMedicosIdUsuario()))
			return ResponseEntity.ok("Paciente insertado correctamente");
		return ResponseEntity.status(409).build();	}
*/
	
/*	@PutMapping
	public void modify(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.update(usuarioDTO.getIdUsuario(), usuarioDTO.getUsuario(), usuarioDTO.getNombre(), usuarioDTO.getApellidos());
	}
*/
	private UsuarioDTO convertToDTO(Usuario usuario) {

		return modelMapper.map(usuario, UsuarioDTO.class);
	}
	

	
}
