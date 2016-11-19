-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 06, 2016 at 01:18 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentdb`
--
CREATE DATABASE IF NOT EXISTS `studentdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `studentdb`;

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE IF NOT EXISTS `college` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `city` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `college`
--

INSERT INTO `college` (`id`, `name`, `city`) VALUES
(2, 'IIT Kharagpure', 'Kharagpure'),
(7, 'IIT KGP', 'Kharagpure'),
(8, 'Indian Institute of Technology, Madras', 'Chennai'),
(9, 'Indian Institute of Technology, Kanpur', 'Kanpur'),
(10, 'Veer Surendra Sai University of Technology, Sambalpur', 'Sambalpur'),
(11, 'Thapar University, Patiala', ' Patiala'),
(12, 'SASTRA University, Thanjavur', ' Thanjavur');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `studentId` int(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `yearLevel` int(5) NOT NULL,
  `collegeId` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`studentId`),
  KEY `collegeId` (`collegeId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `firstname`, `lastname`, `yearLevel`, `collegeId`) VALUES
(17, 'Rohit', 'Sharma', 4, 2),
(18, 'Hello', 'Ray', 3, 2),
(19, 'Hello', 'Ray', 3, 2),
(20, 'Hello', 'Ray', 3, 2),
(21, 'Hello', 'Ray', 3, 2),
(23, 'Anshu', 'Singh', 1, 12),
(24, 'Sagar', 'Singh', 1, 10);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_college_fk` FOREIGN KEY (`collegeId`) REFERENCES `college` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
