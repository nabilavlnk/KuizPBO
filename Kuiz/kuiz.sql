-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2020 at 11:56 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kuiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `NIS` varchar(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Ttl` varchar(50) NOT NULL,
  `Kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `Agama` varchar(20) NOT NULL,
  `Daftar` varchar(50) NOT NULL,
  `Berlaku` varchar(50) NOT NULL,
  `Kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`NIS`, `Nama`, `Ttl`, `Kelamin`, `Agama`, `Daftar`, `Berlaku`, `Kelas`) VALUES
('123', 'bela', 'yogya', 'Perempuan', 'Islam', 'c', '1', '2'),
('122', 'bbb', 'yogya', 'Perempuan', 'Islam', 'c', '8', '9'),
('123', 'bbb', '20-10-2000', 'Laki-laki', 'Islam', 'a', '20-11-2018', '20-11-2019');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `Kode` varchar(11) NOT NULL,
  `Namabuku` varchar(50) NOT NULL,
  `Pengarang` varchar(50) NOT NULL,
  `Penerbit` varchar(50) NOT NULL,
  `Tahun` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`Kode`, `Namabuku`, `Pengarang`, `Penerbit`, `Tahun`) VALUES
('123', 'bagus', 'tereliye', 'gramedia', '2000'),
('123', 'indah', 'tereliye', 'gramedia', '2000'),
('123', 'indah', 'tereliye', 'gramed', '2019'),
('123', 'ok', 'aku', 'yay', '2000'),
('12', 'ww', 'ww', 'ww', '2000'),
('11', 'oke', 'oke', 'oke', '2000'),
('123', 'IPA', 'Ani', 'Gramedia', '2016'),
('123', 'oke', 'bela', 'gramedia', '2016');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` varchar(11) NOT NULL,
  `Namakaryawan` varchar(50) NOT NULL,
  `JKaryawan` enum('Laki-laki','Perempuan') NOT NULL,
  `Golongan` varchar(11) NOT NULL,
  `Jabatan` varchar(30) NOT NULL,
  `Tunjangan` varchar(15) NOT NULL,
  `Gaji` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`NIK`, `Namakaryawan`, `JKaryawan`, `Golongan`, `Jabatan`, `Tunjangan`, `Gaji`) VALUES
('123', 'bela', 'Perempuan', '3', 'senior', '3000000', '9000000'),
('124', 'ayu', 'Perempuan', '5', 'senior', '3000000', '9000000'),
('123', 'mmmm', 'Laki-laki', '1', 'Ketua', '500.000', '1.000.000'),
('098', 'yaya', 'Perempuan', '1', 'Ketua', '500.000', '1.000.000'),
('40', 'qwe', 'Laki-laki', '1', 'Ketua', '500.000', '1.000.000');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `NoPeminjam` varchar(11) NOT NULL,
  `NIS` varchar(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Kelas` varchar(10) NOT NULL,
  `Kodebuku` varchar(11) NOT NULL,
  `Namabuku` varchar(50) NOT NULL,
  `Penerbit` varchar(50) NOT NULL,
  `TglPinjam` varchar(50) NOT NULL,
  `TglKembali` varchar(50) NOT NULL,
  `Lama` varchar(11) NOT NULL,
  `Denda` varchar(11) NOT NULL,
  `Petugas` varchar(50) NOT NULL,
  `NIK` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`NoPeminjam`, `NIS`, `Nama`, `Kelas`, `Kodebuku`, `Namabuku`, `Penerbit`, `TglPinjam`, `TglKembali`, `Lama`, `Denda`, `Petugas`, `NIK`) VALUES
('011', '111', 'bela', 'c', '011', 'indah', 'tere', '09-09-2018', '09-11-2018', '3', '-', 'oyik', '011'),
('012', '134', 'abi', 'b', '018', 'indah', 'lala', '08-10-2018', '11-10-2018', '3', '-', 'fitri', '019');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
