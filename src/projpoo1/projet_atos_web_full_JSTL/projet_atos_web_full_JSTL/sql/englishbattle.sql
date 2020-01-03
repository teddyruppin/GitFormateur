-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 03 oct. 2019 à 03:16
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `englishbattle`
--
CREATE DATABASE IF NOT EXISTS `englishbattle` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `englishbattle`;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE `joueur` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `pseudo` varchar(255) DEFAULT NULL,
  `niveau_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `joueur`
--

INSERT INTO `joueur` (`id`, `email`, `motDePasse`, `pseudo`, `niveau_id`) VALUES
(1, NULL, 'toto', 'cge', 1),
(2, NULL, 'titi', 'toto', 1),
(3, 'toto@fr.net', 'titi', 'toto', 1),
(4, 'cge2@fg.net', 'toto', 'cge2', 3);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE `niveau` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'Débutant'),
(2, 'Intermédiaire'),
(3, 'Expert');

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

DROP TABLE IF EXISTS `partie`;
CREATE TABLE `partie` (
  `id` bigint(20) NOT NULL,
  `joueur_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `partie`
--

INSERT INTO `partie` (`id`, `joueur_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL,
  `affichePreterit` bit(1) DEFAULT NULL,
  `dateEnvoi` datetime DEFAULT NULL,
  `dateReponse` datetime DEFAULT NULL,
  `reponseParticipePasse` varchar(255) DEFAULT NULL,
  `reponsePreterit` varchar(255) DEFAULT NULL,
  `partie_id` bigint(20) DEFAULT NULL,
  `verbe_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id`, `affichePreterit`, `dateEnvoi`, `dateReponse`, `reponseParticipePasse`, `reponsePreterit`, `partie_id`, `verbe_id`) VALUES
(1, b'1', '2019-08-23 05:39:29', '2019-08-23 05:39:57', NULL, NULL, 1, 2),
(2, b'0', '2019-08-28 03:36:26', '2019-08-28 03:36:33', NULL, NULL, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `verbe`
--

DROP TABLE IF EXISTS `verbe`;
CREATE TABLE `verbe` (
  `id` bigint(20) NOT NULL,
  `baseVerbale` varchar(255) DEFAULT NULL,
  `participePasse` varchar(255) DEFAULT NULL,
  `preterit` varchar(255) DEFAULT NULL,
  `traduction` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `verbe`
--

INSERT INTO `verbe` (`id`, `baseVerbale`, `participePasse`, `preterit`, `traduction`) VALUES
(1, 'cast', 'cast', 'cast', 'jeter, lancer'),
(2, 'cut', 'cut', 'cut', 'couper');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_lb1s5xv65691p62nrc5t5xgje` (`email`),
  ADD KEY `FKcpjvo1jijb7r3lkfvstn8giv9` (`niveau_id`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt39vhifbvj2ods6y2yckro7bj` (`joueur_id`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2ygknjb3g59ty3fqrpyh0dkue` (`partie_id`),
  ADD KEY `FKhvqcqpbxbewcd19cnpec4iqlh` (`verbe_id`);

--
-- Index pour la table `verbe`
--
ALTER TABLE `verbe`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h0dv0b7vku0d6p51xxn0af0is` (`baseVerbale`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `verbe`
--
ALTER TABLE `verbe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
