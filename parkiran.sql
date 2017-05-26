-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2017 at 04:22 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_parkir`
--

-- --------------------------------------------------------

--
-- Table structure for table `parkiran`
--

CREATE TABLE `parkiran` (
  `id_parkiran` varchar(12) NOT NULL,
  `no_polisi` varchar(35) NOT NULL,
  `jenis_kendaraan` varchar(25) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `jam_masuk` time NOT NULL,
  `tgl_keluar` date DEFAULT NULL,
  `jam_keluar` time DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parkiran`
--

INSERT INTO `parkiran` (`id_parkiran`, `no_polisi`, `jenis_kendaraan`, `tgl_masuk`, `jam_masuk`, `tgl_keluar`, `jam_keluar`, `total`) VALUES
('PR/00001', '123', 'Mobil', '2017-05-24', '22:33:47', '2017-05-24', '22:34:05', 3000),
('PR/00002', 'S345T', 'Motor', '2017-05-24', '22:53:39', '2017-05-24', '22:55:43', 2000),
('PR/00003', 'H671AS', 'Motor', '2017-05-24', '22:53:56', '2017-05-26', '08:19:03', NULL),
('PR/00004', 'AYUN', 'Mobil', '2017-05-24', '22:54:37', '2017-05-24', '22:54:45', 4500),
('PR/00005', 'AG112A', 'Mobil', '2017-05-26', '09:00:00', NULL, NULL, NULL),
('PR/00006', '11A', 'Mobil', '2017-05-26', '09:02:16', '2017-05-26', '09:02:24', 3000),
('PR/00007', 'S117AD', 'Mobil', '2017-05-26', '09:13:36', '2017-05-26', '09:20:10', 3000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `parkiran`
--
ALTER TABLE `parkiran`
  ADD PRIMARY KEY (`id_parkiran`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
