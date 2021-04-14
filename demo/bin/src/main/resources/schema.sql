DROP TABLE usuario CASCADE CONSTRAINTS; 
CREATE TABLE usuario (
	id_usuario number(10,0) NOT NULL, 
	apellidos VARCHAR2(30) NOT NULL, 
	clave VARCHAR2(10) NOT NULL, 
	nombre VARCHAR2(10) NOT NULL, 
	usuario VARCHAR2(10) NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);

DROP TABLE paciente CASCADE CONSTRAINTS; 
CREATE TABLE paciente (
	id_usuario number(10,0) NOT NULL,
	nss VARCHAR2(10) NOT NULL, 
	direccion VARCHAR2(10) NOT NULL, 
	num_tarjeta VARCHAR2(20) NOT NULL, 
	telefono VARCHAR2(10) NOT NULL,
	CONSTRAINT paciente_pk PRIMARY KEY (id_usuario),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)	

);


DROP TABLE medico CASCADE CONSTRAINTS; 
CREATE TABLE medico (
	id_usuario number(10,0) NOT NULL, 
	num_colegiado VARCHAR2(10) NOT NULL, 
	CONSTRAINT medico_pk PRIMARY KEY (id_usuario),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)	

);
	
DROP TABLE paciente_medico CASCADE CONSTRAINTS; 
CREATE TABLE paciente_medico (
	paciente_id number(10,0) NOT NULL,
	medico_id number(10,0) NOT NULL, 
	CONSTRAINT paciente_pk PRIMARY KEY (paciente_id),
	CONSTRAINT medico_pk PRIMARY KEY (medico_id),
	CONSTRAINT fk_paciente_id FOREIGN KEY (paciente_id) REFERENCES paciente(id_usuario),
	CONSTRAINT fk_medico_id FOREIGN KEY (medico_id) REFERENCES medico(id_usuario)
);

 
DROP TABLE cita CASCADE CONSTRAINTS; 
CREATE TABLE cita (
	id_cita number(10,0) generated AS identity,
	fecha_hora DATE NOT NULL,
	motivo_cita VARCHAR2(200) NOT NULL,
	cita_medico_id number(10,0) NOT NULL, 
	cita_paciente_id number(10,0) NOT NULL,
	CONSTRAINT cita_pk PRIMARY KEY (id_cita),
	CONSTRAINT fk_cita_medico_id FOREIGN KEY (cita_medico_id) REFERENCES medico(id_usuario),
	CONSTRAINT fk_cita_paciente_id FOREIGN KEY (cita_paciente_id) REFERENCES paciente(id_usuario),
);
	
DROP TABLE diagnostico CASCADE CONSTRAINTS;  
CREATE TABLE diagnostico (
	id_diagnostico number(10,0) generated AS identity,
	enfermedad VARCHAR2(50) NOT NULL, 
	valoracion_especialista VARCHAR2(200) NOT NULL, 
	CONSTRAINT diagnostico PRIMARY KEY (id_diagnostico)
);	

DROP TABLE cita_diagnostico CASCADE CONSTRAINTS; 
CREATE TABLE cita_diagnostico (
	diagnostico_id number(10,0) NOT NULL,
	cita_id number(10,0) NOT NULL,
	CONSTRAINT cita_pk PRIMARY KEY (id_cita),
	CONSTRAINT fk_diagnostico FOREIGN KEY (diagnostico_id) REFERENCES diagnostico(id_diagnostico),
	CONSTRAINT fk_cita FOREIGN KEY (cita_id) REFERENCES diagnostico(id_cita)
);
	

CREATE sequence hibernate_sequence start WITH 1 increment BY  1;



	
