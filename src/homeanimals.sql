-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Час створення: Лис 09 2022 р., 13:40
-- Версія сервера: 5.7.37
-- Версія PHP: 8.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `homeanimals`
--

-- --------------------------------------------------------

--
-- Структура таблиці `homeanimals`
--

CREATE TABLE `homeanimals` (
  `ID` int(1) NOT NULL,
  `Animal` varchar(15) NOT NULL,
  `Name` varchar(15) NOT NULL,
  `Color` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп даних таблиці `homeanimals`
--

INSERT INTO `homeanimals` (`ID`, `Animal`, `Name`, `Color`) VALUES
(1, 'Cat', 'Barsik', 'Black'),
(3, 'Dog', 'Lola', 'Brown'),
(4, 'Fish', 'Nemo', 'Orange');

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `homeanimals`
--
ALTER TABLE `homeanimals`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `homeanimals`
--
ALTER TABLE `homeanimals`
  MODIFY `ID` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
