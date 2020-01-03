package test;

import java.io.*;
import java.awt.*;
import javax.swing.*;

public class TestSerialisation {
	
	private final static Reader reader = new InputStreamReader(System.in);
	private final static BufferedReader keyboard = new BufferedReader(reader);
		// TODO Auto-generated method stub
		// System.out.println("test");


		// Permet de créer une fenêtre est de la sérialiser dans un fichier.
		
		
		public void saveWindow() throws IOException {
			
		JFrame window = new JFrame("Ma fenêtre");
		JPanel pane = (JPanel)window.getContentPane();
		pane.add(new JLabel("Barre de status"), BorderLayout.SOUTH);
		pane.add(new JTree(), BorderLayout.WEST);
		JTextArea textArea = new JTextArea("Ceci est le contenu !!!");
		textArea.setBackground(Color.GRAY);
		pane.add(textArea, BorderLayout.CENTER);
		JPanel toolbar = new JPanel(new FlowLayout());
		toolbar.add(new JButton("Open"));
		toolbar.add(new JButton("Save"));
		toolbar.add(new JButton("Cut"));
		toolbar.add(new JButton("Copy"));
		toolbar.add(new JButton("Paste"));
		pane.add(toolbar, BorderLayout.NORTH);
		window.setSize(400,300);
		FileOutputStream fos = new FileOutputStream("window.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(window);
		oos.flush();
		oos.close();
		}
	
	
	
	// Permet de reconstruire la fenêtre à partir des données du fichier.
		
	public void loadWindow() throws Exception {
	FileInputStream fis = new FileInputStream("window.ser");
	ObjectInputStream ois = new ObjectInputStream(fis);
	JFrame window = (JFrame)ois.readObject();
	ois.close();
	window.setVisible(true);
	}
	// Permet de saisir différentes commandes. Testez plusieurs load
	// consécutifs : plusieurs fenêtres doivent apparaîtrent
	
	public static void main(String[] args) throws Exception {
		
	TestSerialisation object = new TestSerialisation();
	
	while(true) {
	System.out.print("Saisir le mode d'execution (load ou save) : ");
	String mode = keyboard.readLine();
	if (mode.equalsIgnoreCase("exit")) break;
	if (mode.equalsIgnoreCase("save")) object.saveWindow();
	if (mode.equalsIgnoreCase("load")) object.loadWindow();
	}
	System.exit(0);
	}
}


