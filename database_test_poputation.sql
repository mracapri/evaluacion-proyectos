SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'UTF8';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*Evaluaciones*/
insert into evaluacion (id_evaluacion, descripcion, descripcion_detallada, fecha) 
values ('25bbdcd06c32d477f7fa1c3e4a91b032', 'Evaluacion TIC 2013', 'Descripcion detallada Software', '2013-07-29'),
('fcd04e26e900e94b9ed6dd604fed2b64', 'Evaluacion TIC 2014', 'Descripcion detallada Software', '2014-07-29');

/*Categorias*/
insert into categoria ( id_categoria, descripcion ) 
values (1, 'Software Multimedia'),
(2, 'Software Escritorio'),
(3, 'Software Moviles'),
(4, 'Software Web'),
(5, 'Software de Presentación');

/*Proyectos*/
insert into proyecto (id_proyecto, nombre, id_categoria, logo, archivo_presentacion, foto, responsable, integrantes) 
values ('96a3be3cf272e017046d1b2674a52bd3', 'Aplicacion para kinect', 2, null, null, null, 'Joel Morales', null),
('a2ef406e2c2351e0b9e80029c909242d', 'Pagina para el IFE', 4, null, null, null, 'Andres Dominguez', null),
('e88a49bccde359f0cabb40db83ba6080', 'Aplicacion para Automoviles', 5, null, null, null, 'Jonatan Gutierrez', null);

/*Proyectos por evaluacion*/
INSERT INTO evaluacion_proyectos (id_evaluacion,id_proyecto)
VALUES ('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3'),
('25bbdcd06c32d477f7fa1c3e4a91b032', 'a2ef406e2c2351e0b9e80029c909242d'),
VALUES ('fcd04e26e900e94b9ed6dd604fed2b64', 'e88a49bccde359f0cabb40db83ba6080');

/*Rubricas*/
insert into rubrica ( id_rubrica, id_categoria ) 
values ('dc5c7986daef50c1e02ab09b442ee34f', 1),
('93dd4de5cddba2c733c65f233097f05a', 2);