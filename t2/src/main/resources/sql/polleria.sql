#drop database polleria2;
CREATE DATABASE IF NOT EXISTS Polleria2;
USE Polleria2;

CREATE TABLE IF NOT EXISTS Cliente ( # extranet
    IDCliente INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(50) NULL,
    Direccion VARCHAR(50) NULL,
    Telefono VARCHAR(13) NULL,
    Correo VARCHAR(40) UNIQUE NOT NULL,
    Clave VARCHAR(15) NOT NULL,
    Distrito VARCHAR(50) NULL,
    PRIMARY KEY (IDCliente)
) ;

INSERT INTO CLIENTE (nombre,direccion, correo, clave, distrito) VALUES
('MILHOS KASSIAN SIHUAY BARZOLA', 'Joaquin Capello 2486','n00177104@upn.pe', '0000', 'Lima'),
('CHRISTIAN GABRIEL IZQUIERDO ALLEMANT', 'Unidad Vecinal De Mirones Chalet 8','n00224502@upn.pe', '0000', 'Lima'),
('EMERSON GERARDO CAHUANA PEREZ PALMA', 'Direccion3','n00057393@upn.pe', '0000', 'Lima'),
('JHON FRANCISCO JOVE OBANDO', 'Direccion4','n00233133@upn.pe', '0000', 'Lima');

CREATE TABLE IF NOT EXISTS Trabajador ( # intranet
    IDTrabajador INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(50) NULL,
    Telefono VARCHAR(13) unique NULL,
    Usuario VARCHAR(20) unique NULL,
    Clave VARCHAR(15) default '0000',
    correo varchar(45) unique,
    PRIMARY KEY (IDTrabajador)
);


INSERT INTO TRABAJADOR (nombre, correo) VALUES
('MILHOS SIHUAY BARZOLA','mi_adm@g.com'),
('CHRISTIAN  IZQUIERDO ALLEMANT', 'chr_adm@g.com'),
('EMERSON CAHUANA PEREZ PALMA','ge_adm@g.com'),
('JHON FRANCISCO JOVE OBANDO','jh_adm@g.com');



create table if not exists usuarios(
id int auto_increment primary key,
username varchar(45) unique not null,
password varchar(60) not null default '$2a$12$imQ8rBkD2jdUIXw50vP2je3LgsQZG98aaOrbIFD5UW6YDUIQVgIui', # 0000
enabled tinyint default 1,
email_cli varchar(40) unique,
email_emp varchar(40) unique,
foreign key (email_cli) references cliente (correo),
foreign key (email_emp) references trabajador (correo)
);

insert into usuarios (username, email_emp) values 
('adm_milhos','mi_adm@g.com'),
('adm_gerardo','ge_adm@g.com'),
('adm_christhian','chr_adm@g.com'),
('adm_jhon','jh_adm@g.com');
insert into usuarios(username,email_cli) values
('milhos','n00177104@upn.pe'),
('gerardo','n00057393@upn.pe'), 
('christian','n00224502@upn.pe'), 
('jhon','n00233133@upn.pe');  


create table if not exists roles(
id int auto_increment primary key,
user_id int,
authority varchar(45) not null,
foreign key (user_id) references usuarios (id)
);

insert into roles(user_id, authority) values
(1, 'ROL_ADMIN'),
(2, 'ROL_ADMIN'),
(3, 'ROL_ADMIN'),
(4, 'ROL_ADMIN'),

(5, 'ROL_USUARIO'),
(6, 'ROL_USUARIO'),
(7, 'ROL_USUARIO'),
(8, 'ROL_USUARIO');

#------------------------------------- TABLAS DEL SISTEMA --------



CREATE TABLE IF NOT EXISTS Bebida (
    IDBebida INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Tipo VARCHAR(10) NULL,
    Tamano VARCHAR(10) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDBebida)
) ;

INSERT INTO BEBIDA VALUES
(null,'INKA-COLA','GASEOSA','1.5LT',6,20),
(null,'PEPSI','GASEOSA','1.5LT',5,20);



CREATE TABLE IF NOT EXISTS Menu (
    IDMenu INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Tipo VARCHAR(30) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDMenu)
);

insert into menu (nombre, tipo,precio,stock) values
('Lomo Saltado','PLATO A LA CARTA', 20, 10) ,
('Chaufa de pollo','CHIFA', 16, 11) ,
('Aeropuerto de pollo','CHIFA', 20, 12) ,
('Arroz a la cubana', 'PLATO A LA CARTA',12, 13) ,
('Salchipapa', 'COMIDA RAPIDA',15, 14) ,
('Chicharron de pollo','COMIDA RAPIDA', 19, 15) ,
('Tortilla de Verduras', 'DESAYUNO', 12, 16) ,
('Aji de Gallina','MENU', 19, 20) ;


CREATE TABLE IF NOT EXISTS Piqueo (
    IDPiqueo INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(80) NULL,
    Tipo VARCHAR(10) NULL,
    Precio DECIMAL(5, 2) NULL,
    Porcion VARCHAR(10) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDPiqueo)
) ;

insert into piqueo values
(null, 'PORCION DE PAPAS + ENSALADA CLASICA', 'COMBO', 10,'FAMILIAR',10);

CREATE TABLE IF NOT EXISTS Pollo (
    IDPollo INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    Cantidad INT NULL,
    PRIMARY KEY (IDPollo)
);

insert into Pollo (nombre,precio,stock,cantidad) values
('6/4 POLLO',80.5,10, '5'), #i:1
('5/4 POLLO',70,10, '5'), #i:2
('1/4 POLLO',18.5,10, '5'),#i:3
('1/2 POLLO',28.5,11, '5'),#i:4
('1 POLLO',58,12, '5');#i:5


CREATE TABLE IF NOT EXISTS Combo (
    IDCombo INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    IDBebida INT NULL,
    IDMenu INT NULL,
    IDPollo INT NULL,
    IDPiqueo INT NULL,
    PRIMARY KEY (IDCombo),
    FOREIGN KEY (IDBebida) REFERENCES Bebida (IDBebida) on delete cascade,
    FOREIGN KEY (IDMenu) REFERENCES Menu (IDMenu) on delete cascade,
    FOREIGN KEY (IDPiqueo) REFERENCES Piqueo (IDPiqueo) on delete cascade,
    FOREIGN KEY (IDPollo) REFERENCES Pollo (IDPollo) on delete cascade
) ;

# pepsi -> i:2 ; inka -> i:1
insert into combo (nombre,idmenu,idpollo,idbebida,idpiqueo,precio,stock) values
('COMBO ESPECIAL',2,5,1,1,55,10);
insert into combo (nombre,idpollo,idbebida,idpiqueo,precio,stock) values
('COMBO 2',5,2,1,65,11),
('COMBO 3',2,2,1,75,12),
('COMBO 4',1,1,1,85,13);



CREATE TABLE IF NOT EXISTS CARRITO(
	IDCARRO INT AUTO_INCREMENT NOT NULL primary key,
    ID_CLI INT NOT NULL,
    nom_prod varchar(50) null,
    cantidad_prod int null,
    precio_prod decimal(8,2) null,
    subtotal DECIMAL(8, 2) NULL,
	
    foreign key (ID_cli) references Cliente (idCliente) on delete cascade
);

insert into carrito values
(null, 1,'combo 1', 2, 10, 20);
select * from carrito;






CREATE TABLE IF NOT EXISTS Compra (
    IDCompra INT AUTO_INCREMENT NOT NULL,
    Cantidad INT NULL,
    FechaCompra DATETIME NULL,
    TotalPago DECIMAL(6, 2) NULL,
    IDBebida INT NULL,
    IDMenu INT NULL,
    IDCombo INT NULL,
    IDPollo INT NULL,
    IDCliente INT NULL,
    IDPiqueo INT NULL,
    PRIMARY KEY (IDCompra),
    FOREIGN KEY (IDBebida) REFERENCES Bebida (IDBebida),
    FOREIGN KEY (IDMenu) REFERENCES Menu (IDMenu),
    FOREIGN KEY (IDCombo) REFERENCES Combo (IDCombo),
    FOREIGN KEY (IDPollo) REFERENCES Pollo (IDPollo),
    FOREIGN KEY (IDCliente) REFERENCES Cliente (IDCliente),
    FOREIGN KEY (IDPiqueo) REFERENCES Piqueo (IDPiqueo)
);

