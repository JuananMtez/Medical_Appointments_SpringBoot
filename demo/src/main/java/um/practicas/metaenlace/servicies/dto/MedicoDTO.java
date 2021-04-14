package um.practicas.metaenlace.servicies.dto;

import java.io.Serializable;
import java.util.List;

public class MedicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String idUsuario;
	private String numColegiado;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	
	
	private List<String> pacientesIdUsuario;
	private List<CitaDTO> citas;

	

	
	
	
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	


	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<String> getPacientesIdUsuario() {
		return pacientesIdUsuario;
	}

	public void setPacientesIdUsuario(List<String> pacientesIdUsuario) {
		this.pacientesIdUsuario = pacientesIdUsuario;
	}

	public List<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
