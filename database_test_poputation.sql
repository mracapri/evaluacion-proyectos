SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET NAMES 'latin1';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*Categorias*/
insert into categoria ( id_categoria, descripcion ) 
values (1, 'Software Multimedia'),(2, 'Software Escritorio'),(3, 'Software Móviles'),(4, 'Software Web');


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

/*Items Rubricas*/
insert into item_rubrica ( id_item_rubrica, descripcion_corta, descripcion_larga, id_escala ) 
values (1, 'No hay faltas de ortografï¿½a ni errores gramaticales presentadas en el contenido', 'No hay faltas de ortografï¿½a ni errores gramaticales presentadas en el contenido', 1),
(2, 'La organizaciï¿½n del material es adecuada para el usuario o grupo al que va dirigido', 'La organizaciï¿½n del material es adecuada para el usuario o grupo al que va dirigido', 1),
(3, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(4, 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 1),
(5, 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 1),

(6, 'No hay faltas de ortografï¿½a ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortografï¿½a ni errores gramaticales en las pantallas del proyecto', 1),
(7, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(8, 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 1),
(9, 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 1),
(10, 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'El software es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(11, 'El software realiza conectividad a base de datos y/o a recursos externos', 'El software realiza conectividad a base de datos y/o a recursos externos', 1),
(12, 'El software maneja roles operativos en la aplicaciï¿½n para administraciï¿½n y o control del mismo', 'El software maneja roles operativos en la aplicaciï¿½n para administraciï¿½n y o control del mismo', 1),

(13, 'No hay faltas de ortografï¿½a ni errores gramaticales en las pantallas del proyecto', 'No hay faltas de ortografï¿½a ni errores gramaticales en las pantallas del proyecto', 1),
(14, 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)', 1),
(15, 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales', 1),
(16, 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente', 1),
(17, 'La aplicaciï¿½n es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 'La aplicaciï¿½n es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc', 1),
(18, 'La aplicaciï¿½n realiza conectividad a base de datos internas y/o a servicios externos', 'La aplicaciï¿½n realiza conectividad a base de datos internas y/o a servicios externos', 1),
(19, 'La aplicaciï¿½n se dibuja correctamente en la pantalla', 'La aplicaciï¿½n se dibuja correctamente en la pantalla', 1),

(20,'No hay faltas de ortografï¿½a ni errores gramaticales','No hay faltas de ortografï¿½a ni errores gramaticales',1),
(21,'El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)','El producto final demuestra gran originalidad (las ideas son creativas e ingeniosas)',1),
(22,'Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales.','Manejo diestro del software de diseï¿½o, con mucha habilidad y uso de herramientas especiales.',1),
(23,'Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente','Cubre la informaciï¿½n necesaria para el tema del proyecto. La presentaciï¿½n y distribuciï¿½n de la informaciï¿½n es excelente',1),
(24,'El sitio web presenta la estructura de (encabezado, contenido, menu y pie de pï¿½gina)','El sitio web presenta la estructura de (encabezado, contenido, menu y pie de pï¿½gina)',1),
(25,'El sitio web presena adecuadamente la distribucion de controles','El sitio web presena adecuadamente la distribucion de controles',1),
(26,'El sitio web trata adecudamente el manejo de colores','El sitio web trata adecudamente el manejo de colores',1),
(27,'El sitio web define el objetivo para el cual fue desarrollado','El sitio web define el objetivo para el cual fue desarrollado',1),
(28,'El sitio web se integra con redes sociales','El sitio web se integra con redes sociales',1),
(29,'El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc','El sitio web es tolerante y notifica posibles fallos: errores de conexion, servicios no disponibles, etc',1),
(30,'El sitio web realiza conectividad a base de datos y/o a servicios externos','El sitio web realiza conectividad a base de datos y/o a servicios externos',1),
(31,'El sitio web se dibuja correctamente en la pantalla','El sitio web se dibuja correctamente en la pantalla',1),

(32,'Item Rubrica de exposicion', 'Item Rubrica de exposicion',1),
(33,'Item Rubrica de exposicion2', 'Item Rubrica de exposicion2',1),
(34,'Item Rubrica de exposicion3', 'Item Rubrica de exposicion3',1),
(35,'Item Rubrica de exposicion4', 'Item Rubrica de exposicion4',1),
(36,'Item Rubrica de exposicion5', 'Item Rubrica de exposicion5',1);

/*
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
*/
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
('e45ee7ce7e88149af8dd32b27f9512ce', 13),
('e45ee7ce7e88149af8dd32b27f9512ce', 14),
('e45ee7ce7e88149af8dd32b27f9512ce', 15),
('e45ee7ce7e88149af8dd32b27f9512ce', 16),
('e45ee7ce7e88149af8dd32b27f9512ce', 17),
('7d0665438e81d8eceb98c1e31fca80c1', 20),
('7d0665438e81d8eceb98c1e31fca80c1', 21),
('7d0665438e81d8eceb98c1e31fca80c1', 22),
('7d0665438e81d8eceb98c1e31fca80c1', 23),
('7d0665438e81d8eceb98c1e31fca80c1', 24),
('751d31dd6b56b26b29dac2c0e1839e34', 32),
('751d31dd6b56b26b29dac2c0e1839e34', 33),
('751d31dd6b56b26b29dac2c0e1839e34', 34),
('751d31dd6b56b26b29dac2c0e1839e34', 35),
('751d31dd6b56b26b29dac2c0e1839e34', 36);


insert into usuario (nombre_usuario, clave, fecha_creacion, activo) values('mracapri','Riam82120$',now(), 1);
insert into usuario_roles (nombre_usuario, id_role) values ('mracapri',2);

