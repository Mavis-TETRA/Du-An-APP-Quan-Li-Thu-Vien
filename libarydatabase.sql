-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2022 at 04:58 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `libarydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id_author` int(11) NOT NULL,
  `name_author` varchar(200) NOT NULL,
  `date_crt` date NOT NULL,
  `date_upd` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id_book` int(11) NOT NULL,
  `name_book` text NOT NULL,
  `image_book` blob NOT NULL,
  `id_category` int(11) DEFAULT NULL,
  `id_author` int(11) DEFAULT NULL,
  `id_pub` int(11) NOT NULL,
  `id_bs` int(11) DEFAULT NULL,
  `date_crt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bookshelf`
--

CREATE TABLE `bookshelf` (
  `id_bs` int(11) NOT NULL,
  `name_bs` int(11) NOT NULL,
  `date_crt` date NOT NULL,
  `date_upd` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id_category` int(11) NOT NULL,
  `name_category` varchar(200) NOT NULL,
  `date_create` date NOT NULL,
  `date_update` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `commentbooks`
--

CREATE TABLE `commentbooks` (
  `id_com` int(11) NOT NULL,
  `id_book` int(11) DEFAULT NULL,
  `mssv` int(11) DEFAULT NULL,
  `commentbook` text DEFAULT NULL,
  `date_crt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detailbooks`
--

CREATE TABLE `detailbooks` (
  `id_interactive` int(11) NOT NULL,
  `id_book` int(11) DEFAULT NULL,
  `like_book` int(11) NOT NULL DEFAULT 1,
  `view_book` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `inforbrandpay`
--

CREATE TABLE `inforbrandpay` (
  `id_count` int(11) NOT NULL,
  `id_borrowpay` int(11) DEFAULT NULL,
  `id_book` int(11) DEFAULT NULL,
  `note` text DEFAULT NULL,
  `borandpay` int(11) NOT NULL DEFAULT 1,
  `date_pay` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id_lib` int(11) NOT NULL,
  `name_lib` varchar(60) NOT NULL,
  `permission` int(11) NOT NULL DEFAULT 2,
  `phone_lib` varchar(20) NOT NULL,
  `date_crt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `publishingcompany`
--

CREATE TABLE `publishingcompany` (
  `id_pub` int(11) NOT NULL,
  `name_pub` text NOT NULL,
  `address_pub` text DEFAULT NULL,
  `email_pub` varchar(50) DEFAULT NULL,
  `infor_pub` text DEFAULT NULL,
  `date_crt` date NOT NULL,
  `date_upd` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id_author`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id_book`);

--
-- Indexes for table `bookshelf`
--
ALTER TABLE `bookshelf`
  ADD PRIMARY KEY (`id_bs`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indexes for table `commentbooks`
--
ALTER TABLE `commentbooks`
  ADD PRIMARY KEY (`id_com`);

--
-- Indexes for table `detailbooks`
--
ALTER TABLE `detailbooks`
  ADD PRIMARY KEY (`id_interactive`);

--
-- Indexes for table `inforbrandpay`
--
ALTER TABLE `inforbrandpay`
  ADD PRIMARY KEY (`id_count`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id_lib`);

--
-- Indexes for table `publishingcompany`
--
ALTER TABLE `publishingcompany`
  ADD PRIMARY KEY (`id_pub`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id_author` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id_book` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bookshelf`
--
ALTER TABLE `bookshelf`
  MODIFY `id_bs` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `commentbooks`
--
ALTER TABLE `commentbooks`
  MODIFY `id_com` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `detailbooks`
--
ALTER TABLE `detailbooks`
  MODIFY `id_interactive` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inforbrandpay`
--
ALTER TABLE `inforbrandpay`
  MODIFY `id_count` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id_lib` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `publishingcompany`
--
ALTER TABLE `publishingcompany`
  MODIFY `id_pub` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
