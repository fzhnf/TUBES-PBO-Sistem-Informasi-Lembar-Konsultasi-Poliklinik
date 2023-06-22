-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2023 at 02:57 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emrsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultation_sheet_table`
--

CREATE TABLE `consultation_sheet_table` (
  `sheet_id` int(6) NOT NULL,
  `sheet_createdat` date NOT NULL DEFAULT current_timestamp(),
  `assesment_id` int(6) NOT NULL,
  `blood_pressure` int(6) NOT NULL,
  `heart_rate` int(6) NOT NULL,
  `temperature` int(6) NOT NULL,
  `feeling_rate` int(6) NOT NULL,
  `physical_examination` varchar(200) NOT NULL,
  `diagnosis_analysis` varchar(200) NOT NULL,
  `patient_education` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consultation_sheet_table`
--

INSERT INTO `consultation_sheet_table` (`sheet_id`, `sheet_createdat`, `assesment_id`, `blood_pressure`, `heart_rate`, `temperature`, `feeling_rate`, `physical_examination`, `diagnosis_analysis`, `patient_education`) VALUES
(1, '2023-06-22', 1, 123, 123, 123, 3, 'qwepodslakm ', 'asd', 'boa'),
(2, '2023-06-22', 1, 123, 123, 123, 2, 'fdsf', 'fdsfs', 'sdfdsf');

-- --------------------------------------------------------

--
-- Table structure for table `patient_table`
--

CREATE TABLE `patient_table` (
  `assesment_id` int(6) NOT NULL,
  `patient_name` varchar(45) NOT NULL,
  `patient_gender` tinyint(1) NOT NULL,
  `patient_birthdate` date NOT NULL,
  `patient_clinic` int(6) NOT NULL,
  `assesment_status` tinyint(1) NOT NULL DEFAULT 0,
  `assesmen_createdat` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `patient_table`
--

INSERT INTO `patient_table` (`assesment_id`, `patient_name`, `patient_gender`, `patient_birthdate`, `patient_clinic`, `assesment_status`, `assesmen_createdat`) VALUES
(1, 'rapli', 1, '2023-06-14', 1, 0, '2023-06-21'),
(2, 'isnaini', 0, '2013-06-11', 2, 0, '2023-06-21'),
(3, 'admin', 1, '2023-05-30', 3, 0, '2023-06-21'),
(4, 'ayu', 0, '2023-06-05', 1, 1, '2023-06-21'),
(5, 'miles', 1, '2023-03-29', 2, 1, '2023-06-21'),
(6, 'morales', 1, '2029-02-15', 3, 1, '2023-06-21');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int(6) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_clinic` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`user_id`, `user_name`, `user_password`, `user_clinic`) VALUES
(1, 'faiz', '14124', 1),
(2, 'rafi', '14124', 2),
(43, 'enokido', '14124', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consultation_sheet_table`
--
ALTER TABLE `consultation_sheet_table`
  ADD PRIMARY KEY (`sheet_id`);

--
-- Indexes for table `patient_table`
--
ALTER TABLE `patient_table`
  ADD PRIMARY KEY (`assesment_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consultation_sheet_table`
--
ALTER TABLE `consultation_sheet_table`
  MODIFY `sheet_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `patient_table`
--
ALTER TABLE `patient_table`
  MODIFY `assesment_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
