DROP TABLE usuarios CASCADE CONSTRAINTS;
DROP SEQUENCE seq_usuario;
CREATE SEQUENCE seq_usuario START WITH 1 INCREMENT BY 1;
CREATE TABLE usuarios (
	id_usuario number(10,0) NOT NULL, 
	apellidos VARCHAR2(30) NOT NULL, 
	clave VARCHAR2(10) NOT NULL, 
	nombre VARCHAR2(10) NOT NULL, 
	usuario VARCHAR2(100) NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);

DROP TABLE pacientes CASCADE CONSTRAINTS;
CREATE TABLE pacientes (
	id_usuario number(10,0) NOT NULL,
	nss VARCHAR2(10) NOT NULL, 
	direccion VARCHAR2(10) NOT NULL, 
	num_tarjeta VARCHAR2(20) NOT NULL, 
	telefono VARCHAR2(10) NOT NULL,
	CONSTRAINT paciente_pk PRIMARY KEY (id_usuario),
	CONSTRAINT fk_usuario_paciente FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)	
);
	
DROP TABLE medicos CASCADE CONSTRAINTS;
CREATE TABLE medicos (
	id_usuario number(10,0) NOT NULL, 
	num_colegiado VARCHAR2(10) NOT NULL, 
	CONSTRAINT medico_pk PRIMARY KEY (id_usuario),
	CONSTRAINT fk_usuario_medico FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)	

);

DROP TABLE paciente_medico CASCADE CONSTRAINTS;
CREATE TABLE paciente_medico (
	paciente_id number(10,0) NOT NULL,
	medico_id number(10,0) NOT NULL, 
	PRIMARY KEY (paciente_id, medico_id),
	CONSTRAINT fk_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes(id_usuario),
	CONSTRAINT fk_medico_id FOREIGN KEY (medico_id) REFERENCES medicos(id_usuario)
);

DROP TABLE citas CASCADE CONSTRAINTS;
DROP SEQUENCE seq_cita;
CREATE SEQUENCE seq_cita START WITH 1 INCREMENT BY 1;
CREATE TABLE citas (
	id_cita number(10,0) NOT NULL,
	fecha_hora DATE NOT NULL,
	motivo_cita VARCHAR2(200) NOT NULL,
	cita_medico_id number(10,0), 
	cita_paciente_id number(10,0),
	CONSTRAINT cita_pk PRIMARY KEY (id_cita),
	CONSTRAINT fk_cita_medico_id FOREIGN KEY (cita_medico_id) REFERENCES medicos(id_usuario),
	CONSTRAINT fk_cita_paciente_id FOREIGN KEY (cita_paciente_id) REFERENCES pacientes(id_usuario)
);
DROP TABLE diagnosticos CASCADE CONSTRAINTS;
DROP SEQUENCE seq_diagnostico;
CREATE SEQUENCE seq_diagnostico START WITH 1 INCREMENT BY 1;
CREATE TABLE diagnosticos (
	id_diagnostico number(10,0) NOT NULL,
	enfermedad VARCHAR2(50) NOT NULL, 
	valoracion_especialista VARCHAR2(200) NOT NULL, 
	CONSTRAINT diagnostico PRIMARY KEY (id_diagnostico)
);	


