-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-09-2018 a las 20:46:43
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `id` int(2) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`id`, `nombre`) VALUES
(1, 'TIC'),
(2, 'GDT'),
(3, 'MM'),
(4, 'DIE'),
(5, 'GA'),
(6, 'MI'),
(7, 'PA'),
(8, 'LI'),
(9, 'ER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `Folio` varchar(10) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(80) NOT NULL,
  `forma_de_adquisicion` varchar(30) NOT NULL,
  `editorial` varchar(30) NOT NULL,
  `isbn` varchar(40) NOT NULL,
  `fecha` date NOT NULL,
  `status` varchar(10) NOT NULL,
  `Id_carrera` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `Folio`, `titulo`, `autor`, `forma_de_adquisicion`, `editorial`, `isbn`, `fecha`, `status`, `Id_carrera`) VALUES
(1, 'CG23424246', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '102101220120', '2018-08-29', 'Estante', 1),
(2, 'CG12345678', 'HTML, JAVASCRIPT Y CSS', 'CEBALLOS', 'DONACIÓN', 'TRILLAS', '10020222', '2018-08-29', 'Estante', 1),
(3, 'CG12011201', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '1012210', '2018-08-29', 'Estante', 2),
(8, 'CG42442234', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-08-29', 'Estante', 1),
(9, 'CG12555335', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '5425454', '2018-08-29', 'Estante', 1),
(11, 'CG12245122', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '0', '2018-08-29', 'Estante', 2),
(12, 'CG01000001', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '0', '2018-08-29', 'Estante', 1),
(13, 'CG01000002', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '1010', '2018-08-29', 'Estante', 1),
(14, 'CG01000003', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '141010', '2018-08-29', 'Estante', 1),
(15, 'CG01000004', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '0', '2018-08-29', 'Estante', 1),
(16, 'CG01212012', 'AVIONES', 'JONAS T', 'PISI', 'TRILLAS', '0', '2018-08-30', 'Estante', 2),
(17, 'CG12555312', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '010101', '2018-08-30', 'Estante', 1),
(18, 'CG12245123', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '1010101', '2018-08-30', 'Estante', 2),
(19, 'CG12245124', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '10101010', '2018-08-30', 'Estante', 2),
(20, 'CG12245125', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '01010101', '2018-08-30', 'Estante', 2),
(22, 'CG12245127', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '0101010', '2018-08-30', 'Estante', 2),
(23, 'CG01100021', 'AUTOS ROBLEZ', 'ROBERTO FLORES Y RUBEN TOTEN', 'DONACIÓN', 'MACTRIOZ', '1000', '2018-08-30', 'Estante', 3),
(24, 'CG01100022', 'AUTOS ROBLEZ', 'ROBERTO FLORES Y RUBEN TOTEN', 'DONACIÓN', 'MACTRIOZ', '1000', '2018-08-30', 'Estante', 3),
(25, 'CG01100023', 'AUTOS ROBLEZ', 'ROBERTO FLORES Y RUBEN TOTEN', 'DONACIÓN', 'MACTRIOZ', '1000', '2018-08-30', 'Estante', 3),
(27, 'CG12011202', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'DONACIÓN', 'LA PAJITA', '102120', '2018-08-30', 'Estante', 2),
(28, 'CG23424243', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '220', '2018-08-30', 'Estante', 1),
(29, 'CG15154892', 'PROGRAMACIÓN', 'JOSE', 'DONACIÓN', 'CEBALLOS', '15588888', '2018-08-30', 'Estante', 1),
(30, 'CG12011208', 'HOTELES Y VIAJES', 'MARIA FERNANDA. MR', 'PISI', 'LA PAJITA', '4521586', '2018-08-30', 'Estante', 2),
(31, 'CG12555336', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '100', '2018-09-01', 'Estante', 1),
(33, 'CG01000005', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '141010', '2018-09-01', 'Estante', 1),
(34, 'CG01000006', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '141010', '2018-09-01', 'Estante', 1),
(35, 'CG01000007', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '141010', '2018-09-01', 'Estante', 1),
(36, 'CG01000008', 'JAVA 2. APRENDE JAVA', 'JAVIER CEBALLOS', 'DONACIÓN', 'RAYITAS', '141010', '2018-09-01', 'Estante', 1),
(37, 'CG42442235', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(38, 'CG42442236', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(39, 'CG42442237', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(40, 'CG42442238', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(42, 'CG42442239', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(43, 'CG42442240', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(44, 'CG42442241', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(45, 'CG42442242', 'HTML, CSS Y PHP', 'JORGE R.', 'PISI', 'TRILLAS', '100125555', '2018-09-01', 'Estante', 9),
(46, 'CG10112445', 'ESTANDAR DE RECETAS', 'ROSA INES & CARLOS SALVADOR', 'DONACIÓN', 'TRILLAS', '101212522', '2018-09-03', 'Estante', 5),
(47, 'CG10112446', 'ESTANDAR DE RECETAS', 'ROSA INES & CARLOS SALVADOR', 'DONACIÓN', 'TRILLAS', '101212522', '2018-09-03', 'Estante', 5),
(48, 'CG10112447', 'ESTANDAR DE RECETAS', 'ROSA INES & CARLOS SALVADOR', 'DONACIÓN', 'TRILLAS', '101212522', '2018-09-03', 'Estante', 5),
(49, 'CG10112448', 'ESTANDAR DE RECETAS', 'ROSA INES & CARLOS SALVADOR', 'DONACIÓN', 'TRILLAS', '101212522', '2018-09-03', 'Estante', 5),
(50, 'CG10012125', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(51, 'CG10012126', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(52, 'CG10012127', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(53, 'CG10012128', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(54, 'CG10012129', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(55, 'CG10012130', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(56, 'CG10012131', 'TUERCAS DE HIERRO', 'FRAKRIL R. SC', 'DONACIÓN', 'EL TORNILLITO', '105202', '2018-09-03', 'Estante', 3),
(57, 'CG12455215', 'COMO HACER POZOLE NATURAL', 'DOÑA JUANITA', 'DONACIÓN', 'TRILLAS', '0', '2018-09-03', 'Estante', 5),
(58, 'CG12455216', 'COMO HACER POZOLE NATURAL', 'DOÑA JUANITA', 'DONACIÓN', 'TRILLAS', '0', '2018-09-03', 'Estante', 5),
(59, 'CG11020055', 'El Alquimista (Biblioteca Paulo Coelho)', 'Paulo Coelho', 'Donación', 'Grijalbo', '9786073114417', '2018-09-05', 'Estante', 2),
(61, 'CG21222001', 'La quinta montaña (Biblioteca Paulo Coelho)', 'Paulo Coelho', 'DONACIÓN', 'Grijalbo', '9786073111843', '2018-09-05', 'Estante', 4),
(62, 'CG21222002', 'La quinta montaña (Biblioteca Paulo Coelho)', 'Paulo Coelho', 'DONACIÓN', 'Grijalbo', '9786073111843', '2018-09-05', 'Estante', 4),
(63, 'CG21222003', 'La quinta montaña (Biblioteca Paulo Coelho)', 'Paulo Coelho', 'DONACIÓN', 'Grijalbo', '9786073111843', '2018-09-05', 'Estante', 4),
(64, 'CG10211222', 'El arte de hablar y escribir', 'Raúl Rojas Soriano', 'DONACIÓN', 'Plaza y Valdes', '9688568929', '2018-09-05', 'Estante', 1),
(65, 'CG10211223', 'El arte de hablar y escribir', 'Raúl Rojas Soriano', 'DONACIÓN', 'Plaza y Valdes', '9688568929', '2018-09-05', 'Estante', 1),
(66, 'CG10211224', 'El arte de hablar y escribir', 'Raúl Rojas Soriano', 'DONACIÓN', 'Plaza y Valdes', '9688568929', '2018-09-05', 'Estante', 1),
(67, 'CG12100111', 'Learning PHP, MySQL & JavaScript', 'Robin Nixon', 'DONACION', '"O''Reilly Media, Inc."', '9781491979099', '2018-09-05', 'Estante', 1),
(68, 'CG12100112', 'Learning PHP, MySQL & JavaScript', 'Robin Nixon', 'DONACION', '"O''Reilly Media, Inc."', '9781491979099', '2018-09-05', 'Estante', 1),
(69, 'CG12100113', 'Learning PHP, MySQL & JavaScript', 'Robin Nixon', 'DONACION', '"O''Reilly Media, Inc."', '9781491979099', '2018-09-05', 'Estante', 1),
(70, 'CG12100114', 'Learning PHP, MySQL & JavaScript', 'Robin Nixon', 'DONACION', '"O''Reilly Media, Inc."', '9781491979099', '2018-09-05', 'Estante', 1),
(71, 'CG12050544', 'Cómo iniciar y administrar un restaurante', 'Brian Cooper,Brian Floody,Gina McNeill', 'DONACIÓN', 'Editorial Norma', '9580466114', '2018-09-05', 'Estante', 5),
(72, 'CG12050545', 'Cómo iniciar y administrar un restaurante', 'Brian Cooper,Brian Floody,Gina McNeill', 'DONACIÓN', 'Editorial Norma', '9580466114', '2018-09-05', 'Estante', 5),
(73, 'CG12454875', 'Hacking y serguridad en Internet', 'Fernando Picouto Ramos', 'DONACIÓN', 'Editorial Ra-Ma', '8478978089', '2018-09-05', 'Estante', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id` int(11) NOT NULL,
  `id_pk_libro` int(11) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_entrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(8) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `usuario` varchar(30) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visit_alumnos`
--

CREATE TABLE `visit_alumnos` (
  `id_matricula` int(8) NOT NULL,
  `Id_carrera` int(8) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `telefono` varchar(13) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `visit_alumnos`
--

INSERT INTO `visit_alumnos` (`id_matricula`, `Id_carrera`, `nombre`, `telefono`, `fecha`) VALUES
(16307007, 1, 'Maria Selenia Rosas Fajardo', '7421054878', '2018-09-02'),
(16307021, 1, 'Carlos Contrera Layna', '7581087019', '2018-09-04'),
(16307058, 5, 'Selenia Rosas Gonzales', '7421189369', '2018-09-03'),
(16307079, 1, 'Misael Lezma Mesino', '7421029009', '2018-09-02'),
(16309040, 5, 'Carlos Salvador Galena Reyes', '7421054858', '2018-09-03'),
(16309041, 5, 'Jose Antonio Velez Tilapa', '7584124585', '2018-09-03'),
(163070192, 5, 'Carlos Alberto Valdez Hernandez', '7584578156', '2018-09-03');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Folio` (`Folio`),
  ADD KEY `Folio_2` (`Folio`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pk_libro` (`id_pk_libro`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `visit_alumnos`
--
ALTER TABLE `visit_alumnos`
  ADD PRIMARY KEY (`id_matricula`),
  ADD KEY `Id_carrera` (`Id_carrera`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
