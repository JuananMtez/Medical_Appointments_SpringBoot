package um.practicas.metaenlace.entities;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diagnostico")
	@SequenceGenerator(name = "seq_diagnostico", allocationSize = 1)
	private int idDiagnostico;

	@Column(name = "Valoracion_Especialista", length = 200, nullable = false)
	private String valoracionEspecialista;

	@Column(name = "Enfermedad", length = 50, nullable = false)
	private String enfermedad;

	
	@OneToOne(mappedBy = "diagnostico", cascade = CascadeType.PERSIST)
    private Cita cita;

	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita cita) {

		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.cita = cita;
	}

	public Diagnostico(String valoracionEspecialista, String enfermedad) {

		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
	}

	public Diagnostico() {
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
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

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}
