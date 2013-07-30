DROP DATABASE evaluacion_proyectos;
CREATE DATABASE IF NOT EXISTS evaluacion_proyectos;
USE evaluacion_proyectos;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'UTF8';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS evaluacion (
  id_evaluacion varchar(32) NOT NULL,  
  descripcion varchar(200) NOT NULL,
  descripcion_detallada varchar(300) NULL,
  fecha date NULL,  
  PRIMARY KEY (id_evaluacion)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS categoria (
  id_categoria int(2) NOT NULL,  
  descripcion varchar(150) NOT NULL,  
  PRIMARY KEY (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS proyecto (
  id_proyecto  varchar(32) NOT NULL,  
  nombre varchar(200) NOT NULL,
  id_categoria int(2) NOT NULL,
  logo blob NULL,
  archivo_presentacion blob NULL,
  foto blob NULL,
  responsable varchar(120) NOT NULL,
  integrantes varchar(700) NULL,
  PRIMARY KEY (id_proyecto),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS evaluacion_proyectos (
  id_evaluacion varchar(32) NOT NULL, 
  id_proyecto  varchar(32) NOT NULL, 
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion),
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS evaluador (
  id_evaluador  varchar(10) NOT NULL,  
  nombre varchar(200) NOT NULL,
  especialidad varchar(300) NOT NULL,
  PRIMARY KEY (id_evaluador)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS evaluacion_evaluadores (
  id_evaluacion  varchar(32) NOT NULL, 
  id_evaluador  varchar(10) NOT NULL, 
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion),
  FOREIGN KEY (id_evaluador) REFERENCES evaluador(id_evaluador)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS rubrica (
  id_rubrica varchar(32) NOT NULL,    
  id_categoria int(2) NULL,
  PRIMARY KEY (id_rubrica),
  FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS escala (
  id_escala int(2) NOT NULL,  
  inicio int(4) NOT NULL,
  fin int(4) NOT NULL,
  PRIMARY KEY (id_escala)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS item_rubrica (
  id_item_rubrica int(4) NOT NULL,
  descripcion_corta varchar(150) NOT NULL,  
  descripcion_larga varchar(300) NOT NULL,
  id_escala int(2) NOT NULL,
  PRIMARY KEY (id_item_rubrica),
  FOREIGN KEY (id_escala) REFERENCES escala(id_escala)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS rubrica_items_rubrica (
  id_rubrica varchar(32) NOT NULL,  
  id_item_rubrica int(4) NOT NULL,
  FOREIGN KEY (id_rubrica) REFERENCES rubrica(id_rubrica),
  FOREIGN KEY (id_item_rubrica) REFERENCES item_rubrica(id_item_rubrica)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS resultado (
  id_evaluacion  varchar(32) NOT NULL,  
  id_proyecto  varchar(32) NOT NULL,
  id_rubrica varchar(32) NOT NULL,
  id_item_rubrica int(4) NOT NULL,
  calificacion double NULL,
  FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id_evaluacion),
  FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto),
  FOREIGN KEY (id_rubrica) REFERENCES rubrica(id_rubrica),
  FOREIGN KEY (id_item_rubrica) REFERENCES item_rubrica(id_item_rubrica)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;