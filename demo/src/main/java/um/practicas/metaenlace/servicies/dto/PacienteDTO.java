package um.practicas.metaenlace.servicies.dto;

import java.io.Serializable;
import java.util.List;

public class PacienteDTO implements Serializable {

	static final long serialVersionUID = 1L;

	private String idUsuario;
	private String NSS;
	private String numTarjeta;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	private String telefono;
	private String direccion;

	private List<String> medicosIdUsuario;
	private List<CitaDTO> citas;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String NSS) {
		this.NSS = NSS;
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

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<CitaDTO> getCitas() {
		return citas;
	}

	public void setCitas(List<CitaDTO> citas) {
		this.citas = citas;
	}

	public List<String> getMedicosIdUsuario() {
		return medicosIdUsuario;
	}

	public void setMedicosIdUsuario(List<String> medicosIdUsuario) {
		this.medicosIdUsuario = medicosIdUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	/*
	 * public List<String> getMedicos() { return medicos; }
	 * 
	 * public void setMedicos(List<String> medicos) { this.medicos = medicos; }
	 */
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
