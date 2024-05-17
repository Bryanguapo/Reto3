CREATE DATABASE retoFutbol;
USE retoFutbol;

CREATE TABLE usuarios (
 idUsuarios INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR (30),
 apellido VARCHAR (30),
 correo VARCHAR (30),
 contrasena VARCHAR (300),
 puntos INT,
 fechaJugada DATE
);

CREATE TABLE empleados (
  idEmpleados INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  correo VARCHAR(50),
  sueldo INT,
  localidad VARCHAR(50)
);

INSERT INTO empleados (nombre, apellido, correo, sueldo, localidad) VALUES
('Juan', 'Martínez', 'juan.martinez@example.com', 2500, 'Madrid'),
('María', 'García', 'maria.garcia@example.com', 2800, 'Barcelona'),
('Pedro', 'López', 'pedro.lopez@example.com', 2700, 'Sevilla'),
('Laura', 'Hernández', 'laura.hernandez@example.com', 2600, 'Valencia'),
('Carlos', 'González', 'carlos.gonzalez@example.com', 3000, 'Bilbao'),
('Ana', 'Rodríguez', 'ana.rodriguez@example.com', 2900, 'Málaga'),
('David', 'Martínez', 'david.martinez@example.com', 3100, 'Zaragoza'),
('Sara', 'Pérez', 'sara.perez@example.com', 3200, 'Alicante'),
('Javier', 'Sánchez', 'javier.sanchez@example.com', 2800, 'Palma de Mallorca'),
('Elena', 'Gómez', 'elena.gomez@example.com', 2700, 'Las Palmas');


CREATE TABLE preguntasFacil (
 idPreguntas INT PRIMARY KEY AUTO_INCREMENT,
 pregunta VARCHAR (100),
 imagenPregunta VARCHAR(300),
 respuestaCorrecta VARCHAR (30),
 respuestaDos VARCHAR (30),
 respuestaTres VARCHAR (30),
 respuestaCuatro VARCHAR (30)
);

INSERT INTO preguntasFacil (pregunta, imagenPregunta, respuestaCorrecta, respuestaDos, respuestaTres, respuestaCuatro) VALUES 
("¿En qué año ganó España el Mundial?", "./RETO_3EVA/img_preguntas/facil_uno.jpg", "2010", "2009", "2024", "2014"),
("¿Qué equipo juega en el Camp Nou como local?", "./RETO_3EVA/img_preguntas/facil_dos.jpg", "Barcelona", "Real Madrid", "Sevilla", "Athletic"),
("¿Quién es más joven?", "./RETO_3EVA/img_preguntas/facil_tres.jpg", "I Yamal", "Benzema", "Modric", "Ronaldo"),
("¿Qué equipo tiene más Champions?", "./RETO_3EVA/img_preguntas/facil_cuatro.jpg", "Real Madrid", "PSG", "Barça", "Liverpool"),
("¿Qué selección tiene más mundiales?", "./RETO_3EVA/img_preguntas/facil_cinco.jpg", "Brasil", "Argentina", "Inglaterra", "Francia"),
("¿Quién fue el número 10 del Barcelona antes de que lo tuviera Ansu Fati?", "./RETO_3EVA/img_preguntas/facil_seis.jpg", "Messi", "Ronaldo", "Mbappé", "Oyarzabal"),
("¿Quién fue el número 7 en el Real Madrid antes de que lo tuviera Eden Hazard?", "./RETO_3EVA/img_preguntas/facil_siete.jpg", "Ronaldo", "Messi", "Oyarzabal", "Mbappé"),
("¿Quién marcó en la final del Mundial del 2010?", "./RETO_3EVA/img_preguntas/facil_ocho.jpg", "Iniesta", "Puyol", "Robben", "Xabi Alonso"),
("¿Máximo ganador de la liga?", "./RETO_3EVA/img_preguntas/facil_nueve.jpg", "Real Madrid", "Barça", "Sevila", "Athletic"),
("¿Desde cuántos metros se lanza un penalti?", "./RETO_3EVA/img_preguntas/facil_diez.jpg", "11", "5", "50", "22");

CREATE TABLE preguntasMedio (
 idPreguntas INT PRIMARY KEY AUTO_INCREMENT,
 pregunta VARCHAR (100),
 imagenPregunta VARCHAR(300),
 respuestaCorrecta VARCHAR (30),
 respuestaDos VARCHAR (30),
 respuestaTres VARCHAR (30),
 respuestaCuatro VARCHAR (30)
);

INSERT INTO preguntasMedio (pregunta, imagenPregunta, respuestaCorrecta, respuestaDos, respuestaTres, respuestaCuatro) VALUES 
("¿En qué equipo juega Ansu Fati?", "./RETO_3EVA/img_preguntas/medio_uno.jpg", "Brighton", "Barça", "PSG", "Bayern"),
("¿Cuántas Champions tiene el Real Madrid?", "./RETO_3EVA/img_preguntas/medio_dos.jpg", "14", "13", "15", "16"),
("¿Cuántos años tiene CR7?", "./RETO_3EVA/img_preguntas/medio_tres.jpg", "39", "38", "31", "35"),
("¿De qué país es el equipo LA Galaxy?", "./RETO_3EVA/img_preguntas/medio_cuatro.jpg", "EEUU", "España", "Inglaterra", "Alemania"),
("¿Quién es el jugador con más goles oficiales de la historia?", "./RETO_3EVA/img_preguntas/medio_cinco.jpg", "Cristiano Ronaldo", "Messi", "Pelé", "Lewandoski"),
("¿En temporada ganó la Real Sociedad su último trofeo?", "./RETO_3EVA/img_preguntas/medio_seis.jpg", "2019-2020", "2020-2021", "2018-2019", "2021-2022"),
("¿Qué equipo ganó la Ligue 1 en 2020-2021?", "./RETO_3EVA/img_preguntas/medio_siete.jpg", "Lille OSC", "PSG", "Rennes", "Monaco"),
("¿Quién es el equipo que ha ganado más veces la Copa Libertadores?", "./RETO_3EVA/img_preguntas/medio_ocho.jpg", "Independiente de Aellaneda", "River Plate", "Peñarol", "Boca Junior"),
("¿Quién es el único equipo ingles que tiene una Premier League de oro?", "./RETO_3EVA/img_preguntas/medio_nueve.jpg", "Arsenal", "Manchester United", "Chelsea", "Manchester City"),
("¿Qué país tiene más mundiales?", "./RETO_3EVA/img_preguntas/medio_diez.jpg", "Brasil", "Argentina", "Inglaterra", "Francia");

CREATE TABLE preguntasDificil (
 idPreguntas INT PRIMARY KEY AUTO_INCREMENT,
 pregunta VARCHAR (100),
 imagenPregunta VARCHAR(300),
 respuestaCorrecta VARCHAR (30),
 respuestaDos VARCHAR (30),
 respuestaTres VARCHAR (30),
 respuestaCuatro VARCHAR (30)
);

INSERT INTO preguntasDificil (pregunta, imagenPregunta, respuestaCorrecta, respuestaDos, respuestaTres, respuestaCuatro) VALUES 
("¿Cuántas ligas tiene la Real Sociedad?", "./RETO_3EVA/img_preguntas/dificil_uno.jpg", "2", "4", "6", "5"),
("¿En cuántos equipos ha jugado Sebastián 'Loco' Abreu?", "./RETO_3EVA/img_preguntas/dificil_dos.jpg", "32", "37", "12", "6"),
("¿Cuántas ligas ganó el Manchester United bajo el mandato de Alex Ferguson?", "./RETO_3EVA/img_preguntas/dificil_tres.jpg", "13", "15", "9", "14"),
("¿Cuántos goles marcó Kylian Mbappé en el Eurocopa Sub-19 de 2016?", "./RETO_3EVA/img_preguntas/dificil_cuatro.jpg", "5", "6", "7", "8"),
("¿En cuántos equipos ha jugado David Beckham?", "./RETO_3EVA/img_preguntas/dificil_cinco.jpg", "5", "6", "4", "7"),
("¿Cuál fue el máximo de goles que marcó CR7 en el Manchester United en una sola temporada?", "./RETO_3EVA/img_preguntas/dificil_seis.jpg", "42", "55", "33", "48"),
("¿Quién fue el máximo goleador de la historia de los Mundiales?", "./RETO_3EVA/img_preguntas/dificil_siete.jpg", "Miroslav Klose", "Gerhard Muller", "Mbappé", "Pelé"),
("¿Cuál es el máximo goleador del Betis?", "Rubén Castro", "./RETO_3EVA/img_preguntas/dificil_ocho.jpg", "Manuel Domínguez", "Rogelio Sosa", "Poli Rincón"),
("¿Quién es el jugador con más partidos en los Mundiales?", "./RETO_3EVA/img_preguntas/dificil_nueve.jpg", "Messi", "Lothar Matthaus", "Miroslav Klose", "Cristiano Ronaldo"),
("¿Qué jugador tiene mejor promedio goleador de la historia?", "./RETO_3EVA/img_preguntas/dificil_nueve.jpg", "Fernando Peyroteo", "Josef Bican", "Puskas", "Pelé");


CREATE TABLE proponerPreguntas (
  idProponerPreguntas INT PRIMARY KEY AUTO_INCREMENT,
  idUsuarios INT,
  idEmpleados INT,
  pregunta VARCHAR (100),
  imagenPregunta VARCHAR(300),
  respuestaCorrecta VARCHAR (30),
  respuestaDos VARCHAR (30),
  respuestaTres VARCHAR (30),
  respuestaCuatro VARCHAR (30),
  
  FOREIGN KEY (idUsuarios) REFERENCES usuarios(idUsuarios),
  FOREIGN KEY (idEmpleados) REFERENCES empleados(idEmpleados)
);


SELECT * FROM usuarios;
SELECT * FROM empleados;
SELECT * FROM preguntasfacil;
SELECT * FROM preguntasmedio;
SELECT * FROM preguntasdificil;
SELECT * FROM proponerpreguntas;