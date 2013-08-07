DROP DATABASE evaluacion_proyectos_test;
CREATE DATABASE IF NOT EXISTS evaluacion_proyectos_test;
USE evaluacion_proyectos_test;

SET GLOBAL max_allowed_packet = 1024*1024*1024*10;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'latin1';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS evaluacion (
  id_evaluacion varchar(32) NOT NULL,  
  descripcion varchar(200) NOT NULL,
  descripcion_detallada varchar(300) NULL,
  exposicion_por int(1) NOT NULL COMMENT '1-exposicion,2-presentacion,3-ambos',
  fecha date NULL,  
  PRIMARY KEY (id_evaluacion)
) ;

CREATE TABLE IF NOT EXISTS categoria (
  id_categoria int(2) NOT NULL,  
  descripcion varchar(150) NOT NULL,  
  PRIMARY KEY (id_categoria)
) ;

CREATE TABLE IF NOT EXISTS proyecto (
  id_proyecto  varchar(32) NOT NULL,  
  nombre varchar(200) NOT NULL,
  id_categoria int(2) NOT NULL,
  logo longblob NULL,
  archivo_presentacion longblob NULL,
  foto longblob NULL,
  responsable varchar(120) NOT NULL,
  integrantes varchar(700) NULL,
  PRIMARY KEY (id_proyecto),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ;

CREATE TABLE IF NOT EXISTS evaluacion_proyectos (
  id_evaluacion varchar(32) NOT NULL, 
  id_proyecto  varchar(32) NOT NULL, 
  UNIQUE(id_evaluacion, id_proyecto),
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion) ON DELETE CASCADE,
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto) ON DELETE CASCADE
) ;

CREATE TABLE IF NOT EXISTS evaluador (
  id_evaluador  varchar(32) NOT NULL,  
  nombre varchar(200) NOT NULL,
  especialidad varchar(300) NOT NULL,
  PRIMARY KEY (id_evaluador)
) ;

CREATE TABLE IF NOT EXISTS evaluacion_evaluadores (
  id_evaluacion  varchar(32) NOT NULL, 
  id_evaluador  varchar(32) NOT NULL, 
  UNIQUE(id_evaluacion, id_evaluador),
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion) ON DELETE CASCADE,
  FOREIGN KEY (id_evaluador) REFERENCES evaluador(id_evaluador) ON DELETE CASCADE
) ;

CREATE TABLE IF NOT EXISTS rubrica (
  id_rubrica varchar(32) NOT NULL,    
  id_categoria int(2) NULL,
  PRIMARY KEY (id_rubrica),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ;

CREATE TABLE IF NOT EXISTS escala (
  id_escala int(2) NOT NULL,  
  inicio int(4) NOT NULL,
  fin int(4) NOT NULL,  
  PRIMARY KEY (id_escala)
) ;

CREATE TABLE IF NOT EXISTS item_rubrica (
  id_item_rubrica int(4) NOT NULL,
  descripcion_corta varchar(150) NOT NULL,  
  descripcion_larga varchar(300) NOT NULL,
  id_escala int(2) NOT NULL,
  PRIMARY KEY (id_item_rubrica),
  FOREIGN KEY (id_escala) REFERENCES escala(id_escala) ON DELETE CASCADE
) ;

CREATE TABLE IF NOT EXISTS rubrica_items_rubrica (
  id_rubrica varchar(32) NOT NULL,  
  id_item_rubrica int(4) NOT NULL,
  FOREIGN KEY (id_rubrica) REFERENCES rubrica(id_rubrica),
  FOREIGN KEY (id_item_rubrica) REFERENCES item_rubrica(id_item_rubrica)
) ;

CREATE TABLE IF NOT EXISTS resultado (
  id_evaluacion  varchar(32) NOT NULL,  
  id_proyecto  varchar(32) NOT NULL,
  id_evaluador  varchar(32) NOT NULL,
  id_rubrica varchar(32) NOT NULL,
  id_item_rubrica int(4) NOT NULL,
  calificacion double NULL,
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion) ON DELETE CASCADE,
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto) ON DELETE CASCADE,
  FOREIGN KEY (id_evaluador) REFERENCES evaluador(id_evaluador) ON DELETE CASCADE,
  FOREIGN KEY (id_rubrica) REFERENCES rubrica(id_rubrica) ON DELETE CASCADE,
  FOREIGN KEY (id_item_rubrica) REFERENCES item_rubrica(id_item_rubrica) ON DELETE CASCADE
) ;

CREATE TABLE IF NOT EXISTS usuario (
  nombre_usuario varchar(32) NOT NULL,  
  clave varchar(32) NOT NULL,
  fecha_creacion date NOT NULL,
  activo tinyint(1) NOT NULL,
  UNIQUE(nombre_usuario),
  PRIMARY KEY (nombre_usuario)
) ;

CREATE TABLE IF NOT EXISTS roles (
  id_role int(2) NOT NULL,  
  role varchar(32) NOT NULL,
  UNIQUE(role),
  PRIMARY KEY (id_role)
) ;

CREATE TABLE IF NOT EXISTS usuario_roles (
  nombre_usuario varchar(32) NOT NULL,
  id_role int(2) NOT NULL, 
  FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario) ON DELETE CASCADE,
  FOREIGN KEY (id_role) REFERENCES roles(id_role) ON DELETE CASCADE
) ;

CREATE TABLE IF NOT EXISTS usuario_evaluador (
  nombre_usuario varchar(32) NOT NULL,
  id_evaluador  varchar(32) NOT NULL,
  FOREIGN KEY(nombre_usuario) REFERENCES usuario(nombre_usuario) ON DELETE CASCADE,
  FOREIGN KEY(id_evaluador) REFERENCES evaluador(id_evaluador) ON DELETE CASCADE
) ;

insert into roles (id_role, role) values (1, 'EVALUADOR');
insert into roles (id_role, role) values (2, 'ADMINISTRADOR');
insert into roles (id_role, role) values (3, 'MANAGER');

