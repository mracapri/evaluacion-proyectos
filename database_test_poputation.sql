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
(4, 'Software Web');

/*Proyectos*/
insert into proyecto (id_proyecto, nombre, id_categoria, logo, archivo_presentacion, foto, responsable, integrantes) 
values ('96a3be3cf272e017046d1b2674a52bd3', 'Aplicacion para kinect', 2, null, null, null, 'Joel Morales', null),
('a2ef406e2c2351e0b9e80029c909242d', 'Pagina para el IFE', 4, null, null, null, 'Andres Dominguez', null),
('e88a49bccde359f0cabb40db83ba6080', 'Aplicacion para Automoviles', 5, null, null, null, 'Jonatan Gutierrez', null);

/*Proyectos por evaluacion*/
INSERT INTO evaluacion_proyectos (id_evaluacion,id_proyecto) VALUES 
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3'),
('25bbdcd06c32d477f7fa1c3e4a91b032', 'a2ef406e2c2351e0b9e80029c909242d'),
('fcd04e26e900e94b9ed6dd604fed2b64', 'e88a49bccde359f0cabb40db83ba6080');

/*Rubricas*/
insert into rubrica ( id_rubrica, id_categoria ) 
values ('dc5c7986daef50c1e02ab09b442ee34f', 1),
('93dd4de5cddba2c733c65f233097f05a', 2);

/*Escalas*/
insert into escala ( id_escala, inicio, fin)
values (1, 0, 100);

/*Calificacion Criterios*/
/*insert into calificacion_criterios ( id_calificacion, inicio, fin, etiqueta ) 
values (1, 0, 50, 'Deficiente'),
(2, 51, 70, 'No aceptable'),
(3, 71, 80, 'Regular'),
(4, 81, 90, 'Satisfactorio'),
(5, 91, 100, 'Excelente');*/

/*Items Rubricas*/
insert into item_rubrica ( id_item_rubrica, descripcion_corta, descripcion_larga, id_escala ) 
values (1, 'No hay faltas de ortografía ni errores gramaticales presentadas en el contenido', 'No hay faltas de ortografía ni errores gramaticales presentadas en el contenido', 1),
(2, 'La organización del material es adecuada para el usuario o grupo al que va dirigido', 'La organización del material es adecuada para el usuario o grupo al que va dirigido', 1),
(3, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(4, 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 1),
(5, 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 1),

(6, 'No hay faltas de ortografía ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortografía ni errores gramaticales en las pantallas del proyecto', 1),
(7, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(8, 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 1),
(9, 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 1),
(10, 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(11, 'El software realiza conectividad a base de datos y/o a recursos externos', 'El software realiza conectividad a base de datos y/o a recursos externos', 1),
(12, 'El software maneja roles operativos en la aplicación para administración y o control del mismo', 'El software maneja roles operativos en la aplicación para administración y o control del mismo', 1),

(13, 'No hay faltas de ortografía ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortografía ni errores gramaticales en las pantallas del proyecto', 1),
(14, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(15, 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales', 1),
(16, 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente', 1),
(17, 'La aplicación es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'La aplicación es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(18, 'La aplicación realiza conectividad a base de datos internas y/o a servicios externos', 'La aplicación realiza conectividad a base de datos internas y/o a servicios externos', 1),
(19, 'La aplicación se dibuja correctamente en la pantalla', 'La aplicación se dibuja correctamente en la pantalla', 1),

(20,'No hay faltas de ortografía ni errores gramaticales','No hay faltas de ortografía ni errores gramaticales',1),
(21,'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)','El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)',1),
(22,'Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales.','Manejo diestro del software de diseño, con mucha habilidad y uso de herramientas especiales.',1),
(23,'Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente','Cubre la información necesaria para el tema del proyecto. La presentación y distribución de la información es excelente',1),
(24,'El sitio web presenta la estructura de (encabezado, contenido, menu y pie de página)','El sitio web presenta la estructura de (encabezado, contenido, menu y pie de página)',1),
(25,'El sitio web presena adecuadamente la distribucion de controles','El sitio web presena adecuadamente la distribucion de controles',1),
(26,'El sitio web trata adecudamente el manejo de colores','El sitio web trata adecudamente el manejo de colores',1),
(27,'El sitio web define el objetivo para el cual fue desarrollado','El sitio web define el objetivo para el cual fue desarrollado',1),
(28,'El sitio web se integra con redes sociales','El sitio web se integra con redes sociales',1),
(29,'El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc','El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc',1),
(30,'El sitio web realiza conectividad a base de datos y/o a servicios externos','El sitio web realiza conectividad a base de datos y/o a servicios externos',1),
(31,'El sitio web se dibuja correctamente en la pantalla','El sitio web se dibuja correctamente en la pantalla',1);