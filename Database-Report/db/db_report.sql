-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- 主機: 127.0.0.1
-- 產生時間： 2016 �?04 ??30 ??16:42
-- 伺服器版本: 5.6.17
-- PHP 版本： 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 資料庫： `db_report`
--

-- --------------------------------------------------------

--
-- 資料表結構 `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '使用者名稱',
  `userid` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '帳號',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- 資料表的匯出資料 `account`
--

INSERT INTO `account` (`id`, `username`, `userid`, `password`, `email`) VALUES
(5, 'test', 'test1', '05a671c66aefea124cc08b76ea6d30bb', 'test@gmail.com');

-- --------------------------------------------------------

--
-- 資料表結構 `info`
--

CREATE TABLE IF NOT EXISTS `info` (
  `title` varchar(30) CHARACTER SET latin1 NOT NULL,
  `name` varchar(30) CHARACTER SET latin1 NOT NULL,
  `email` varchar(30) CHARACTER SET latin1 NOT NULL,
  `department` varchar(30) CHARACTER SET latin1 NOT NULL,
  `professor` varchar(30) CHARACTER SET latin1 NOT NULL,
  `message` varchar(300) CHARACTER SET latin1 NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=23 ;

--
-- 資料表的匯出資料 `info`
--

INSERT INTO `info` (`title`, `name`, `email`, `department`, `professor`, `message`, `ID`, `time`) VALUES
('Studying', 'Yi-Ling', '123@1123', 'MIS', 'Yi-Min', 'have a place to study', 3, 1462312800),
('Studying', 'Yi-Ling', '123@1123', 'MIS', 'Yi-Min', 'have a place to study', 4, 1463004000),
('Engage', 'Mean', '123@1123', 'CSIE', 'FuHau', 'I love him', 5, 1462744800),
('Sleeping', 'Dog', '123@1123', 'Physics', 'Chung', 'good night.', 6, 1464127200),
('Nap', 'DeadDog', '123@1123', 'CMS', 'ChuChuShoes', 'Charlie', 7, 1464127200),
('Looking', 'JanShin', '123@1123', 'MIS', 'FuHau', 'I love him', 8, 1463954400),
('Dating', 'Jolin', '123@1123', 'CSIE', 'HeavyEyes', 'With Java', 9, 1465941600),
('Wake', 'Kimberly', 'oo@oo', 'CSIE', 'SuFen', 'Wake the slept', 11, 1459980000),
('Wake', 'Kimberly', 'oo@oo', 'CSIE', 'SuFen', 'Wake the slept', 12, 1461276000),
('Concert', 'Short', 'Short@www', 'Little', 'Su', '', 13, 1460239200),
('Lunch', 'CheeTing', 'oo@oo', 'En', 'Professor', 'eating', 15, 1461016800),
('Birthday', 'Who', 'kk', 'kk', 'kk', 'kk', 16, 1459893600),
('Dinner', 'wo', 'wo', 'wo', 'wo', 'wo', 17, 1459980000),
('Dinner', 'wo', 'wo', 'wo', 'wo', 'wo', 18, 1460239200),
('Picnicking', 'woody', 'woody', 'woody', 'woody', 'woody', 19, 1456873200),
('Picnicking', 'woody', 'woody', 'woody', 'woody', 'woody', 20, 1458946800),
('Movie', 'sd', 'sd', 'sd', 'sd', 'sd', 21, 1457996400),
('Camp', 'ww', 'ww', 'w', 'w', 'w', 22, 1467842400);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
