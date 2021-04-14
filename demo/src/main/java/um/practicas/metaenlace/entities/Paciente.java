package um.practicas.metaenlace.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "pacientes")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Paciente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "NSS", length = 10, nullable = false)
	private String NSS;
	@Column(name = "Num_Tarjeta", length = 20, nullable = false)
	private String numTarjeta;
	@Column(name = "Telefono", length = 10, nullable = false)
	private String telefono;
	@Column(name = "Direccion", length = 10, nullable = false)
	private String direccion;

	
	@JoinTable(name = "paciente_medico", 
			joinColumns = { @JoinColumn(name = "paciente_id", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "medico_id", nullable = false) })
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Medico> medicos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="paciente", orphanRemoval = true)
	private Set<Cita> citas;

	public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta,
			String telefono, String direccion) {

		super(nombre, apellidos, usuario, clave);
		this.NSS = NSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		citas = new HashSet<Cita>();
		medicos = new HashSet<Medico>();

	}
	
	public Paciente() {
		super();
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String NSS) {
		this.NSS = NSS;
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

	public Set<Medico> getMedicos() {
		return new HashSet<Medico>(medicos);
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}

	
	public void addCita(Cita cita) {
		citas.add(cita);
	}
	
	public void addMedico(Medico medico) {
		medicos.add(medico);
	}
	
}
