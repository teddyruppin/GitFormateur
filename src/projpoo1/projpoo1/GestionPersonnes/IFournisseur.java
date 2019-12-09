package projpoo1.GestionPersonnes;

import java.util.List;

import projpoo1.GestionAchatCommande.Commande;

public interface IFournisseur {
	
	public boolean livre();
	public void commande(List<Commande> commande);
	public boolean estFournisseur();	
}
