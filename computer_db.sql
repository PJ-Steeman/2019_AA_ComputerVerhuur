-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 11 jan 2020 om 20:41
-- Serverversie: 10.4.8-MariaDB
-- PHP-versie: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `computer_db`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `computers`
--

CREATE TABLE `computers` (
  `c_id` int(11) NOT NULL,
  `c_naam` varchar(20) NOT NULL,
  `c_omsch` varchar(100) NOT NULL,
  `c_lok` varchar(5) NOT NULL,
  `c_opl` varchar(6) NOT NULL,
  `c_serie` int(11) NOT NULL,
  `c_aankoop` int(11) NOT NULL,
  `c_huur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `computers`
--

INSERT INTO `computers` (`c_id`, `c_naam`, `c_omsch`, `c_lok`, `c_opl`, `c_serie`, `c_aankoop`, `c_huur`) VALUES
(1, 'DESKTOP-1111', 'AMD Ryzen 2700, Nvidia Quadro p1000, 16GB RAM', 'A213', 'E/ICT', 1111111111, 2000, 5),
(2, 'DESKTOP-1112', 'AMD Ryzen 2700, Nvidia Quadro p1000, 16GB RAM', 'A213', 'E/ICT', 1111111112, 2000, 10),
(3, 'DESKTOP-1113', 'Intel i7 4790k, Nvidia GTX 980, 16GB RAM', 'B104', 'Chemie', 1111111113, 1250, 5),
(4, 'DESKTOP-1114', 'Intel i5 9600k, Nvidia Quadro P2000', 'A213', 'E/ICT', 1111111114, 1750, 2),
(5, 'DESKTOP-1116', 'AMD', 'A212', 'E/ICT', 8, 2000, 5);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `groups`
--

CREATE TABLE `groups` (
  `u_id` varchar(10) NOT NULL,
  `g_groep` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `groups`
--

INSERT INTO `groups` (`u_id`, `g_groep`) VALUES
('d1111', 'd'),
('d1112', 'd'),
('e', 'e'),
('s1111', 's');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `momenten`
--

CREATE TABLE `momenten` (
  `m_id` int(11) NOT NULL,
  `m_van` datetime NOT NULL,
  `m_tot` datetime NOT NULL,
  `m_comp` int(11) NOT NULL,
  `m_res` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `momenten`
--

INSERT INTO `momenten` (`m_id`, `m_van`, `m_tot`, `m_comp`, `m_res`) VALUES
(1, '2019-12-18 11:00:00', '2019-12-18 12:00:00', 1, 3),
(2, '2019-12-19 14:00:00', '2019-12-19 15:00:00', 2, 2),
(3, '2019-12-17 16:00:00', '2019-12-17 17:00:00', 1, 4),
(4, '2019-12-13 12:00:00', '2019-12-13 14:00:00', 1, 5),
(5, '0020-12-05 12:00:00', '0020-12-05 13:00:00', 1, 6),
(6, '2020-05-18 15:00:00', '2020-05-18 16:00:00', 4, 0),
(7, '2020-06-11 09:00:00', '2020-06-11 10:00:00', 5, 0);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `reservaties`
--

CREATE TABLE `reservaties` (
  `r_id` int(11) NOT NULL,
  `r_prijs` int(11) NOT NULL,
  `r_user` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `reservaties`
--

INSERT INTO `reservaties` (`r_id`, `r_prijs`, `r_user`) VALUES
(0, 0, '0'),
(2, 0, 's1111'),
(3, 0, 's1111'),
(4, 0, 's1111'),
(5, 10, 'e'),
(6, 5, 'e');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE `users` (
  `u_id` varchar(10) NOT NULL,
  `u_naam` varchar(20) NOT NULL,
  `u_wachtwoord` varchar(20) NOT NULL,
  `u_richting` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`u_id`, `u_naam`, `u_wachtwoord`, `u_richting`) VALUES
('0', 'Niet gereserveerd', 'NVT', 'NVT'),
('d1111', 'Joost Vennekens', '1234', 'E/ICT'),
('d1112', 'Raf Dewil', '4321', 'Chemie'),
('e', 'Extern', '', 'ext'),
('s1111', 'Jonas Michiels', 'abcd', 'E/ICT');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `computers`
--
ALTER TABLE `computers`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexen voor tabel `groups`
--
ALTER TABLE `groups`
  ADD KEY `g_uid` (`u_id`);

--
-- Indexen voor tabel `momenten`
--
ALTER TABLE `momenten`
  ADD PRIMARY KEY (`m_id`),
  ADD KEY `m_comp` (`m_comp`),
  ADD KEY `m_res` (`m_res`);

--
-- Indexen voor tabel `reservaties`
--
ALTER TABLE `reservaties`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `r_user` (`r_user`);

--
-- Indexen voor tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`);

--
-- Beperkingen voor tabel `momenten`
--
ALTER TABLE `momenten`
  ADD CONSTRAINT `momenten_ibfk_1` FOREIGN KEY (`m_comp`) REFERENCES `computers` (`c_id`),
  ADD CONSTRAINT `momenten_ibfk_2` FOREIGN KEY (`m_res`) REFERENCES `reservaties` (`r_id`);

--
-- Beperkingen voor tabel `reservaties`
--
ALTER TABLE `reservaties`
  ADD CONSTRAINT `reservaties_ibfk_1` FOREIGN KEY (`r_user`) REFERENCES `users` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
