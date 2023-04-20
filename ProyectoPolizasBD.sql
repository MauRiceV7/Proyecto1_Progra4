Create DATABASE if not exists Polizas;
use Polizas;

Create table marca(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(30),
    Primary Key (id)
);

Create table modelo(
    id int NOT NULL AUTO_INCREMENT,
    marca int,
    nombre varchar(30),
    Primary Key (id),
    foreign key (marca) references marca(id)
); 

Create table usuario(
    cedula varchar(10) NOT NULL,
    nombre varchar(30),
    clave varchar(30),
    telefono varchar(10),
    correo varchar(50),
    tarjeta varchar(30),
    tipo integer,
    Primary Key(cedula)
);

Create table categoria(
    id int NOT NULL AUTO_INCREMENT,
    descripcion varchar(40),
    Primary Key(id)
);

Create table poliza(
    numPlaca varchar(20),
    cedulaUsuario varchar(10) not NULL,
    modelo int,
    ano varchar(20),
    valor float,
    fecha varchar(20),
    Primary Key (numPlaca),
    Foreign Key (cedulaUsuario) references usuario(cedula),
    Foreign Key (modelo) references modelo(id)
);

Create table cobertura(
    id int NOT NULL AUTO_INCREMENT,
    descripcion varchar(40),
    costoMin int,
    costoPor int,
    categoria int,
    Primary Key(id),
    foreign Key (categoria) references categoria(id)
);

Create table polizaCobertura(
    idPoliza varchar(20),
    idCobertura int,
    Primary Key(idPoliza, idCobertura),
    foreign key(idPoliza) references poliza(numPlaca),
    foreign key(idCobertura) references cobertura(id)
);

insert into usuario(cedula, nombre, clave, telefono, correo, tarjeta, tipo)
    values("111", "Juan", "dos", "24245678", "juanPerez@gmail.com", "2222222", 2);

insert into usuario(cedula, nombre, clave, telefono, correo, tarjeta, tipo)
    values("222", "Jairo", "dos", "61187234", "jairoisaac20@gmail.com", "1111111", 1);

insert into marca(nombre) values ("Toyota");

insert into modelo(marca, nombre) values (1, "Raize");

insert into categoria(descripcion) values ("Responsabilidad Civil");

insert into cobertura(descripcion, costoMin, costoPor, categoria) 
    values("Dannios a la Propiedad de Terceros", 300, 10, 1);

insert into poliza(numPlaca, cedulaUsuario, modelo, ano, valor, fecha) 
    values("1234", "222", 1, "2023", 60000, "15-3-2023");

insert into polizaCobertura(idPoliza, idCobertura) values ("1234", 1);