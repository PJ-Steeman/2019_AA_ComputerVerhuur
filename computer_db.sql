-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2019 at 03:18 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

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
-- Table structure for table `computers`
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
-- Dumping data for table `computers`
--

INSERT INTO `computers` (`c_id`, `c_naam`, `c_omsch`, `c_lok`, `c_opl`, `c_serie`, `c_aankoop`, `c_huur`) VALUES
(1, 'DESKTOP-1111', 'AMD Ryzen 2700, Nvidia Quadro p1000, 16GB RAM', 'A213', 'E/ICT', 1111111111, 2000, 5),
(2, 'DESKTOP-1112', 'AMD Ryzen 2700, Nvidia Quadro p1000, 16GB RAM', 'A213', 'E/ICT', 1111111112, 2000, 10),
(3, 'DESKTOP-1113', 'Intel i7 4790k, Nvidia GTX 980, 16GB RAM', 'B104', 'Chemie', 1111111113, 1250, 5);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `g_uid` varchar(10) NOT NULL,
  `g_groep` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`g_uid`, `g_groep`) VALUES
('d1111', 'd'),
('d1112', 'd'),
('e', 'e'),
('s1111', 's');

-- --------------------------------------------------------

--
-- Table structure for table `momenten`
--

CREATE TABLE `momenten` (
  `m_id` int(11) NOT NULL,
  `m_comp` int(11) NOT NULL,
  `m_van` datetime NOT NULL,
  `m_tot` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `momenten`
--

INSERT INTO `momenten` (`m_id`, `m_comp`, `m_van`, `m_tot`) VALUES
(1, 1, '2019-11-29 11:00:00', '2019-11-29 12:00:00'),
(2, 3, '2019-11-30 18:00:00', '2019-11-29 19:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `reservaties`
--

CREATE TABLE `reservaties` (
  `r_id` int(11) NOT NULL,
  `r_user` varchar(10) NOT NULL,
  `r_moment` int(11) NOT NULL,
  `r_prijs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservaties`
--

INSERT INTO `reservaties` (`r_id`, `r_user`, `r_moment`, `r_prijs`) VALUES
(1, 'd1111', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` varchar(10) NOT NULL,
  `u_naam` varchar(20) NOT NULL,
  `u_wachtwoord` varchar(20) NOT NULL,
  `u_richting` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `u_naam`, `u_wachtwoord`, `u_richting`) VALUES
('d1111', 'Joost Vennekens', '1234', 'E/ICT'),
('d1112', 'Raf Dewil', '4321', 'Chemie'),
('e', 'Hugh Mungus', 'a1b2', 'ext'),
('s1111', 'Jonas Michiels', 'abcd', 'E/ICT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `computers`
--
ALTER TABLE `computers`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD KEY `g_uid` (`g_uid`);

--
-- Indexes for table `momenten`
--
ALTER TABLE `momenten`
  ADD PRIMARY KEY (`m_id`),
  ADD KEY `m_comp` (`m_comp`);

--
-- Indexes for table `reservaties`
--
ALTER TABLE `reservaties`
  ADD PRIMARY KEY (`r_id`),
  ADD KEY `r_moment` (`r_moment`),
  ADD KEY `r_user` (`r_user`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`g_uid`) REFERENCES `users` (`u_id`);

--
-- Constraints for table `momenten`
--
ALTER TABLE `momenten`
  ADD CONSTRAINT `momenten_ibfk_1` FOREIGN KEY (`m_comp`) REFERENCES `computers` (`c_id`);

--
-- Constraints for table `reservaties`
--
ALTER TABLE `reservaties`
  ADD CONSTRAINT `reservaties_ibfk_1` FOREIGN KEY (`r_moment`) REFERENCES `momenten` (`m_id`),
  ADD CONSTRAINT `reservaties_ibfk_2` FOREIGN KEY (`r_user`) REFERENCES `users` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
