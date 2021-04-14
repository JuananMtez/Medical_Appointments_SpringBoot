package um.practicas.metaenlace.servicies.dto;

import java.io.Serializable;

public class CitaDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private String idCita;
	private String fechaHora;
	private String pacienteNombre;
	private String pacienteApellidos;
	private String medicoNombre;
	private String medicoApellidos;
	private String motivoCita;
	private String diagnosticoValoracionEspecialista;

	
	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getPacienteNombre() {
		return pacienteNombre;
	}

	public void setPacienteNombre(String pacienteNombre) {
		this.pacienteNombre = pacienteNombre;
	}

	public String getPacienteApellidos() {
		return pacienteApellidos;
	}

	public void setPacienteApellidos(String pacienteApellidos) {
		this.pacienteApellidos = pacienteApellidos;
	}

	public String getMedicoNombre() {
		return medicoNombre;
	}

	public void setMedicoNombre(String medicoNombre) {
		this.medicoNombre = medicoNombre;
	}

	public String getMedicoApellidos() {
		return medicoApellidos;
	}

	public void setMedicoApellidos(String medicoApellidos) {
		this.medicoApellidos = medicoApellidos;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public String getDiagnosticoValoracionEspecialista() {
		return diagnosticoValoracionEspecialista;
	}

	public void setDiagnosticoValoracionEspecialista(String diagnosticoValoracionEspecialista) {
		this.diagnosticoValoracionEspecialista = diagnosticoValoracionEspecialista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
