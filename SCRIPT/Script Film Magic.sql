CREATE DATABASE film_magic;
USE film_magic;

CREATE TABLE IF NOT EXISTS Cliente(
  Numero_Tarjeta VARCHAR(100),
  Nombre_Cliente VARCHAR(100) NOT NULL,
  Dpi_Cliente VARCHAR(100) NOT NULL,
  Telefono_Cliente VARCHAR(100) NOT NULL,
  Dirreccion_Cliente VARCHAR(100) NOT NULL,
  Correo_Cliente VARCHAR(100) NOT NULL,
   Mora_Acumulada VARCHAR(100) NOT NULL,
  Renta_Acumulada VARCHAR(100) NOT NULL,
  Bonos_Acumulados VARCHAR(100) NOT NULL,
  PRIMARY KEY (Numero_Tarjeta))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;

 CREATE TABLE IF NOT EXISTS Tienda(
  Codigo_Tienda VARCHAR(100),
  Nombre_Tienda VARCHAR(100) NOT NULL,
  Ubicacion_Tienda VARCHAR(100) NOT NULL,
  Estado_Tienda VARCHAR(100) NOT NULL,
  PRIMARY KEY (Codigo_Tienda))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  CREATE TABLE IF NOT EXISTS TipoPelicula(
  Codigo_TipoPelicula VARCHAR(100),
  Tipo_Pelicula VARCHAR(100) NOT NULL,
  PRIMARY KEY (Codigo_TipoPelicula))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  CREATE TABLE IF NOT EXISTS GeneroPelicula(
  Codigo_GeneroPelicula VARCHAR(100),
  Genero_Pelicula VARCHAR(100),
  Tipo_Pelicula VARCHAR(100),
  PRIMARY KEY (Codigo_GeneroPelicula),
CONSTRAINT FK_TipoPelicula
FOREIGN KEY (Tipo_Pelicula)
REFERENCES TipoPelicula(Codigo_TipoPelicula))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
    CREATE TABLE IF NOT EXISTS Pelicula (
  Codigo_Pelicula VARCHAR(100),
  Nombre_Pelicula VARCHAR(100),
  Autor_Pelicula VARCHAR(100),
  Genero_Pelicula VARCHAR(100),
Clasificacion_Pelicula VARCHAR(100),
  Duracion_Pelicula VARCHAR(100),
  Precio_Pelicula VARCHAR(100),
  Existencias VARCHAR(100),
  Tienda VARCHAR(100),
  PRIMARY KEY (Codigo_Pelicula),
CONSTRAINT FK_GeneroPelicula
FOREIGN KEY (Genero_Pelicula)
REFERENCES GeneroPelicula (Codigo_GeneroPelicula),
CONSTRAINT FK_Tienda
FOREIGN KEY (Tienda)
REFERENCES Tienda(Codigo_Tienda))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  CREATE TABLE IF NOT EXISTS Empleado(
  Codigo_Empleado VARCHAR(100),
  Codigo_Tienda VARCHAR(100),
  Nombre_Empleado VARCHAR(100),
  Estado_Empleado VARCHAR(100),
  PRIMARY KEY (Codigo_Empleado),
CONSTRAINT FK_EmpleadoTienda
FOREIGN KEY (Codigo_Tienda)
REFERENCES Tienda (Codigo_Tienda))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  CREATE TABLE IF NOT EXISTS Renta (
  Codigo_Renta VARCHAR(100),
  Codigo_Tienda VARCHAR(100),
  Codigo_Tarjeta VARCHAR(100),
  Codigo_Pelicula VARCHAR(100),
Cantidad_Peliculas VARCHAR(100),
  Total_Renta VARCHAR(100),
  Mora VARCHAR(100),
  Fecha_Inicio VARCHAR(100),
Fecha_Vencimiento VARCHAR(100),
  PRIMARY KEY (Codigo_Renta),
CONSTRAINT FK_RentaCliente
FOREIGN KEY (Codigo_Tarjeta)
REFERENCES Cliente(Numero_Tarjeta),
CONSTRAINT FK_RentaPelicula
FOREIGN KEY (Codigo_Pelicula)
REFERENCES Pelicula (Codigo_Pelicula),
CONSTRAINT FK_RentaTienda
FOREIGN KEY (Codigo_Tienda)
REFERENCES Tienda (Codigo_Tienda))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  
  CREATE TABLE IF NOT EXISTS Devolucion (
  Codigo_Devolucion VARCHAR(100),
  Codigo_Renta VARCHAR(100),
  Fecha_Devolucion VARCHAR(100),
  PRIMARY KEY (Codigo_Devolucion),
CONSTRAINT FK_DevolucionRenta
FOREIGN KEY (Codigo_Renta)
REFERENCES Renta (Codigo_Renta))
  ENGINE = InnoDB 
  CHARACTER SET = utf8;
  