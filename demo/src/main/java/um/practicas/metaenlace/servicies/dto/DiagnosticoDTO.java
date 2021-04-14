package um.practicas.metaenlace.servicies.dto;

import java.io.Serializable;

public class DiagnosticoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idDiagnostico;
	private String idCita;
	private String citaPacienteNombre;
	private String citaPacienteApellidos;
	private String citaMedicoNombre;
	private String citaMedicoApellidos;
	private String citaMotivoCita;
	private String enfermedad;
	private String valoracionEspecialista;

	public String getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(String idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getCitaPacienteNombre() {
		return citaPacienteNombre;
	}

	public void setCitaPacienteNombre(String citaPacienteNombre) {
		this.citaPacienteNombre = citaPacienteNombre;
	}

	public String getCitaPacienteApellidos() {
		return citaPacienteApellidos;
	}

	public void setCitaPacienteApellidos(String citaPacienteApellidos) {
		this.citaPacienteApellidos = citaPacienteApellidos;
	}

	public String getCitaMedicoNombre() {
		return citaMedicoNombre;
	}

	public void setCitaMedicoNombre(String citaMedicoNombre) {
		this.citaMedicoNombre = citaMedicoNombre;
	}

	public String getCitaMedicoApellidos() {
		return citaMedicoApellidos;
	}

	public void setCitaMedicoApellidos(String citaMedicoApellidos) {
		this.citaMedicoApellidos = citaMedicoApellidos;
	}

	public String getCitaMotivoCita() {
		return citaMotivoCita;
	}

	public void setCitaMotivoCita(String citaMotivoCita) {
		this.citaMotivoCita = citaMotivoCita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
