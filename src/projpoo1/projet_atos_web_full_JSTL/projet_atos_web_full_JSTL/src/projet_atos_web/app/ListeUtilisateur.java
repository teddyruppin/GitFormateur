package projet_atos_web.app;
import java.util.ArrayList;
import java.util.List;
public class ListeUtilisateur {
	private List<Utilisateur> 
	utilisateurs;
	public ListeUtilisateur() {
		this.utilisateurs = new ArrayList<>();
		utilisateurs.add(
new Utilisateur("Pedro","Pedro"));
		utilisateurs.add(
new Utilisateur("Bernardo","Bernardo"));
		utilisateurs.add(
new Utilisateur("Marcelo","Marcelo"));
		utilisateurs.add(
new Utilisateur("Roberto","Roberto"));
		utilisateurs.add(
new Utilisateur("POE", "ATOS"));
	}
	public List<Utilisateur> 
	getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public void addUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}
}
