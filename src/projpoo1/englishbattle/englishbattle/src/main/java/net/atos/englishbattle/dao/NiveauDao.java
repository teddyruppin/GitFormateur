package net.atos.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import net.atos.englishbattle.business.Niveau;

public interface NiveauDao {

	/**
	 * La méthode se nomme create
	 * Elle prend un paramètre un objet de type Niveau
	 * et le rôle de cette méthode est de créer
	 * un enregistrement dans la table Niveau de la base MySQL
	 * englishbattle
	 * Autrement dit le rôle de cette méthode est de rendre
	 * l'objet de type Niveau persistant
	 * 
	 * Elle renvoit un objet de type Niveau
	 * En cas de problème avec MySQL, la méthode lève
	 * une exception de type SQLException
	 * 
	 * @param niveau
	 * @return
	 * @throws SQLException
	 */
	Niveau create(Niveau niveau) throws SQLException;
	
	List<Niveau> findAll() throws SQLException;
	
	Niveau findOne(Long id) throws SQLException;
}
