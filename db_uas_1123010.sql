-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2025 at 05:52 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uas_1123010`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Name`, `password`, `address`, `phone`) VALUES
(1, 'Reivel', '123', 'Perumahan Taman Rahayu 3 C2 no 1 ', '082321534551'),
(2, 'Rafael', '321', 'Perumahan Taman Rahayu 3 C2 no 2', '082321534551');

-- --------------------------------------------------------

--
-- Table structure for table `deliverdetail`
--

CREATE TABLE `deliverdetail` (
  `id` int(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `currentPosition` varchar(30) NOT NULL,
  `evidence` varchar(30) DEFAULT NULL,
  `updateBy` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `transaction_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deliverdetail`
--

INSERT INTO `deliverdetail` (`id`, `status`, `currentPosition`, `evidence`, `updateBy`, `date`, `transaction_id`) VALUES
(1, 'PENDING', 'fsda', NULL, 'fsda', '1970-01-01', 1),
(2, 'PENDING', 'jakarta', NULL, 'Reivel', '2025-01-01', 1),
(3, 'IN_PROGRESS', 'Banjarmasin', NULL, 'Reivel', '2025-01-08', 1),
(4, 'PENDING', 'jakarta', NULL, 'Reivel', '2025-01-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `delivertype`
--

CREATE TABLE `delivertype` (
  `Type` varchar(30) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Fee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `delivertype`
--

INSERT INTO `delivertype` (`Type`, `Description`, `Fee`) VALUES
('Building material ', '..', 3000),
('House Moving', '..', 8000),
('Instant Deliver ', '..', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `expected_weight` varchar(30) NOT NULL,
  `deliver_type` varchar(30) NOT NULL,
  `receipt_address` varchar(50) NOT NULL,
  `receipt_phone` varchar(30) NOT NULL,
  `total_cost` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `expected_weight`, `deliver_type`, `receipt_address`, `receipt_phone`, `total_cost`, `customer_id`) VALUES
(1, '10', 'Building Material', 'Perumahan Taman Rahayu 3 C2 no 1', '082321534551', 100000, 1),
(3, '102', 'Building Material', 'Perumahan Taman Rahayu 3 C2 no 1', '082321534551', 100000, 2),
(4, '102', 'Building Material', 'Perumahan Taman Rahayu 3 C2 no 1', '082321534551', 100000, 2),
(5, '4', 'Instant Deliver ', 'TKI', '3124141', 40000, 1),
(6, '3', 'Building material ', 'TKI 2', '0381741041', 9000, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `deliverdetail`
--
ALTER TABLE `deliverdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `deliverdetail_ibfk_1` (`transaction_id`);

--
-- Indexes for table `delivertype`
--
ALTER TABLE `delivertype`
  ADD PRIMARY KEY (`Type`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `deliverdetail`
--
ALTER TABLE `deliverdetail`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deliverdetail`
--
ALTER TABLE `deliverdetail`
  ADD CONSTRAINT `deliverdetail_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
