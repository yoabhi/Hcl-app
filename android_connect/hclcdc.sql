-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2014 at 07:06 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hclcdc`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail`
--

CREATE TABLE IF NOT EXISTS `detail` (
  `reg_no` varchar(40) NOT NULL,
  `reg_date` varchar(20) NOT NULL,
  `s_name` varchar(40) NOT NULL,
  `f_name` varchar(40) NOT NULL,
  `cert_no` varchar(40) NOT NULL,
  `d_issue` date NOT NULL,
  `c_name` varchar(40) NOT NULL,
  `t_period` varchar(40) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `dob` date NOT NULL,
  `c_no` varchar(40) NOT NULL,
  `h_no` varchar(40) NOT NULL,
  `address` text NOT NULL,
  `email` varchar(40) NOT NULL,
  `s_centre` varchar(40) NOT NULL,
  `quali` varchar(40) NOT NULL,
  `f_inst` varchar(40) NOT NULL,
  `s_inst` varchar(40) NOT NULL,
  `t_fee` varchar(40) NOT NULL,
  PRIMARY KEY (`reg_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail`
--

INSERT INTO `detail` (`reg_no`, `reg_date`, `s_name`, `f_name`, `cert_no`, `d_issue`, `c_name`, `t_period`, `gender`, `dob`, `c_no`, `h_no`, `address`, `email`, `s_centre`, `quali`, `f_inst`, `s_inst`, `t_fee`) VALUES
('20001', '10/8/2014', 'Abhishek', 'Om prakash Kaswan', 'LH-13805', '2014-10-15', 'Android', '45 days', 'Male', '1993-01-21', '8559960007', '', 'xyzzz', 'abhishekkaswan001@gmail.com', 'HCL-CDC Jaipur', 'B.Tech', '4500', '5000', '9500');

-- --------------------------------------------------------

--
-- Table structure for table `enquiry`
--

CREATE TABLE IF NOT EXISTS `enquiry` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mob` varchar(40) NOT NULL,
  `sel_course` varchar(40) NOT NULL,
  `ques` varchar(40) NOT NULL,
  `state` varchar(40) NOT NULL,
  `city` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `enquiry`
--

INSERT INTO `enquiry` (`id`, `name`, `email`, `mob`, `sel_course`, `ques`, `state`, `city`) VALUES
(1, 'Abhishek', 'abhishekkaswan001@gmail.com', '8559960007', 'Android', 'Questionnnn', 'Rajasthan', 'HCL-CDC Jaipur'),
(2, 'Rakesh', 'rakeshverma.verma327@gmail.com', '8955912274', 'JAVA', '??????', 'Rajasthan', 'HCL-CDC Ajmer'),
(3, 'Manish', 'manishsolanki@gmail.com', '7793811209', 'Red Hat', 'noo', 'Rajasthan', 'HCL-CDC Jaipur');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `U_name` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `U_name`, `pass`) VALUES
(1, 'abhi001', 'yoabhi'),
(2, 'admin', 'admin'),
(3, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE IF NOT EXISTS `registration` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `reg_date` varchar(20) NOT NULL,
  `reg_no` varchar(20) NOT NULL,
  `s_name` varchar(20) NOT NULL,
  `f_name` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `c_no` varchar(20) NOT NULL,
  `h_no` varchar(20) NOT NULL,
  `address` text NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  `s_centre` varchar(20) NOT NULL,
  `quali` varchar(20) NOT NULL,
  `f_inst` varchar(20) NOT NULL,
  `s_inst` varchar(20) NOT NULL,
  `t_fee` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `reg_date`, `reg_no`, `s_name`, `f_name`, `gender`, `dob`, `c_no`, `h_no`, `address`, `city`, `state`, `email`, `c_name`, `s_centre`, `quali`, `f_inst`, `s_inst`, `t_fee`) VALUES
(1, '', '20001', 'Abhishek', 'Om Prakash Kaswan', 'male', '1993-01-21', '8559960007', '', 'xyzz', 'Jaipur', 'Rajasthan', 'abhishekkaswan001@gmail.com', 'Android', 'HCL-CDC Jaipur', 'B.Tech', '4500', '5000', '9500');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
