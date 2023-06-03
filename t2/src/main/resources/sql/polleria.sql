CREATE DATABASE IF NOT EXISTS Polleria;
#drop database Polleria;
USE Polleria;

CREATE TABLE IF NOT EXISTS Cliente (
    IDCliente INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(50) NULL,
    Direccion VARCHAR(50) NULL,
    Telefono VARCHAR(13) NULL,
    Correo VARCHAR(20) NOT NULL,
    Clave VARCHAR(15) NOT NULL,
    Distrito VARCHAR(50) NULL,
    PRIMARY KEY (IDCliente)
) ;
INSERT INTO CLIENTE (nombre,direccion, correo, clave, distrito) VALUES
('MILHOS KASSIAN SIHUAY BARZOLA', 'Joaquin Capello 2486','mi@g.com', '123456', 'Lima'),
('CHRISTIAN GABRIEL IZQUIERDO ALLEMANT', 'Direccion2','chr@g.com', '123456', 'Lima'),
('EMERSON GERARDO CAHUANA PEREZ PALMA', 'Direccion3','ge@g.com', '123456', 'Lima');

select * from Cliente;

CREATE TABLE IF NOT EXISTS Bebida (
    IDBebida INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Tipo VARCHAR(10) NULL,
    Tamano VARCHAR(10) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDBebida)
) ;

CREATE TABLE IF NOT EXISTS Menu (
    IDMenu INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Tipo VARCHAR(10) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDMenu)
);

CREATE TABLE IF NOT EXISTS Piqueo (
    IDPiqueo INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Tipo VARCHAR(10) NULL,
    Precio DECIMAL(5, 2) NULL,
    Porcion VARCHAR(10) NULL,
    Stock INT NULL,
    PRIMARY KEY (IDPiqueo)
) ;

CREATE TABLE IF NOT EXISTS Pollo (
    IDPollo INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(20) NULL,
    Precio DECIMAL(5, 2) NULL,
    Stock INT NULL,
    Cantidad INT NULL,
    PRIMARY KEY (IDPollo)
);


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
    FOREIGN KEY (IDBebida) REFERENCES Bebida (IDBebida),
    FOREIGN KEY (IDMenu) REFERENCES Menu (IDMenu),
    FOREIGN KEY (IDPiqueo) REFERENCES Piqueo (IDPiqueo),
    FOREIGN KEY (IDPollo) REFERENCES Pollo (IDPollo)
) ;

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


CREATE TABLE IF NOT EXISTS Trabajador (
    IDTrabajador INT AUTO_INCREMENT NOT NULL,
    Nombre VARCHAR(50) NULL,
    Direccion VARCHAR(50) NULL,
    Telefono VARCHAR(13) NULL,
    Usuario VARCHAR(20) NOT NULL,
    Clave VARCHAR(15) NOT NULL,
    PRIMARY KEY (IDTrabajador)
);

INSERT INTO TRABAJADOR (nombre, usuario, clave) VALUES
('MILHOS SIHUAY BARZOLA','mi_adm@g.com', '12345678'),
('CHRISTIAN  IZQUIERDO ALLEMANT', 'chr_adm@g.com', '12345678'),
('EMERSON CAHUANA PEREZ PALMA','ge_adm@g.com', '12345678');

select * from trabajador;


