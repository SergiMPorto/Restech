CREATE TABLE Usuarios (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(255),
    Permisos INT(11), 
    Codigo VARCHAR(255)
);

CREATE TABLE Proveedores (
    ID_Proveedor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(255),
    Descripcion TEXT,
    Numero_Contacto VARCHAR(20),
    Direccion VARCHAR(255)
);

CREATE TABLE Materias_Primas (
    ID_Materia_Prima INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(255),
    Precio DECIMAL(10, 2),
    Proveedor VARCHAR(255),
    Fecha_Caducidad DATE,
    Cantidad_Utilizada DECIMAL(10, 2),
    Merma DECIMAL(10, 2)
);

CREATE TABLE Pedido (
    ID_Pedido INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT,
    ID_Proveedor INT,
    materia_prima VARCHAR(255),
    Cantidad DECIMAL(10,2),
    Fecha_Pedido DATE,
    Precio DECIMAL(10, 2),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Proveedor) REFERENCES Proveedores(ID_Proveedor)
);

CREATE TABLE Platos (
    ID_Plato INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(255),
    Precio DECIMAL(10, 2),
    Tiempo_Preparacion INT
);

CREATE TABLE Platos_MateriasPrimas (
    ID_Plato INT,
    ID_Materia_Prima INT,
    Cantidad DECIMAL(10, 2),
    PRIMARY KEY (ID_Plato, ID_Materia_Prima),
    FOREIGN KEY (ID_Plato) REFERENCES Platos(ID_Plato),
    FOREIGN KEY (ID_Materia_Prima) REFERENCES Materias_Primas(ID_Materia_Prima)
);

INSERT INTO Usuarios (Nombre, Permisos, Codigo) 
VALUES 
('Juan Perez', 1, 'ABC123'),
('Maria Garcia', 2, 'DEF456'),
('Pedro Sanchez', 3, 'GHI789'),
('Ana Lopez', 1, 'JKL012'),
('Carlos Ramirez', 2, 'MNO345');

INSERT INTO Proveedores (Nombre, Descripcion, Numero_Contacto, Direccion) 
VALUES 
('Proveedor A', 'Proveedor de frutas y verduras frescas', '123-456-7890', 'Calle Principal 123'),
('Proveedor B', 'Distribuidor de carne de alta calidad', '456-789-0123', 'Avenida Central 456'),
('Proveedor C', 'Proveedor de lácteos y derivados', '789-012-3456', 'Carrera Secundaria 789'),
('Proveedor D', 'Importador de especias y condimentos', '012-345-6789', 'Plaza Mayor 012'),
('Proveedor E', 'Distribuidor de productos de panadería', '234-567-8901', 'Callejon Oscuro 234');

INSERT INTO Materias_Primas (Nombre, Precio, Proveedor, Fecha_Caducidad, Cantidad_Utilizada, Merma) 
VALUES 
('Manzanas', 2.50, 'Proveedor A', '2024-06-30', 100, 5),
('Carne de res', 12.75, 'Proveedor B', '2024-06-15', 50, 2),
('Leche', 1.80, 'Proveedor C', '2024-07-10', 200, 10),
('Canela', 3.00, 'Proveedor D', '2024-08-20', 20, 1),
('Harina', 2.00, 'Proveedor E', '2024-07-25', 150, 8);

INSERT INTO Pedido (ID_Usuario, ID_Proveedor, Nombre, Cantidad, Fecha_Pedido, Precio) 
VALUES 
(1, 1, 'Pedido de Manzanas', 200, '2024-05-30', 500.00),
(2, 2, 'Pedido de Carne de res', 100, '2024-05-31', 1275.00),
(3, 3, 'Pedido de Leche', 300, '2024-06-01', 540.00),
(4, 4, 'Pedido de Canela', 50, '2024-06-02', 150.00),
(5, 5, 'Pedido de Harina', 200, '2024-06-03', 400.00);

INSERT INTO Platos (Nombre, Precio, Tiempo_Preparacion) 
VALUES 
('Ensalada de frutas', 8.50, 15),
('Filete de res a la parrilla', 20.00, 30),
('Cereal con leche', 4.00, 5),
('Arroz con leche', 6.00, 20),
('Panqueques', 7.50, 25);

INSERT INTO Platos_MateriasPrimas (ID_Plato, ID_Materia_Prima, Cantidad) 
VALUES 
(1, 1, 50),
(1, 3, 100),
(2, 2, 20),
(3, 3, 200),
(4, 5, 150);
