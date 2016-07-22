-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- 主機: 127.0.0.1
-- 產生時間： 2016 �?07 ??22 ??09:05
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=29 ;

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
('Camp', 'ww', 'ww', 'w', 'w', 'w', 22, 1467842400),
('Database', 'world', 'world', 'MIS', 'MIS', 'MIS', 23, 1470175200),
('idiot', '', '', '', '', '', 24, 1462226400),
('è›¤èœŠçš„æ¸£', 'jonson', '', '', 'tomous', '', 25, 1462226400),
('æˆ‘çš„å°ç³»çµ±', 'Jolin Cai', '123@123', 'CSIE', 'å¦¹æœ‰', 'å¤§æ¦‚é€™æ¨£', 26, 1467324000),
('TRY', 'å“ˆå›‰', 'å—¨', 'å–”å–”', 'HH@', 'YO', 27, 1468360800),
('çœŸçš„æ²’å•é¡Œ', 'å¯å—Ž', 'å–”å–”', 'è€¶', 'å‘¼', 'å“ˆ', 28, 1467496800);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
