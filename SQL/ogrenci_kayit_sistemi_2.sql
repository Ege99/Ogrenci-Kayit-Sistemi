-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 10 Oca 2022, 04:22:57
-- Sunucu sürümü: 8.0.27
-- PHP Sürümü: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `ogrenci_kayit_sistemi_2`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `lessons`
--

DROP TABLE IF EXISTS `lessons`;
CREATE TABLE IF NOT EXISTS `lessons` (
  `lessonid` bigint NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(255) NOT NULL,
  PRIMARY KEY (`lessonid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `lessons`
--

INSERT INTO `lessons` (`lessonid`, `lesson_name`) VALUES
(1, 'Matematik'),
(2, 'Fizik');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `studentid` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `students`
--

INSERT INTO `students` (`studentid`, `first_name`, `last_name`) VALUES
(1, 'Ege', 'Subat'),
(2, 'Hilmi', 'Subat');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `students_lessons`
--

DROP TABLE IF EXISTS `students_lessons`;
CREATE TABLE IF NOT EXISTS `students_lessons` (
  `student_id` bigint NOT NULL,
  `lesson_id` bigint NOT NULL,
  PRIMARY KEY (`student_id`,`lesson_id`),
  KEY `FKl74mablpk6p07wu4o8vbg0xx2` (`lesson_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `students_lessons`
--

INSERT INTO `students_lessons` (`student_id`, `lesson_id`) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 2);

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `students_lessons`
--
ALTER TABLE `students_lessons`
  ADD CONSTRAINT `FKl74mablpk6p07wu4o8vbg0xx2` FOREIGN KEY (`lesson_id`) REFERENCES `lessons` (`lessonid`),
  ADD CONSTRAINT `FKqql952bbmi6aeq4p6k2agkk7o` FOREIGN KEY (`student_id`) REFERENCES `students` (`studentid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
