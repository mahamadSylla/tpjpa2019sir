-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 12 mai 2019 à 00:33
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tpjpa`
--

-- --------------------------------------------------------

--
-- Structure de la table `alergies`
--

CREATE TABLE `alergies` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `alergies`
--

INSERT INTO `alergies` (`id`, `name`, `idUser`) VALUES
(2, 'sucre', 1),
(3, 'soso', 2);

-- --------------------------------------------------------

--
-- Structure de la table `choixdate`
--

CREATE TABLE `choixdate` (
  `id` int(11) NOT NULL,
  `debut` int(11) NOT NULL,
  `fin` int(11) NOT NULL,
  `myDate` date DEFAULT NULL,
  `reponse_id` int(11) DEFAULT NULL,
  `sondage_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `choixdate`
--

INSERT INTO `choixdate` (`id`, `debut`, `fin`, `myDate`, `reponse_id`, `sondage_id`) VALUES
(1, 12, 13, '2019-03-06', 1, 1),
(2, 15, 17, '2019-03-06', 2, 2),
(3, 12, 13, '2019-03-06', 3, 1),
(4, 14, 17, '2019-03-04', 3, 1),
(5, 12, 13, '2012-12-12', 1, 1),
(6, 16, 17, '2012-12-12', 1, 2),
(7, 15, 19, '2012-12-12', 5, 1),
(8, 13, 19, '2012-12-12', NULL, 3),
(9, 0, 0, NULL, NULL, 3),
(10, 1, 3, '2019-05-02', NULL, 3),
(11, 2, 3, '2019-05-01', NULL, 3),
(12, 1, 3, '2019-05-08', NULL, NULL),
(13, 15, 17, '2012-05-02', NULL, NULL),
(14, 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `les_absences`
--

CREATE TABLE `les_absences` (
  `utilisateur_id` int(11) NOT NULL,
  `reunion_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `les_absences`
--

INSERT INTO `les_absences` (`utilisateur_id`, `reunion_id`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `les_presences`
--

CREATE TABLE `les_presences` (
  `utilisateur_id` int(11) NOT NULL,
  `reunion_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `les_presences`
--

INSERT INTO `les_presences` (`utilisateur_id`, `reunion_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `preferencealimentaire`
--

CREATE TABLE `preferencealimentaire` (
  `idParticipant` int(11) NOT NULL,
  `idReunion` int(11) NOT NULL,
  `preference` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `preferencealimentaire`
--

INSERT INTO `preferencealimentaire` (`idParticipant`, `idReunion`, `preference`) VALUES
(1, 1, 'lait chaud');

-- --------------------------------------------------------

--
-- Structure de la table `reponsesondage`
--

CREATE TABLE `reponsesondage` (
  `id` int(11) NOT NULL,
  `participant_id` int(11) DEFAULT NULL,
  `sondage_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reponsesondage`
--

INSERT INTO `reponsesondage` (`id`, `participant_id`, `sondage_id`) VALUES
(1, 2, NULL),
(2, 2, NULL),
(3, 1, 1),
(5, 2, NULL),
(6, 18, NULL),
(7, 24, NULL),
(8, 1, 2),
(9, 24, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reunion`
--

CREATE TABLE `reunion` (
  `id` int(11) NOT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `dateReunion_id` int(11) DEFAULT NULL,
  `sondage_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reunion`
--

INSERT INTO `reunion` (`id`, `intitule`, `resume`, `dateReunion_id`, `sondage_id`) VALUES
(1, 'r1', 'resume', 5, 1),
(2, 'int1', 'resumeeeeeeee', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`, `utilisateur_id`) VALUES
(1, 'r', 1),
(2, 'r1', 2),
(3, 'role2', 1);

-- --------------------------------------------------------

--
-- Structure de la table `sondage`
--

CREATE TABLE `sondage` (
  `id` int(11) NOT NULL,
  `intitule` varchar(255) DEFAULT NULL,
  `participatedWebLink` varchar(255) DEFAULT NULL,
  `createur_id` int(11) DEFAULT NULL,
  `dateRetenue_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sondage`
--

INSERT INTO `sondage` (`id`, `intitule`, `participatedWebLink`, `createur_id`, `dateRetenue_id`) VALUES
(1, 'test1', 'Link1', 1, 1),
(2, 'TEST2', 'link2', 1, 2),
(3, 'reunion test', 'link12', 2, NULL),
(4, 'La dernière ligne droite', NULL, NULL, NULL),
(5, 'L\'avant dernier gout ', 'lien sécurisé ', NULL, NULL),
(6, 'Venez assister  aux derniers moment du Doodle.', 'aller venez', NULL, NULL),
(7, 'Venez assister  aux derniers moment du Doodle. Derniers Détails ', 'aller venez', NULL, NULL),
(8, 'Les amis imaginaires', 'lien sécurisé par amitié', NULL, NULL),
(9, 'attention à la prochaine', 'attention', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `mail` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `firstName`, `mail`, `name`, `password`) VALUES
(1, 'Mahamadou', 'mahamadsylla5@gmail.com', 'SYLLA', NULL),
(2, 'kiko', 'linda@liko.com', 'Yao', NULL),
(18, 'toto', 'mimo@m.com2', 'titi', 'abcdef'),
(23, 'Mahamadou', 'mahamadsylla5@gmail.comO', 'ali', 'az'),
(24, 'mama', 'mamma@edite.com', 'Koita', '1234');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `alergies`
--
ALTER TABLE `alergies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_9pakm7dbn4e3mv12u0myl0vtc` (`idUser`);

--
-- Index pour la table `choixdate`
--
ALTER TABLE `choixdate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_n31yy0j3apmkryegk6hd64b3l` (`reponse_id`),
  ADD KEY `FK_ebnx7po9xtl5r5cel6jgou7o1` (`sondage_id`);

--
-- Index pour la table `les_absences`
--
ALTER TABLE `les_absences`
  ADD KEY `FK_qt5k7t80oc4bq3pu710t8mier` (`reunion_id`),
  ADD KEY `FK_8rxcpxksmwcs7xs62srndkfpj` (`utilisateur_id`);

--
-- Index pour la table `les_presences`
--
ALTER TABLE `les_presences`
  ADD KEY `FK_aaufma51ugda635aotg46b2hh` (`reunion_id`),
  ADD KEY `FK_reg9xi4p6a5jkmub6b39hwqim` (`utilisateur_id`);

--
-- Index pour la table `preferencealimentaire`
--
ALTER TABLE `preferencealimentaire`
  ADD PRIMARY KEY (`idParticipant`,`idReunion`);

--
-- Index pour la table `reponsesondage`
--
ALTER TABLE `reponsesondage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_rbhprj2lpypdpythwxo4t6paf` (`participant_id`),
  ADD KEY `FK_cx08ybm64ye4xr64lypyv03nl` (`sondage_id`);

--
-- Index pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_b1jd6oyyjnucymfvxrqliacln` (`dateReunion_id`),
  ADD UNIQUE KEY `UK_tb3aely09goj5nv9h3x0d0e9f` (`sondage_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_em1vc5ijplewc9d58pd4f46xv` (`utilisateur_id`);

--
-- Index pour la table `sondage`
--
ALTER TABLE `sondage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ryeweajf7yvl3hebuu6mhfkmf` (`createur_id`),
  ADD KEY `FK_hxaveseqcmpc55kq0kymxdanc` (`dateRetenue_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_htnpeqe4aruhqg5gqlgopae4i` (`mail`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `alergies`
--
ALTER TABLE `alergies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `choixdate`
--
ALTER TABLE `choixdate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `reponsesondage`
--
ALTER TABLE `reponsesondage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `reunion`
--
ALTER TABLE `reunion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `sondage`
--
ALTER TABLE `sondage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alergies`
--
ALTER TABLE `alergies`
  ADD CONSTRAINT `FK_9pakm7dbn4e3mv12u0myl0vtc` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `choixdate`
--
ALTER TABLE `choixdate`
  ADD CONSTRAINT `FK_ebnx7po9xtl5r5cel6jgou7o1` FOREIGN KEY (`sondage_id`) REFERENCES `sondage` (`id`),
  ADD CONSTRAINT `FK_n31yy0j3apmkryegk6hd64b3l` FOREIGN KEY (`reponse_id`) REFERENCES `reponsesondage` (`id`);

--
-- Contraintes pour la table `les_absences`
--
ALTER TABLE `les_absences`
  ADD CONSTRAINT `FK_8rxcpxksmwcs7xs62srndkfpj` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `FK_qt5k7t80oc4bq3pu710t8mier` FOREIGN KEY (`reunion_id`) REFERENCES `reunion` (`id`);

--
-- Contraintes pour la table `les_presences`
--
ALTER TABLE `les_presences`
  ADD CONSTRAINT `FK_aaufma51ugda635aotg46b2hh` FOREIGN KEY (`reunion_id`) REFERENCES `reunion` (`id`),
  ADD CONSTRAINT `FK_reg9xi4p6a5jkmub6b39hwqim` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `reponsesondage`
--
ALTER TABLE `reponsesondage`
  ADD CONSTRAINT `FK_cx08ybm64ye4xr64lypyv03nl` FOREIGN KEY (`sondage_id`) REFERENCES `sondage` (`id`),
  ADD CONSTRAINT `FK_rbhprj2lpypdpythwxo4t6paf` FOREIGN KEY (`participant_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `reunion`
--
ALTER TABLE `reunion`
  ADD CONSTRAINT `FK_b1jd6oyyjnucymfvxrqliacln` FOREIGN KEY (`dateReunion_id`) REFERENCES `choixdate` (`id`),
  ADD CONSTRAINT `FK_tb3aely09goj5nv9h3x0d0e9f` FOREIGN KEY (`sondage_id`) REFERENCES `sondage` (`id`);

--
-- Contraintes pour la table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FK_em1vc5ijplewc9d58pd4f46xv` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `sondage`
--
ALTER TABLE `sondage`
  ADD CONSTRAINT `FK_hxaveseqcmpc55kq0kymxdanc` FOREIGN KEY (`dateRetenue_id`) REFERENCES `choixdate` (`id`),
  ADD CONSTRAINT `FK_ryeweajf7yvl3hebuu6mhfkmf` FOREIGN KEY (`createur_id`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
