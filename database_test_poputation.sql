SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'latin1';

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
('e88a49bccde359f0cabb40db83ba6080', 'Aplicacion para Automoviles', 3, null, null, null, 'Jonatan Gutierrez', null);

/*Proyectos por evaluacion*/
INSERT INTO evaluacion_proyectos (id_evaluacion,id_proyecto) VALUES 
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3'),
('25bbdcd06c32d477f7fa1c3e4a91b032', 'a2ef406e2c2351e0b9e80029c909242d'),
('fcd04e26e900e94b9ed6dd604fed2b64', 'e88a49bccde359f0cabb40db83ba6080');

/*Rubricas*/
insert into rubrica ( id_rubrica, id_categoria ) 
values ('dc5c7986daef50c1e02ab09b442ee34f', 1),
('93dd4de5cddba2c733c65f233097f05a', 2),
('e45ee7ce7e88149af8dd32b27f9512ce', 3),
('7d0665438e81d8eceb98c1e31fca80c1', 4),
('751d31dd6b56b26b29dac2c0e1839e34', null);

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
values (1, 'No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido', 'No hay faltas de ortograf�a ni errores gramaticales presentadas en el contenido', 1),
(2, 'La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido', 'La organizaci�n del material es adecuada para el usuario o grupo al que va dirigido', 1),
(3, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(4, 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 1),
(5, 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 1),

(6, 'No hay faltas de ortograf�a ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortograf�a ni errores gramaticales en las pantallas del proyecto', 1),
(7, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(8, 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 1),
(9, 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 1),
(10, 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(11, 'El software realiza conectividad a base de datos y/o a recursos externos', 'El software realiza conectividad a base de datos y/o a recursos externos', 1),
(12, 'El software maneja roles operativos en la aplicaci�n para administraci�n y o control del mismo', 'El software maneja roles operativos en la aplicaci�n para administraci�n y o control del mismo', 1),

(13, 'No hay faltas de ortograf�a ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortograf�a ni errores gramaticales en las pantallas del proyecto', 1),
(14, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(15, 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales', 1),
(16, 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente', 1),
(17, 'La aplicaci�n es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'La aplicaci�n es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(18, 'La aplicaci�n realiza conectividad a base de datos internas y/o a servicios externos', 'La aplicaci�n realiza conectividad a base de datos internas y/o a servicios externos', 1),
(19, 'La aplicaci�n se dibuja correctamente en la pantalla', 'La aplicaci�n se dibuja correctamente en la pantalla', 1),

(20,'No hay faltas de ortograf�a ni errores gramaticales','No hay faltas de ortograf�a ni errores gramaticales',1),
(21,'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)','El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)',1),
(22,'Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales.','Manejo diestro del software de dise�o, con mucha habilidad y uso de herramientas especiales.',1),
(23,'Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente','Cubre la informaci�n necesaria para el tema del proyecto. La presentaci�n y distribuci�n de la informaci�n es excelente',1),
(24,'El sitio web presenta la estructura de (encabezado, contenido, menu y pie de p�gina)','El sitio web presenta la estructura de (encabezado, contenido, menu y pie de p�gina)',1),
(25,'El sitio web presena adecuadamente la distribucion de controles','El sitio web presena adecuadamente la distribucion de controles',1),
(26,'El sitio web trata adecudamente el manejo de colores','El sitio web trata adecudamente el manejo de colores',1),
(27,'El sitio web define el objetivo para el cual fue desarrollado','El sitio web define el objetivo para el cual fue desarrollado',1),
(28,'El sitio web se integra con redes sociales','El sitio web se integra con redes sociales',1),
(29,'El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc','El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc',1),
(30,'El sitio web realiza conectividad a base de datos y/o a servicios externos','El sitio web realiza conectividad a base de datos y/o a servicios externos',1),
(31,'El sitio web se dibuja correctamente en la pantalla','El sitio web se dibuja correctamente en la pantalla',1),

(32,'Item Rubrica de exposicion', 'Item Rubrica de exposicion',1);


insert into rubrica_items_rubrica ( id_rubrica,  id_item_rubrica ) 
values ('dc5c7986daef50c1e02ab09b442ee34f', 1),
('dc5c7986daef50c1e02ab09b442ee34f', 2),
('dc5c7986daef50c1e02ab09b442ee34f', 3),
('dc5c7986daef50c1e02ab09b442ee34f', 4),
('dc5c7986daef50c1e02ab09b442ee34f', 5),
('93dd4de5cddba2c733c65f233097f05a', 6),
('93dd4de5cddba2c733c65f233097f05a', 7),
('93dd4de5cddba2c733c65f233097f05a', 8),
('93dd4de5cddba2c733c65f233097f05a', 9),
('93dd4de5cddba2c733c65f233097f05a', 10),
('93dd4de5cddba2c733c65f233097f05a', 11),
('93dd4de5cddba2c733c65f233097f05a', 12),
('e45ee7ce7e88149af8dd32b27f9512ce', 13),
('e45ee7ce7e88149af8dd32b27f9512ce', 14),
('e45ee7ce7e88149af8dd32b27f9512ce', 15),
('e45ee7ce7e88149af8dd32b27f9512ce', 16),
('e45ee7ce7e88149af8dd32b27f9512ce', 17),
('e45ee7ce7e88149af8dd32b27f9512ce', 18),
('e45ee7ce7e88149af8dd32b27f9512ce', 19),
('7d0665438e81d8eceb98c1e31fca80c1', 20),
('7d0665438e81d8eceb98c1e31fca80c1', 21),
('7d0665438e81d8eceb98c1e31fca80c1', 22),
('7d0665438e81d8eceb98c1e31fca80c1', 23),
('7d0665438e81d8eceb98c1e31fca80c1', 24),
('7d0665438e81d8eceb98c1e31fca80c1', 25),
('7d0665438e81d8eceb98c1e31fca80c1', 26),
('7d0665438e81d8eceb98c1e31fca80c1', 27),
('7d0665438e81d8eceb98c1e31fca80c1', 28),
('7d0665438e81d8eceb98c1e31fca80c1', 29),
('7d0665438e81d8eceb98c1e31fca80c1', 30),
('7d0665438e81d8eceb98c1e31fca80c1', 31),
('751d31dd6b56b26b29dac2c0e1839e34', 32);

/*evaluadores*/
insert into evaluador ( id_evaluador, nombre, especialidad)
values ('cd3dc8b6cffb41e4163dcbd857ca87da', 'Alfredo Perez', 'TIC'),
('68a9e49bbc88c02083a062a78ab3bf30', 'Mario Rivera', 'TIC');

insert into evaluacion_evaluadores(id_evaluacion, id_evaluador) values('25bbdcd06c32d477f7fa1c3e4a91b032', 'cd3dc8b6cffb41e4163dcbd857ca87da');
insert into evaluacion_evaluadores(id_evaluacion, id_evaluador) values('25bbdcd06c32d477f7fa1c3e4a91b032', '68a9e49bbc88c02083a062a78ab3bf30');

insert into usuario (nombre_usuario, clave, fecha_creacion, activo) values('mracapri','12345',now(), 1), ('alfredop','12345',now(), 1);
insert into usuario_evaluador (nombre_usuario, id_evaluador) values('mracapri','68a9e49bbc88c02083a062a78ab3bf30'),('alfredop','cd3dc8b6cffb41e4163dcbd857ca87da');
insert into usuario_roles (nombre_usuario, id_role) values ('mracapri',1);
insert into usuario_roles (nombre_usuario, id_role) values ('alfredop',1);

/*Usuarios*/
insert into usuario ( nombre_usuario, clave, fecha_creacion, activo)
values ('mayri_022', '1452546', '2013-06-15', 1);

/*Usuario evaluador*/
insert into usuario_evaluador ( nombre_usuario, id_evaluador)
values ('mayri_022', '68a9e49bbc88c02083a062a78ab3bf30');

/*Resultados*/
insert into resultado ( id_evaluacion, id_proyecto, id_evaluador, id_rubrica, id_item_rubrica, calificacion)
values ('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3', '68a9e49bbc88c02083a062a78ab3bf30','dc5c7986daef50c1e02ab09b442ee34f', 1, 9.0),
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3', '68a9e49bbc88c02083a062a78ab3bf30','dc5c7986daef50c1e02ab09b442ee34f', 2, 8.0),
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3', '68a9e49bbc88c02083a062a78ab3bf30','dc5c7986daef50c1e02ab09b442ee34f', 3, 8.0),
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3', '68a9e49bbc88c02083a062a78ab3bf30','dc5c7986daef50c1e02ab09b442ee34f', 4, 9.0),
('25bbdcd06c32d477f7fa1c3e4a91b032', '96a3be3cf272e017046d1b2674a52bd3', '68a9e49bbc88c02083a062a78ab3bf30','dc5c7986daef50c1e02ab09b442ee34f', 5, 9.0);
