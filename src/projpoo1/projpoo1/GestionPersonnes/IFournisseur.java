package projpoo1.GestionPersonnes;

import java.util.List;

import projpoo1.GestionCommande.Commande;

public interface IFournisseur {
	
	public boolean livre();
	public void commande(List<Commande> commande);
	public boolean estFournisseur();	
}
