package projet_atos_web.app;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Outil {
	
	public static String getDatefr() {
		Date date = new Date( );
		// Créer une instance de dateFormat
		DateFormat format = DateFormat.getInstance( );
		// Afficher la date en format par défaut
		System.out.println(format.format(date));
		// définir un format personnalisé(France
		DateFormat format_fr =
		DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
		
		return format_fr.format(date);
	}
	public static String getHeurefr() {
		Date date = new Date( );
		DateFormat format_fr =
		DateFormat.getTimeInstance(DateFormat.DATE_FIELD, Locale.FRENCH);
		
		return format_fr.format(date);
	}

}
