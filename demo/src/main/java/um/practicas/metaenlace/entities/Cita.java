package um.practicas.metaenlace.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita")
	@SequenceGenerator(name = "seq_cita", allocationSize = 1)
	private int idCita;

	@Column(name = "Fecha_Hora", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaHora;

	@Column(name = "Motivo_Cita", length = 200, nullable = false)
	private String motivoCita;

	@ManyToOne
	@JoinColumn(name = "cita_paciente_id", nullable=false, updatable = true)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "cita_medico_id", nullable= false, updatable = true)
	private Medico medico;


	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "diagnostico_id", referencedColumnName = "idDiagnostico", nullable = true)
	private Diagnostico diagnostico;

	public Cita(Date fechaHora, String motivoCita, Paciente paciente, Medico medico, Diagnostico diagnostico) {

		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;

	}

	public Cita(Date fechaHora, String motivoCita, Paciente paciente, Medico medico) {

		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Cita() {
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

}
