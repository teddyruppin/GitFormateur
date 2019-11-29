package projpoo1.GestionPersonnes;

import java.util.List;

import projpoo1.GestionCommande.Achat;

public interface IClient {
	
	public void achete(List<Achat> achat);
	public void paie();
	public boolean estClient();

}
