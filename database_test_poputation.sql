SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'UTF8';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*Evaluaciones*/
insert into evaluacion (id_evaluacion, descripcion, descripcion_detallada, fecha) 
values (1, 'Evaluacion TIC 2013', 'Descripcion detallada Software', '2013-07-29'),
(2, 'Evaluacion TIC 2014', 'Descripcion detallada Software', '2014-07-29');

/*Categorias*/
insert into categoria ( id_categoria, descripcion ) 
values (1, 'Software Multimedia'),
(2, 'Software Escritorio'),
(3, 'Software Moviles'),
(4, 'Software Web'),
(5, 'Software de Presentación');

/*Proyectos*/
insert into proyecto (id_proyecto, nombre, id_categoria, logo, archivo_presentacion, foto, responsable, integrantes) 
values ('000001', 'Aplicacion para kinect', 1, null, null, null, 'Joel Morales', null),
('000002', 'Pagina para el IFE', 2, null, null, null, 'Andres Dominguez', null);

/*Rubricas*/
insert into rubrica ( id_rubrica, id_categoria ) 
values ('0001', 1),
('0002', 2);