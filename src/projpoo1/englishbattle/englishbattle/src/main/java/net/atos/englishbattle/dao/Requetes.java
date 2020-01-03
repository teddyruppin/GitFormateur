package net.atos.englishbattle.dao;

public class Requetes {

	// Partie

	public static final String AJOUT_PARTIE = "INSERT INTO Partie (joueur_id) VALUES (?)";

	public static final String TOUTES_LES_PARTIES = "SELECT id, joueur_id FROM Partie";

	public static final String PARTIE_PAR_ID = "SELECT id, joueur_id FROM Partie WHERE id=?";

	// Niveau

	public static final String AJOUT_NIVEAU = "INSERT INTO Niveau (nom) VALUES (?)";

	public static final String TOUS_LES_NIVEAUX = "SELECT id, nom FROM Niveau ORDER BY id";

	public static final String NIVEAU_PAR_ID = "SELECT id, nom FROM Niveau WHERE id=?";

	// Joueur

	public static final String TOUS_LES_JOUEURS = "SELECT id, pseudo, email, motDePasse, niveau_id FROM Joueur";

	public static final String JOUEUR_PAR_ID = "SELECT id, pseudo, email, motDePasse, niveau_id FROM Joueur WHERE id=?";

	public static final String AJOUT_JOUEUR = "INSERT INTO Joueur(pseudo, email, motDePasse, niveau_id) VALUES (?, ?, ?, ?)";

	// Question

	public static final String TOUTES_LES_QUESTIONS = "SELECT id, dateEnvoi, dateReponse, reponseParticipePasse, reponsePreterit, affichePreterit, partie_id, verbe_id FROM Question";

	public static final String QUESTION_PAR_ID = "SELECT id, dateEnvoi, dateReponse, reponseParticipePasse, reponsePreterit, affichePreterit, partie_id, verbe_id FROM Question WHERE id=?";

	public static final String QUESTION_PAR_PARTIE_ID = "SELECT id, dateEnvoi, dateReponse, reponseParticipePasse, reponsePreterit, affichePreterit, partie_id, verbe_id FROM Question WHERE partie_id=?";

	public static final String AJOUT_QUESTION = "INSERT INTO Question (dateEnvoi, partie_id, verbe_id, affichePreterit) VALUES (now(), ?, ?, ?)";

	public static final String MAJ_QUESTION = "UPDATE Question SET dateReponse=?, reponsePreterit=?, reponseParticipePasse=? WHERE id=?";
	
	// Verbe

	public static final String AJOUT_VERBE = "INSERT INTO Verbe (baseVerbale, participePasse, preterit, traduction) VALUES (?, ?, ?, ?)";

	public static final String TOUS_LES_VERBES = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM Verbe";

	public static final String VERBE_ALEATOIRE = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM Verbe ORDER BY rand() LIMIT 1";

	public static final String VERBE_PAR_ID = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM Verbe WHERE id=?";
	
	
	
	// Requetes exercices
	
	public static final String LISTE_JOUEURS = "SELECT joueur_id, pseudo, email, niveau.id, niveau.nom, COUNT(partie.id) FROM joueur, partie, niveau WHERE joueur.id = partie.joueur_id AND niveau.id = joueur.niveau_id GROUP BY joueur_id";

}