-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Sam 17 Mai 2025 à 15:25
-- Version du serveur: 5.5.8
-- Version de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `internshipdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `appreciation`
--

CREATE TABLE IF NOT EXISTS `appreciation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `periode_id` bigint(20) DEFAULT NULL,
  `tuteur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlql6wnbwtnj5eddbhfid1h0n5` (`periode_id`),
  KEY `FK12oq3vrrpgt7w07pr7n7iyhsc` (`tuteur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `appreciation`
--

INSERT INTO `appreciation` (`id`, `periode_id`, `tuteur_id`) VALUES
(1, 1, 1),
(2, 2, 4),
(3, 1, 5),
(4, 6, 10),
(5, 7, 12),
(6, 8, 14),
(7, 9, 16),
(8, 10, 18),
(9, 13, 21),
(10, 12, 22),
(11, 11, 20),
(12, 14, 26),
(13, 15, 28),
(14, 16, 28),
(15, 17, 30),
(16, 18, 30),
(17, 19, 33),
(18, 20, 35),
(19, 21, 37),
(20, 22, 37),
(21, 23, 37),
(22, 24, 37),
(23, 25, 40),
(24, 26, 42);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) DEFAULT NULL,
  `note` double NOT NULL,
  `appreciation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcmhg0ig7wdsgnwc13jdoat435` (`appreciation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `intitule`, `note`, `appreciation_id`) VALUES
(1, 'Compétences Techniques', 18, 1),
(2, 'Compétences techniques', 20, 2),
(3, 'Informatique', 17, 3),
(4, 'Communication', 15, 3),
(5, 'Compétences Individuelles', 17, 4),
(6, 'Compétences liées à l''entreprise', 16, 4),
(7, 'Compétences scientifiques', 18, 4),
(8, 'Compétences liées à l’individu', 18, 5),
(9, 'Compétences liées à l’entreprise', 17, 5),
(10, 'Compétences scientifiques et techniques', 19, 5),
(11, 'Compétences métier', 17, 6),
(12, 'Compétences métier', 17, 7),
(13, 'Compétences liées à l’individu', 16, 8),
(14, 'Compétences liées à l’entreprise', 17, 8),
(15, 'Compétences scientifiques', 18, 8),
(16, 'Compétences liées à l’individu', 12, 11),
(17, 'Compétences liées à l’individu', 12, 10),
(18, 'Compétences liées à l’individu', 12, 9),
(19, 'Compétences liées à l’entreprise', 0, 11),
(20, 'Compétences liées à l’entreprise', 0, 10),
(21, 'Compétences liées à l’entreprise', 0, 9),
(22, 'Compétences scientifiques', 10, 10),
(23, 'Compétences scientifiques', 10, 11),
(24, 'Compétences scientifiques', 10, 9),
(25, 'Compétences liées à l’individu', 19, 12),
(26, 'Compétences liées à l’entreprise', 0, 12),
(27, 'Compétences scientifiques', 19, 12),
(28, 'Compétences liées à l’individu', 19, 13),
(29, 'Compétences liées à l’entreprise', 0, 13),
(30, 'Compétences scientifiques', 17, 13),
(31, 'Compétences spécifiques métier', 0, 13),
(32, 'Compétences liées à l’individu', 0, 14),
(33, 'Compétences liées à l’entreprise', 19, 14),
(34, 'Compétences scientifiques', 20, 14),
(35, 'Compétences spécifiques métier', 0, 14),
(36, 'Compétences liées à l’individu', 0, 15),
(37, 'Compétences liées à l’entreprise', 20, 15),
(38, 'Compétences scientifiques', 19, 15),
(39, 'Compétences spécifiques métier', 0, 15),
(40, 'Compétences liées à l’individu', 20, 16),
(41, 'Compétences liées à l’entreprise', 0, 16),
(42, 'Compétences scientifiques', 20, 16),
(43, 'Compétences spécifiques métier', 0, 16),
(44, 'Compétences liées à l’individu', 20, 17),
(45, 'Compétences liées à l’entreprise', 0, 17),
(46, 'Compétences scientifiques', 19.9, 17),
(47, 'Compétences liées à l’individu', 20, 18),
(48, 'Compétences liées à l’entreprise', 0, 18),
(49, 'Compétences scientifiques', 20, 18),
(50, 'Compétences liées à l’individu', 20, 19),
(51, 'Compétences liées à l’entreprise', 0, 19),
(52, 'Compétences scientifiques', 20, 19),
(53, 'Compétences liées à l’individu', 20, 20),
(54, 'Compétences liées à l’entreprise', 0, 20),
(55, 'Compétences scientifiques', 20, 20),
(56, 'Compétences liées à l’individu', 20, 21),
(57, 'Compétences liées à l’entreprise', 0, 21),
(58, 'Compétences scientifiques', 19.9, 21),
(59, 'Compétences liées à l’individu', 20, 22),
(60, 'Compétences liées à l’entreprise', 0, 22),
(61, 'Compétences scientifiques', 19.9, 22),
(62, 'Compétences liées à l’individu', 9, 23),
(63, 'Compétences liées à l’entreprise', 9, 23),
(64, 'Compétences scientifiques', 9, 23),
(65, 'Compétences liées à l’individu', 20, 24),
(66, 'Compétences liées à l’entreprise', 19, 24),
(67, 'Compétences scientifiques', 19.8, 24);

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE IF NOT EXISTS `competence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) DEFAULT NULL,
  `niveau` enum('AUTONOME','AUTONOME_PLUS','DEBUTANT','NA') DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5cffemei14qbftr4etpo209su` (`categorie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=197 ;

--
-- Contenu de la table `competence`
--

INSERT INTO `competence` (`id`, `intitule`, `niveau`, `categorie_id`) VALUES
(1, 'Spring Boot', 'AUTONOME', 1),
(2, 'Maîtrise de Java', 'AUTONOME', 2),
(3, 'Java', 'AUTONOME', 3),
(4, 'SQL', 'DEBUTANT', 3),
(5, 'Présentation', 'NA', 4),
(6, 'Analyser et synthétiser', 'AUTONOME', 5),
(7, 'Proposer des axes d''amélioration', 'AUTONOME_PLUS', 5),
(8, 'Faire adhérer les acteurs', 'AUTONOME', 5),
(9, 'Auto-évaluation', 'AUTONOME', 5),
(10, 'Identifier les problèmes', 'AUTONOME', 5),
(11, 'Analyser fonctionnement entreprise', 'AUTONOME', 6),
(12, 'Structurer projet', 'AUTONOME', 6),
(13, 'Politique environnementale', 'DEBUTANT', 6),
(14, 'Rechercher l''information', 'AUTONOME_PLUS', 6),
(15, 'Conception produits/services', 'AUTONOME_PLUS', 7),
(16, 'Faire une auto-évaluation', 'AUTONOME', 8),
(17, 'Analyser la démarche projet', 'AUTONOME_PLUS', 9),
(18, 'Conception produits/services', 'AUTONOME_PLUS', 10),
(19, 'Faire une auto-évaluation', 'AUTONOME', 11),
(20, 'Faire une auto-évaluation', 'AUTONOME', 12),
(21, 'Être capable d’analyse et de synthèse', 'AUTONOME', 13),
(22, 'Faire une auto-évaluation', 'AUTONOME_PLUS', 13),
(23, 'Analyser la démarche projet', 'DEBUTANT', 14),
(24, 'Analyser le fonctionnement de l''entreprise', 'AUTONOME', 14),
(25, 'Conception préliminaire de produits/services', 'AUTONOME_PLUS', 15),
(26, 'Analyse', 'DEBUTANT', 16),
(27, 'Analyse', 'DEBUTANT', 17),
(28, 'Analyse', 'DEBUTANT', 18),
(29, 'Méthodes', 'DEBUTANT', 17),
(30, 'Méthodes', 'DEBUTANT', 16),
(31, 'Adhésion', 'DEBUTANT', 17),
(32, 'Méthodes', 'DEBUTANT', 18),
(33, 'Adhésion', 'DEBUTANT', 16),
(34, 'Auto-évaluation', 'DEBUTANT', 16),
(35, 'Adhésion', 'DEBUTANT', 18),
(36, 'Auto-évaluation', 'DEBUTANT', 17),
(37, 'Problèmes complexes', 'NA', 16),
(38, 'Auto-évaluation', 'DEBUTANT', 18),
(39, 'Problèmes complexes', 'NA', 17),
(40, 'Problèmes complexes', 'NA', 18),
(41, 'Fonctionnement', 'DEBUTANT', 19),
(42, 'Fonctionnement', 'DEBUTANT', 20),
(43, 'Projet', 'DEBUTANT', 20),
(44, 'Projet', 'DEBUTANT', 19),
(45, 'Fonctionnement', 'DEBUTANT', 21),
(46, 'Environnement', 'DEBUTANT', 20),
(47, 'Environnement', 'DEBUTANT', 19),
(48, 'Projet', 'DEBUTANT', 21),
(49, 'Information', 'DEBUTANT', 20),
(50, 'Information', 'DEBUTANT', 19),
(51, 'Environnement', 'DEBUTANT', 21),
(52, 'Information', 'DEBUTANT', 21),
(53, 'Préliminaire', 'NA', 23),
(54, 'Préliminaire', 'NA', 22),
(55, 'Préliminaire', 'NA', 24),
(56, 'Analyse', 'AUTONOME', 25),
(57, 'Méthodes', 'AUTONOME', 25),
(58, 'Adhésion', 'AUTONOME', 25),
(59, 'Auto-évaluation', 'AUTONOME', 25),
(60, 'Problèmes complexes', 'AUTONOME', 25),
(61, 'Fonctionnement', 'AUTONOME', 26),
(62, 'Projet', 'AUTONOME', 26),
(63, 'Environnement', 'AUTONOME', 26),
(64, 'Information', 'AUTONOME', 26),
(65, 'Préliminaire', 'AUTONOME', 27),
(66, 'Analyse', 'DEBUTANT', 28),
(67, 'Méthodes', 'DEBUTANT', 28),
(68, 'Adhésion', 'DEBUTANT', 28),
(69, 'Auto-évaluation', 'DEBUTANT', 28),
(70, 'Problèmes complexes', 'NA', 28),
(71, 'Fonctionnement', 'DEBUTANT', 29),
(72, 'Projet', 'DEBUTANT', 29),
(73, 'Environnement', 'DEBUTANT', 29),
(74, 'Information', 'DEBUTANT', 29),
(75, 'Préliminaire', 'DEBUTANT', 30),
(76, 'n3ass', 'AUTONOME_PLUS', 31),
(77, 'lmakla', 'AUTONOME_PLUS', 31),
(78, 'tyab', 'AUTONOME_PLUS', 31),
(79, 'ch9a', 'AUTONOME', 31),
(80, 'l9RAYA', 'DEBUTANT', 31),
(81, 'Analyse', 'DEBUTANT', 32),
(82, 'Méthodes', 'DEBUTANT', 32),
(83, 'Adhésion', 'DEBUTANT', 32),
(84, 'Auto-évaluation', 'DEBUTANT', 32),
(85, 'Problèmes complexes', 'NA', 32),
(86, 'Fonctionnement', 'AUTONOME', 33),
(87, 'Projet', 'AUTONOME', 33),
(88, 'Environnement', 'AUTONOME', 33),
(89, 'Information', 'DEBUTANT', 33),
(90, 'Préliminaire', 'DEBUTANT', 34),
(91, 'Analyse', 'DEBUTANT', 36),
(92, 'Méthodes', 'DEBUTANT', 36),
(93, 'Adhésion', 'DEBUTANT', 36),
(94, 'Auto-évaluation', 'DEBUTANT', 36),
(95, 'Problèmes complexes', 'DEBUTANT', 36),
(96, 'Fonctionnement', 'AUTONOME', 37),
(97, 'Projet', 'AUTONOME', 37),
(98, 'Environnement', 'AUTONOME', 37),
(99, 'Information', 'AUTONOME', 37),
(100, 'Préliminaire', 'AUTONOME', 38),
(101, 'COMP1', 'AUTONOME', 39),
(102, 'COMP2', 'AUTONOME_PLUS', 39),
(103, 'COMP3', 'AUTONOME', 39),
(104, 'COMP4', 'DEBUTANT', 39),
(105, 'COMP5', 'DEBUTANT', 39),
(106, 'Analyse', 'DEBUTANT', 40),
(107, 'Méthodes', 'AUTONOME', 40),
(108, 'Adhésion', 'AUTONOME', 40),
(109, 'Auto-évaluation', 'AUTONOME', 40),
(110, 'Problèmes complexes', 'AUTONOME', 40),
(111, 'Fonctionnement', 'DEBUTANT', 41),
(112, 'Projet', 'AUTONOME', 41),
(113, 'Environnement', 'AUTONOME', 41),
(114, 'Information', 'AUTONOME_PLUS', 41),
(115, 'Préliminaire', 'AUTONOME', 42),
(116, 'COMP1', 'DEBUTANT', 43),
(117, 'Analyse', 'AUTONOME', 44),
(118, 'Méthodes', 'AUTONOME', 44),
(119, 'Adhésion', 'AUTONOME', 44),
(120, 'Auto-évaluation', 'AUTONOME', 44),
(121, 'Problèmes complexes', 'AUTONOME', 44),
(122, 'Fonctionnement', 'AUTONOME', 45),
(123, 'Projet', 'AUTONOME', 45),
(124, 'Environnement', 'AUTONOME', 45),
(125, 'Information', 'AUTONOME', 45),
(126, 'Préliminaire', 'AUTONOME', 46),
(127, 'Analyse', 'DEBUTANT', 47),
(128, 'Méthodes', 'AUTONOME_PLUS', 47),
(129, 'Adhésion', 'AUTONOME_PLUS', 47),
(130, 'Auto-évaluation', 'AUTONOME_PLUS', 47),
(131, 'Problèmes complexes', 'AUTONOME_PLUS', 47),
(132, 'Fonctionnement', 'DEBUTANT', 48),
(133, 'Projet', 'DEBUTANT', 48),
(134, 'Environnement', 'NA', 48),
(135, 'Information', 'DEBUTANT', 48),
(136, 'Préliminaire', 'AUTONOME', 49),
(137, 'Analyse', 'AUTONOME', 50),
(138, 'Méthodes', 'AUTONOME', 50),
(139, 'Adhésion', 'AUTONOME_PLUS', 50),
(140, 'Auto-évaluation', 'AUTONOME_PLUS', 50),
(141, 'Problèmes complexes', 'AUTONOME_PLUS', 50),
(142, 'Fonctionnement', 'AUTONOME', 51),
(143, 'Projet', 'AUTONOME', 51),
(144, 'Environnement', 'AUTONOME', 51),
(145, 'Information', 'AUTONOME', 51),
(146, 'Préliminaire', 'AUTONOME', 52),
(147, 'Analyse', 'AUTONOME', 53),
(148, 'Méthodes', 'AUTONOME', 53),
(149, 'Adhésion', 'AUTONOME', 53),
(150, 'Auto-évaluation', 'AUTONOME_PLUS', 53),
(151, 'Problèmes complexes', 'AUTONOME_PLUS', 53),
(152, 'Fonctionnement', 'DEBUTANT', 54),
(153, 'Projet', 'AUTONOME', 54),
(154, 'Environnement', 'AUTONOME_PLUS', 54),
(155, 'Information', 'AUTONOME_PLUS', 54),
(156, 'Préliminaire', 'AUTONOME', 55),
(157, 'Analyse', 'AUTONOME', 56),
(158, 'Méthodes', 'AUTONOME', 56),
(159, 'Adhésion', 'AUTONOME', 56),
(160, 'Auto-évaluation', 'AUTONOME_PLUS', 56),
(161, 'Problèmes complexes', 'AUTONOME_PLUS', 56),
(162, 'Fonctionnement', 'AUTONOME', 57),
(163, 'Projet', 'AUTONOME', 57),
(164, 'Environnement', 'AUTONOME_PLUS', 57),
(165, 'Information', 'AUTONOME_PLUS', 57),
(166, 'Préliminaire', 'AUTONOME', 58),
(167, 'Analyse', 'DEBUTANT', 59),
(168, 'Méthodes', 'AUTONOME', 59),
(169, 'Adhésion', 'DEBUTANT', 59),
(170, 'Auto-évaluation', 'AUTONOME', 59),
(171, 'Problèmes complexes', 'AUTONOME', 59),
(172, 'Fonctionnement', 'AUTONOME', 60),
(173, 'Projet', 'AUTONOME', 60),
(174, 'Environnement', 'AUTONOME', 60),
(175, 'Information', 'AUTONOME_PLUS', 60),
(176, 'Préliminaire', 'AUTONOME', 61),
(177, 'Analyse', 'DEBUTANT', 62),
(178, 'Méthodes', 'DEBUTANT', 62),
(179, 'Adhésion', 'AUTONOME', 62),
(180, 'Auto-évaluation', 'AUTONOME', 62),
(181, 'Problèmes complexes', 'AUTONOME', 62),
(182, 'Fonctionnement', 'AUTONOME', 63),
(183, 'Projet', 'AUTONOME', 63),
(184, 'Environnement', 'AUTONOME', 63),
(185, 'Information', 'AUTONOME', 63),
(186, 'Préliminaire', 'AUTONOME', 64),
(187, 'Analyse', 'AUTONOME', 65),
(188, 'Méthodes', 'AUTONOME', 65),
(189, 'Adhésion', 'AUTONOME', 65),
(190, 'Auto-évaluation', 'AUTONOME', 65),
(191, 'Problèmes complexes', 'AUTONOME_PLUS', 65),
(192, 'Fonctionnement', 'AUTONOME', 66),
(193, 'Projet', 'AUTONOME_PLUS', 66),
(194, 'Environnement', 'AUTONOME_PLUS', 66),
(195, 'Information', 'AUTONOME_PLUS', 66),
(196, 'Préliminaire', 'AUTONOME', 67);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `implication` enum('BONNE','DEPASSE_OBJECTIFS','JUSTE_NECESSAIRE','PARESSEUX','TRES_FORTE') DEFAULT NULL,
  `observations` varchar(255) DEFAULT NULL,
  `ouverture` enum('BONNE','EXCELLENTE','ISOLE_OU_EN_OPPOSITION','RENFERME_OU_OBTUS','TRES_BONNE') DEFAULT NULL,
  `qualite_productions` enum('ACCEPTABLE','BONNE','MEDIOCRE','TRES_BONNE','TRES_PROFESSIONNELLE') DEFAULT NULL,
  `appreciation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdx4fp1ftlo7hdgwcduo6od28w` (`appreciation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Contenu de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `implication`, `observations`, `ouverture`, `qualite_productions`, `appreciation_id`) VALUES
(1, 'BONNE', 'Bon travail en équipe', 'TRES_BONNE', 'ACCEPTABLE', 1),
(2, 'BONNE', 'Bon travail en équipe', 'TRES_BONNE', 'ACCEPTABLE', 1),
(3, 'BONNE', 'Bon travail en équipe', 'TRES_BONNE', 'ACCEPTABLE', NULL),
(4, 'BONNE', 'Bon travail en équipe', 'BONNE', 'ACCEPTABLE', NULL),
(5, 'BONNE', 'Bon travail en équipe', 'TRES_BONNE', 'ACCEPTABLE', 2),
(6, 'BONNE', 'Bonne implication', 'TRES_BONNE', 'ACCEPTABLE', 3),
(7, 'BONNE', 'Travail satisfaisant dans l''ensemble', 'TRES_BONNE', 'ACCEPTABLE', 4),
(8, 'BONNE', 'Stagiaire motivé et appliqué.', 'TRES_BONNE', 'TRES_BONNE', 5),
(9, 'BONNE', 'Très bon travail', 'TRES_BONNE', 'ACCEPTABLE', 6),
(10, 'BONNE', 'Très bon travail', 'TRES_BONNE', 'ACCEPTABLE', 7),
(11, 'BONNE', 'Travail globalement satisfaisant avec une bonne implication.', 'TRES_BONNE', 'ACCEPTABLE', 8),
(12, 'PARESSEUX', 'tréééés bien', 'BONNE', 'BONNE', 10),
(13, 'PARESSEUX', 'tréééés bien', 'BONNE', 'BONNE', 11),
(14, 'PARESSEUX', 'tréééés bien', 'BONNE', 'BONNE', 9),
(15, 'BONNE', 'jjjjjjj', 'BONNE', 'TRES_BONNE', 12),
(16, 'TRES_FORTE', 'olalala', 'TRES_BONNE', 'TRES_BONNE', 13),
(17, 'PARESSEUX', 'nninini', 'BONNE', 'BONNE', 14),
(18, 'PARESSEUX', 'wiwiwi', 'BONNE', 'BONNE', 15),
(19, 'PARESSEUX', 'nininini', 'BONNE', 'BONNE', 16),
(20, 'PARESSEUX', 'qfqereg', 'BONNE', 'BONNE', 17),
(21, 'TRES_FORTE', 'zefef', 'TRES_BONNE', 'TRES_BONNE', 18),
(22, 'TRES_FORTE', 'zmgozKK', 'TRES_BONNE', 'TRES_BONNE', 19),
(23, 'TRES_FORTE', 'NJNJN.K?', 'TRES_BONNE', 'TRES_PROFESSIONNELLE', 20),
(24, 'TRES_FORTE', 'kjkjljl', 'TRES_BONNE', 'TRES_PROFESSIONNELLE', 21),
(25, 'TRES_FORTE', 'LLL', 'TRES_BONNE', 'TRES_BONNE', 22),
(26, 'PARESSEUX', 'kkll', 'BONNE', 'BONNE', 23),
(27, 'TRES_FORTE', 'zzllz', 'TRES_BONNE', 'TRES_BONNE', 24);

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

CREATE TABLE IF NOT EXISTS `periode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `stage_id` bigint(20) DEFAULT NULL,
  `stagiaire_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb3ek6gjpfcwer5ot8i0g3l36b` (`stage_id`),
  KEY `FK4aqq4ty2s31uw517oh60fsasb` (`stagiaire_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Contenu de la table `periode`
--

INSERT INTO `periode` (`id`, `date_debut`, `date_fin`, `stage_id`, `stagiaire_id`) VALUES
(1, '2025-04-01', '2025-06-30', 1, 2),
(2, '2025-04-01', '2025-06-30', 2, 3),
(3, '2025-06-01', '2025-12-01', 3, 6),
(4, '2025-06-01', '2025-12-01', 4, 7),
(5, '2025-06-01', '2025-12-01', 5, 8),
(6, '2025-04-01', '2025-06-30', NULL, 11),
(7, '2025-04-01', '2025-06-30', 6, 13),
(8, '2025-04-01', '2025-06-30', 7, 15),
(9, '2025-04-01', '2025-06-30', 8, 17),
(10, '2025-04-01', '2025-06-30', 9, 19),
(11, '2025-05-01', '2025-06-01', 12, 24),
(12, '2025-05-01', '2025-06-01', 10, 23),
(13, '2025-05-01', '2025-06-01', 11, 25),
(14, '2025-05-25', '2025-07-18', 13, 27),
(15, '2025-05-01', '2025-06-01', 14, 29),
(16, '2025-05-01', '2025-06-01', 15, 29),
(17, '2025-04-29', '2025-05-30', 16, 31),
(18, '2025-04-17', '2025-05-30', 17, 32),
(19, '2025-04-17', '2025-06-06', 18, 34),
(20, '2025-04-11', '2025-06-06', 19, 36),
(21, '2025-04-11', '2025-06-18', 20, 38),
(22, '2025-04-01', '2025-06-18', 21, 39),
(23, '2025-04-01', '2025-06-18', 22, 39),
(24, '2025-04-01', '2025-06-18', 23, 39),
(25, '2025-03-31', '2025-06-18', 24, 41),
(26, '2025-03-31', '2025-07-01', 25, 43);

-- --------------------------------------------------------

--
-- Structure de la table `periode_tuteur`
--

CREATE TABLE IF NOT EXISTS `periode_tuteur` (
  `periode_id` bigint(20) NOT NULL,
  `tuteur_id` bigint(20) NOT NULL,
  KEY `FK4qoni7ei486b36pcteyw99mcq` (`tuteur_id`),
  KEY `FKtg2f8sa11w20byojycl6am89j` (`periode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `periode_tuteur`
--

INSERT INTO `periode_tuteur` (`periode_id`, `tuteur_id`) VALUES
(1, 1),
(2, 1),
(2, 5),
(3, 1),
(4, 1),
(5, 1),
(5, 9),
(6, 10),
(7, 12),
(8, 14),
(9, 16),
(10, 18),
(11, 20),
(13, 21),
(12, 22),
(14, 26),
(15, 28),
(16, 28),
(17, 30),
(18, 30),
(19, 33),
(20, 35),
(21, 37),
(22, 37),
(23, 37),
(24, 37),
(25, 40),
(26, 42);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `email`, `nom`, `prenom`) VALUES
(1, 'ahmed@example.com', 'BOUCHRA', 'Ahmed'),
(2, 'ahmed@example.com', 'BOUCHRA', 'Ahmed'),
(3, 'fahd@example.com', 'Fahd', 'Benali'),
(4, 'ahmed@example.com', 'BOUCHRA', 'Ahmed'),
(5, 'ahmed@example.com', 'BOUCHRA', 'lili'),
(6, 'john.doe@example.com', 'John', 'Doe'),
(7, 'john.doe@example.com', 'John', 'Doe'),
(8, 'john.doe@example.com', 'John', 'Doe'),
(9, 'alice.smith@example.com', 'Alice', 'Smith'),
(10, NULL, NULL, NULL),
(11, NULL, NULL, NULL),
(12, NULL, NULL, NULL),
(13, NULL, NULL, NULL),
(14, NULL, NULL, NULL),
(15, NULL, NULL, NULL),
(16, NULL, NULL, NULL),
(17, NULL, NULL, NULL),
(18, 'john.doe@example.com', 'John', 'Doe'),
(19, 'alice.smith@example.com', 'Alice', 'Smith'),
(20, 'tuteur@example.com', 'zerktouni', 'yassine'),
(21, 'tuteur@example.com', 'zerktouni', 'yassine'),
(22, 'tuteur@example.com', 'zerktouni', 'yassine'),
(23, 'john@example.com', 'ZERKTOUNI', 'Roqia'),
(24, 'john@example.com', 'ZERKTOUNI', 'Roqia'),
(25, 'john@example.com', 'ZERKTOUNI', 'Roqia'),
(26, 'tuteur@example.com', 'jjjjjjj', 'jjjjj'),
(27, 'john@example.com', 'salmoun', 'rim'),
(28, 'tuteur@example.com', 'zerktouni', 'roqia'),
(29, 'john@example.com', 'BOUJAD', 'Fati'),
(30, 'tuteur@example.com', 'zerktouni', 'nezha'),
(31, 'john@example.com', 'Bojnane', 'nouhaila'),
(32, 'john@example.com', 'Bojnane', 'badr'),
(33, 'tuteur@example.com', 'zerktouni', 'kamal'),
(34, 'john@example.com', 'Bojnane', 'hajar'),
(35, 'tuteur@example.com', 'zerktouni', 'abdo'),
(36, 'john@example.com', 'Bojnan', 'hajar'),
(37, 'tuteur@example.com', 'zerktouni', 'simo'),
(38, 'john@example.com', 'Bojnani', 'Rim'),
(39, 'john@example.com', 'Bojnani', 'Rima'),
(40, 'tuteur@example.com', 'zerktouni', 'reda'),
(41, 'john@example.com', 'Bojnanino', 'Rima'),
(42, 'tuteur@example.com', 'zerktouni', 'badr'),
(43, 'john@example.com', 'dari', 'Rim');

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

CREATE TABLE IF NOT EXISTS `stage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `entreprise` varchar(255) DEFAULT NULL,
  `objectif` varchar(255) DEFAULT NULL,
  `stagiaire_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeeyluj04qr2r6mkkr9wf4exx1` (`stagiaire_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

--
-- Contenu de la table `stage`
--

INSERT INTO `stage` (`id`, `description`, `entreprise`, `objectif`, `stagiaire_id`) VALUES
(1, 'Deep learning model', 'oracle', 'améliorer les compétences', NULL),
(2, 'Deep learning model', 'oracle', 'améliorer les compétences', NULL),
(3, 'Développement logiciel', 'Tech Corp', 'Créer une application web', 6),
(4, 'Développement logiciel', 'Tech Corp', 'Créer une application web', 7),
(5, 'Développement logiciel', 'Tech Corp', 'Créer une application web', 8),
(6, NULL, 'Capgemini', NULL, NULL),
(7, 'Développement web fullstack', 'Capgemini', 'Créer une application de gestion', NULL),
(8, 'Développement web fullstack', 'Capgemini', 'Créer une application de gestion', 17),
(9, 'Développement d''une application mobile de gestion de stages.', 'Tech Corp', 'Mettre en œuvre les compétences en développement mobile.', 19),
(10, 'nininin', 'ninni', ',o,o,o', 23),
(11, 'nininin', 'ninni', ',o,o,o', 25),
(12, 'nininin', 'ninni', ',o,o,o', 24),
(13, 'jjjjjjj', 'orange', 'jjjjjj', 27),
(14, 'olalala', 'ocp', 'olalala', 29),
(15, 'nininin', 'ocp', 'ninini', 29),
(16, 'wiwiwiw', 'nestlet', 'wiwiwi', 31),
(17, 'niniin', 'nestlet', 'clc;l;ckz', 32),
(18, 'niniin', 'nestlet', 'qpqprpmrp', 34),
(19, 'frgfgdf', 'nestlet', 'zefefaefa', 36),
(20, 'azdfl', 'bimo', 'fozef', 38),
(21, 'ILHLKHK', 'BIM', 'GHCDGJFJ', 39),
(22, 'kll', 'liil', ',k,l,l', 39),
(23, 'LLLL', 'LLL', 'MMMM', 39),
(24, 'okk', 'pipi', 'oko', 41),
(25, 'ndnak,dk', 'oracle', 'klskld', 43);

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE IF NOT EXISTS `stagiaire` (
  `institution` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `stagiaire`
--

INSERT INTO `stagiaire` (`institution`, `id`) VALUES
('FSSM', 2),
('FST', 3),
('Université de Paris', 6),
('Université de Paris', 7),
('Université de Paris', 8),
(NULL, 11),
(NULL, 13),
(NULL, 15),
(NULL, 17),
('Université de Paris', 19),
('FST', 23),
('FST', 24),
('FST', 25),
('FST', 27),
('FST', 29),
('FST', 31),
('FST', 32),
('FST', 34),
('FST', 36),
('FST', 38),
('FST', 39),
('FST', 41),
('FST', 43);

-- --------------------------------------------------------

--
-- Structure de la table `tuteur`
--

CREATE TABLE IF NOT EXISTS `tuteur` (
  `entreprise` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tuteur`
--

INSERT INTO `tuteur` (`entreprise`, `id`) VALUES
('oracle', 1),
(NULL, 4),
('ENSA', 5),
('Tech Corp', 9),
(NULL, 10),
(NULL, 12),
(NULL, 14),
(NULL, 16),
('Tech Corp', 18),
('ninni', 20),
('ninni', 21),
('ninni', 22),
('orange', 26),
('ocp', 28),
('nestlet', 30),
('nestlet', 33),
('nestlet', 35),
('bimo', 37),
('pipi', 40),
('oracle', 42);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appreciation`
--
ALTER TABLE `appreciation`
  ADD CONSTRAINT `FK12oq3vrrpgt7w07pr7n7iyhsc` FOREIGN KEY (`tuteur_id`) REFERENCES `tuteur` (`id`),
  ADD CONSTRAINT `FKlql6wnbwtnj5eddbhfid1h0n5` FOREIGN KEY (`periode_id`) REFERENCES `periode` (`id`);

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `FKcmhg0ig7wdsgnwc13jdoat435` FOREIGN KEY (`appreciation_id`) REFERENCES `appreciation` (`id`);

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `FK5cffemei14qbftr4etpo209su` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FKdx4fp1ftlo7hdgwcduo6od28w` FOREIGN KEY (`appreciation_id`) REFERENCES `appreciation` (`id`);

--
-- Contraintes pour la table `periode`
--
ALTER TABLE `periode`
  ADD CONSTRAINT `FK4aqq4ty2s31uw517oh60fsasb` FOREIGN KEY (`stagiaire_id`) REFERENCES `stagiaire` (`id`),
  ADD CONSTRAINT `FKb3ek6gjpfcwer5ot8i0g3l36b` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`);

--
-- Contraintes pour la table `periode_tuteur`
--
ALTER TABLE `periode_tuteur`
  ADD CONSTRAINT `FK4qoni7ei486b36pcteyw99mcq` FOREIGN KEY (`tuteur_id`) REFERENCES `tuteur` (`id`),
  ADD CONSTRAINT `FKtg2f8sa11w20byojycl6am89j` FOREIGN KEY (`periode_id`) REFERENCES `periode` (`id`);

--
-- Contraintes pour la table `stage`
--
ALTER TABLE `stage`
  ADD CONSTRAINT `FKeeyluj04qr2r6mkkr9wf4exx1` FOREIGN KEY (`stagiaire_id`) REFERENCES `stagiaire` (`id`);

--
-- Contraintes pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD CONSTRAINT `FK93br8nw221k0exgyp84r6g7jj` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `tuteur`
--
ALTER TABLE `tuteur`
  ADD CONSTRAINT `FKem32wa3yoihe8on0w7c8g23w2` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);
