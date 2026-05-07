
create database tiendalinea

use tiendalinea

create table productos(
	id_producto int primary key identity(1,1),
	nombre varchar(50) not null,
	descripcion varchar(255) not null,
	precio decimal(10,2) not null,
	stock int not null
)


select * from productos

insert into productos(nombre, descripcion, precio, stock) values
('Laptop', 'Laptop de alta gama con procesador Intel i7, 16GB de RAM y 512GB de almacenamiento SSD.', 1200.00, 10),
('Smartphone', 'Smartphone con pantalla AMOLED de 6.5 pulgadas, cámara de 48MP y batería de larga duración.', 800.00, 20),
('Auriculares', 'Auriculares inalámbricos con cancelación de ruido y sonido de alta calidad.', 150.00, 30),
('Monitor', 'Monitor de 27 pulgadas con resolución 4K y tecnología HDR para una experiencia visual impresionante.', 400.00, 15),
('Teclado', 'Teclado mecánico retroiluminado con teclas programables y diseño ergonómico.', 100.00, 25)


[dbo].[productos]