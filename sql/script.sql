SET AUTOCOMMIT = 0;

DROP DATABASE gestiongarage;

START TRANSACTION;


CREATE DATABASE IF NOT EXISTS gestiongarage;



--
-- Structure de la table `commandePiece`
--

CREATE TABLE IF NOT EXISTS `CommandePiece` (
	`idCommandeP` int(10) NOT NULL AUTO_INCREMENT,
	`quantite` int(100) DEFAULT NULL,
	`prixHT` decimal(10,2) DEFAULT NULL,
	`valide` boolean DEFAULT FALSE,
	`idPieces` int(10) NOT NULL,
	PRIMARY KEY (`idCommandeP`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `r_piece_stock`
--

CREATE TABLE IF NOT EXISTS `r_piece_stock` (
	`idStockPieces` int(10) NOT NULL ,
	`idPiece` int(10) NOT NULL ,
	CONSTRAINT r_piece_stock1 PRIMARY KEY (`idStockPieces`, `idPiece`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Structure de la table `stockPiece`
--

CREATE TABLE IF NOT EXISTS `stockPieces` (
	`idStockPieces` int(10) NOT NULL AUTO_INCREMENT,
	`quantite` int(1000) DEFAULT,
	PRIMARY KEY (`idStockPieces`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `piece`
--

CREATE TABLE IF NOT EXISTS `piece` (
	`idPiece` int(10) NOT NULL AUTO_INCREMENT,
	`nomPiece` char(100) DEFAULT NULL,
	`quantite` int(1000) DEFAULT NULL,
	`prixHT` decimal(10,2) DEFAULT NULL,
	`idFiche` int(10) NOT NULL,
	PRIMARY KEY (`idPiece`),
	KEY `piece_1` (`idFiche`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;





-- 
-- Structure de la table `fiche` 
--

CREATE TABLE IF NOT EXISTS `fiche` (
	`idFiche` int(12) NOT NULL AUTO_INCREMENT,
	`description` char(60) DEFAULT NULL,
	`ficheValidee` boolean DEFAULT FALSE,
	`ficheCloture` boolean DEFAULT FALSE,
	`niveaupriorite` char(15) DEFAULT NULL,
	`idFactureFiche` int(60) DEFAULT NULL,
	PRIMARY KEY (`idFiche`)
) 	ENGINE=InnoDB DEFAULT CHARSET=latin1;	


-- 
-- Structure de la table `factureFiche` 
--

CREATE TABLE IF NOT EXISTS `factureFiche` (
	`idFactureFiche` int(12) NOT NULL AUTO_INCREMENT,
	`sommeGlobale` float(10,2) DEFAULT NULL,
	`detail` varchar(500) DEFAULT NULL,
	`dateFacture` date DEFAULT NULL,
	`tauxTVA` float(15) DEFAULT NULL,
	PRIMARY KEY (`idFactureFiche`)
) 	ENGINE=InnoDB DEFAULT CHARSET=latin1;	



--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
	`idClient` int(12) NOT NULL AUTO_INCREMENT,
	`nom` char(60) DEFAULT NULL,
	`prenom` char(60) DEFAULT NULL,
	`adresse` char(60) DEFAULT NULL,
	`codepostal` char(5) DEFAULT NULL,
	`telephone` char(60) DEFAULT NULL,
	`mobile` char(60) DEFAULT NULL,
	`createurFiche` char(15) DEFAULT NULL,
	`idDevis` int(15) DEFAULT NULL,
	`idFiche` int(15) DEFAULT NULL,
	PRIMARY KEY (`idClient`)
) 	ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- 
-- Structure de la table `devis` 
--

CREATE TABLE IF NOT EXISTS `devis` (
	`idDevis` int(12) NOT NULL AUTO_INCREMENT,
	`idFactureDevis` int(60) DEFAULT NULL,
	`devisValide` boolean DEFAULT FALSE,
	PRIMARY KEY (`idDevis`)
) 	ENGINE=InnoDB DEFAULT CHARSET=latin1;	


-- 
-- Structure de la table `factureDevis` 
--

CREATE TABLE IF NOT EXISTS `factureDevis` (
	`idFactureDevis` int(12) NOT NULL AUTO_INCREMENT,
	`sommeGlobale` float(10,2) DEFAULT NULL,
	`detail` varchar(500) DEFAULT NULL,
	`dateDevis` date DEFAULT NULL,
	`tauxTVA` float(15) DEFAULT NULL,
	PRIMARY KEY (`idFactureDevis`)
) 	ENGINE=InnoDB DEFAULT CHARSET=latin1;	




--
-- Structure de la table `voiture`
--

CREATE TABLE IF NOT EXISTS `voiture` (
	`idVoiture` int(10) NOT NULL AUTO_INCREMENT,
	`marque` char(100) DEFAULT NULL,
	`modele` char(100) DEFAULT NULL,
	`quantite` int(1000) DEFAULT NULL,
	`prixHT` decimal(10,2) DEFAULT NULL,
	`idDevis` int(10) NOT NULL,
	PRIMARY KEY (`idVoiture`),
	KEY `voiture_1` (`idDevis`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;






--
-- Structure de la table `commandeVoiture`
--

CREATE TABLE IF NOT EXISTS `commandeVoiture` (
	`idCommandeV` int(10) NOT NULL AUTO_INCREMENT,
	`quantite` int(1000) DEFAULT NULL,
	`prixHT` decimal(10,2) DEFAULT NULL,
	`idVoiture` int(10) NOT NULL,
	PRIMARY KEY (`idCommandeV`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `r_voiture_stock`
--

CREATE TABLE IF NOT EXISTS `r_voiture_stock` (
	`idStockVoitures` int(10) NOT NULL ,
	`idVoiture` int(10) NOT NULL ,
	CONSTRAINT r_voiture_stock1 PRIMARY KEY (`idStockVoiture`, `idVoiture`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Structure de la table `stockVoiture`
--

CREATE TABLE IF NOT EXISTS `stockVoiture` (
	`idStockVoitures` int(10) NOT NULL AUTO_INCREMENT,
	`quantite` int(1000) DEFAULT,
	PRIMARY KEY (`idStockVoitures`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `tache`
--

CREATE TABLE IF NOT EXISTS `tache` (
	`idTache` int(10) NOT NULL AUTO_INCREMENT,
	`idFiche` int(10) NOT NULL,
	`tacheTerminee` boolean DEFAULT FALSE,
	PRIMARY KEY (`idTache`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
	`isUser` int(10) NOT NULL AUTO_INCREMENT,
	`nom` int(10)DEFAULT NULL,
	`prenom` int(20) DEFAULT NULL,
	`idTache` int(10) NOT NULL,
	`idDevis` int(10) NOT NULL,
	`bloque` boolean DEFAULT FALSE,
	PRIMARY KEY (`isUser`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Structure de la table `r_user_p`
--

CREATE TABLE IF NOT EXISTS `r_user_p` (
	`isUser` int(10) NOT NULL ,
	`idProfil` int(10) NOT NULL ,
	CONSTRAINT r_user_p1 PRIMARY KEY (`isUser`, `idProfil`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
	`idProfil` int(10) NOT NULL AUTO_INCREMENT,
	`typeProfil` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`idProfil`)
)	ENGINE=InnoDB DEFAULT CHARSET=latin1;




--
-- Contraintes pour la table `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `piece_1` FOREIGN KEY 
  (`idFiche`) REFERENCES `fiche` (`idFiche`);
  
--
-- Contraintes pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD CONSTRAINT `voiture_1` FOREIGN KEY 
  (`idDevis`) REFERENCES `devis` (`idDevis`);
  
  
--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
	FOREIGN KEY (`idDevis`) REFERENCES `devis` (`idDevis`);
  
ALTER TABLE `client` 
	FOREIGN KEY (`idFiche`) REFERENCES `fiche` (`idFiche`);
	
	
	
--
-- Contraintes pour la table `commandePiece`
--
ALTER TABLE `commandePiece`
	FOREIGN KEY (`idPieces`) REFERENCES `piece` (`idPiece`);
	
	
--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
	FOREIGN KEY (`idFiche`) REFERENCES `fiche` (`idFiche`);

--
-- Contraintes pour la table `fiche`
--
ALTER TABLE `fiche`
	FOREIGN KEY (`idFactureFiche`) REFERENCES `factureFiche` (`idFactureFiche`);
	
	
--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
	FOREIGN KEY (`idTache`) REFERENCES `tache` (`idTache`);

ALTER TABLE `users`
	FOREIGN KEY (`idDevis`) REFERENCES `devis` (`idDevis`);

	
--
-- Contraintes pour la table `commandePiece`
--
ALTER TABLE `commandePiece`
	FOREIGN KEY (`idPieces`) REFERENCES `piece` (`idPiece`);	
	
	
--
-- Contraintes pour la table `devis`
--
ALTER TABLE `devis`
	FOREIGN KEY (`idFactureDevis`) REFERENCES `factureDevis` (`idFactureDevis`);
	
	
--
-- Contraintes pour la table `voiture`
--
ALTER TABLE `voitures`
	FOREIGN KEY (`idDevis`) REFERENCES `devis` (`idDevis`);	
	
	
--
-- Contraintes pour la table `commandeVoiture`
--
ALTER TABLE `commandeVoiture`
	FOREIGN KEY (`idVoiture`) REFERENCES `voitures` (`idVoiture`);
	
	
	
COMMIT;	
	