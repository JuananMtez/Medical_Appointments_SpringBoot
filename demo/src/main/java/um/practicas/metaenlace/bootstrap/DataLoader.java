package um.practicas.metaenlace.bootstrap;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationListener;

import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import um.practicas.metaenlace.entities.*;
import um.practicas.metaenlace.repositories.*;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ICita citaRepo;
	@Autowired
	private IDiagnostico diagnosticoRepo;
	@Autowired
	private IMedico medicoRepo;
	@Autowired
	private IPaciente pacienteRepo;
	@Autowired
	private IUsuario usuarioRepo;

	/*
	 * @Bean public DataSourceInitializer
	 * dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
	 * ResourceDatabasePopulator resourceDatabasePopulator = new
	 * ResourceDatabasePopulator(); resourceDatabasePopulator.addScript(new
	 * ClassPathResource("/data.sql")); DataSourceInitializer dataSourceInitializer
	 * = new DataSourceInitializer();
	 * dataSourceInitializer.setDataSource(dataSource);
	 * dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator); return
	 * dataSourceInitializer; }
	 */

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Paciente pac = new Paciente("Pedro", "Ruiz", "pedro98", "admin", "9281823", "SMS12121212", "968820414",
				"pedro@");
	//	Paciente pac2 = new Paciente("Mario", "Quiles", "foster", "casica", "43443", "SMS32121", "P6709534", "@UM.ES");

	
		Medico med = new Medico("Pablo", "Sanchez", "erPablo", "dddd", "9124");
		Medico med2 = new Medico("Pablo2", "Sanchez2", "erPablo2", "dddd", "9889898");
		pac.addMedico(med);
		pac.addMedico(med2);
		med.addPaciente(pac);
		med2.addPaciente(pac);;

		Cita cita = new Cita(new Date(), "Cancer", pac, med);
		Diagnostico d = new Diagnostico("Buena", "Amigdalitis", cita);
		cita.setDiagnostico(d);
		
		pac.addCita(cita);
		med.addCita(cita);
		
		
		Cita cita2 = new Cita(new Date(), "Mal estado", pac, med2);
		Diagnostico d2 = new Diagnostico("Malisima", "CRANEO", cita2);
		//cita2.setDiagnostico(d2);
		pac.addCita(cita2);
		med2.addCita(cita2);
		
		pacienteRepo.save(pac);
		//pacienteRepo.save(pac2);
	//	medicoRepo.save(med);
		//medicoRepo.save(med2);
		//citaRepo.save(cita);
		//citaRepo.save(cita2);
		//diagnosticoRepo.save(d);
		//diagnosticoRepo.save(d2);


	}

}
