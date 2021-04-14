package um.practicas.metaenlace.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Medico extends Usuario {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Num_Colegiado", length = 10, nullable = false)
	private String numColegiado;

	@ManyToMany(mappedBy = "medicos", cascade = CascadeType.ALL)
	private Set<Paciente> pacientes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="medico", orphanRemoval = true)
	private Set<Cita> citas;

	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {

		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
		pacientes = new HashSet<Paciente>();
		citas = new HashSet<Cita>();
	}
	
	public Medico() {
		super();
	}
	

	public String getNumColegiado() {
		return numColegiado;
	}

	public Set<Cita> getCitas() {
		return new HashSet<Cita>(citas);
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Set<Paciente> getPacientes() {
		return new HashSet<Paciente>(pacientes);
	}

	public void setPacientes(Set<Paciente> set) {
		this.pacientes = set;
	}
	
	public void addCita(Cita cita) {
		citas.add(cita);
	}
	
	public void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

}
