-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 23-04-2021 a las 21:47:12
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `film_magic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Numero_Tarjeta` varchar(100) NOT NULL,
  `Nombre_Cliente` varchar(100) NOT NULL,
  `Dpi_Cliente` varchar(100) NOT NULL,
  `Telefono_Cliente` varchar(100) NOT NULL,
  `Dirreccion_Cliente` varchar(100) NOT NULL,
  `Correo_Cliente` varchar(100) NOT NULL,
  `Mora_Acumulada` varchar(100) NOT NULL,
  `Renta_Acumulada` varchar(100) NOT NULL,
  `Bonos_Acumulados` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Numero_Tarjeta`, `Nombre_Cliente`, `Dpi_Cliente`, `Telefono_Cliente`, `Dirreccion_Cliente`, `Correo_Cliente`, `Mora_Acumulada`, `Renta_Acumulada`, `Bonos_Acumulados`) VALUES
('1', 'Diego Vásquez', '5650', '56564142', 'Zona 17', 'dievas2001@gmail.com', '0', '0', '0'),
('2', 'Carlos Castillo', '35370101', '52415842', 'Zona 18', 'carlangasUmg@gmail.com', '0', '0', '0'),
('3', 'Eduardo Aguilar', '39780101', '56457878', 'Zona 10', 'guayoAguilar@gmail.com', '0', '0', '0'),
('4', 'Juan José Molina de León', '50601010', '85869674', 'Zona 7 de Mixco', 'jjmolina1988@gmail.com', '0', '0', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion`
--

CREATE TABLE `devolucion` (
  `Codigo_Devolucion` varchar(100) NOT NULL,
  `Codigo_Renta` varchar(100) DEFAULT NULL,
  `Fecha_Devolucion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `Codigo_Empleado` varchar(100) NOT NULL,
  `Codigo_Tienda` varchar(100) DEFAULT NULL,
  `Nombre_Empleado` varchar(100) DEFAULT NULL,
  `Estado_Empleado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generopelicula`
--

CREATE TABLE `generopelicula` (
  `Codigo_GeneroPelicula` varchar(100) NOT NULL,
  `Genero_Pelicula` varchar(100) DEFAULT NULL,
  `Tipo_Pelicula` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `Codigo_Pelicula` varchar(100) NOT NULL,
  `Nombre_Pelicula` varchar(100) DEFAULT NULL,
  `Autor_Pelicula` varchar(100) DEFAULT NULL,
  `Genero_Pelicula` varchar(100) DEFAULT NULL,
  `Clasificacion_Pelicula` varchar(100) DEFAULT NULL,
  `Duracion_Pelicula` varchar(100) DEFAULT NULL,
  `Precio_Pelicula` varchar(100) DEFAULT NULL,
  `Existencias` varchar(100) DEFAULT NULL,
  `Tienda` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renta`
--

CREATE TABLE `renta` (
  `Codigo_Renta` varchar(100) NOT NULL,
  `Codigo_Tienda` varchar(100) DEFAULT NULL,
  `Codigo_Tarjeta` varchar(100) DEFAULT NULL,
  `Codigo_Pelicula` varchar(100) DEFAULT NULL,
  `Cantidad_Peliculas` varchar(100) DEFAULT NULL,
  `Total_Renta` varchar(100) DEFAULT NULL,
  `Mora` varchar(100) DEFAULT NULL,
  `Fecha_Inicio` varchar(100) DEFAULT NULL,
  `Fecha_Vencimiento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `Codigo_Tienda` varchar(100) NOT NULL,
  `Nombre_Tienda` varchar(100) NOT NULL,
  `Ubicacion_Tienda` varchar(100) NOT NULL,
  `Estado_Tienda` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`Codigo_Tienda`, `Nombre_Tienda`, `Ubicacion_Tienda`, `Estado_Tienda`) VALUES
('1', 'Tienda Central', '16 Av. 13-40 Zona 7', 'A'),
('2', 'Tienda Sur', '11 Av. 8-70 Zona 4', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopelicula`
--

CREATE TABLE `tipopelicula` (
  `Codigo_TipoPelicula` varchar(100) NOT NULL,
  `Tipo_Pelicula` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `username`, `password`) VALUES
(1, 'diego', 'diego123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Numero_Tarjeta`);

--
-- Indices de la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD PRIMARY KEY (`Codigo_Devolucion`),
  ADD KEY `FK_DevolucionRenta` (`Codigo_Renta`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`Codigo_Empleado`),
  ADD KEY `FK_EmpleadoTienda` (`Codigo_Tienda`);

--
-- Indices de la tabla `generopelicula`
--
ALTER TABLE `generopelicula`
  ADD PRIMARY KEY (`Codigo_GeneroPelicula`),
  ADD KEY `FK_TipoPelicula` (`Tipo_Pelicula`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`Codigo_Pelicula`),
  ADD KEY `FK_GeneroPelicula` (`Genero_Pelicula`),
  ADD KEY `FK_Tienda` (`Tienda`);

--
-- Indices de la tabla `renta`
--
ALTER TABLE `renta`
  ADD PRIMARY KEY (`Codigo_Renta`),
  ADD KEY `FK_RentaCliente` (`Codigo_Tarjeta`),
  ADD KEY `FK_RentaPelicula` (`Codigo_Pelicula`),
  ADD KEY `FK_RentaTienda` (`Codigo_Tienda`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`Codigo_Tienda`);

--
-- Indices de la tabla `tipopelicula`
--
ALTER TABLE `tipopelicula`
  ADD PRIMARY KEY (`Codigo_TipoPelicula`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD CONSTRAINT `FK_DevolucionRenta` FOREIGN KEY (`Codigo_Renta`) REFERENCES `renta` (`Codigo_Renta`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_EmpleadoTienda` FOREIGN KEY (`Codigo_Tienda`) REFERENCES `tienda` (`Codigo_Tienda`);

--
-- Filtros para la tabla `generopelicula`
--
ALTER TABLE `generopelicula`
  ADD CONSTRAINT `FK_TipoPelicula` FOREIGN KEY (`Tipo_Pelicula`) REFERENCES `tipopelicula` (`Codigo_TipoPelicula`);

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `FK_GeneroPelicula` FOREIGN KEY (`Genero_Pelicula`) REFERENCES `generopelicula` (`Codigo_GeneroPelicula`),
  ADD CONSTRAINT `FK_Tienda` FOREIGN KEY (`Tienda`) REFERENCES `tienda` (`Codigo_Tienda`);

--
-- Filtros para la tabla `renta`
--
ALTER TABLE `renta`
  ADD CONSTRAINT `FK_RentaCliente` FOREIGN KEY (`Codigo_Tarjeta`) REFERENCES `cliente` (`Numero_Tarjeta`),
  ADD CONSTRAINT `FK_RentaPelicula` FOREIGN KEY (`Codigo_Pelicula`) REFERENCES `pelicula` (`Codigo_Pelicula`),
  ADD CONSTRAINT `FK_RentaTienda` FOREIGN KEY (`Codigo_Tienda`) REFERENCES `tienda` (`Codigo_Tienda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
