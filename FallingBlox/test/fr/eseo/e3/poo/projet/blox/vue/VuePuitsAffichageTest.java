package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsAffichageTest {

	public VuePuitsAffichageTest()
	{
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}

	private void testConstructeurPuits() 
	{
		
		JFrame frame = new JFrame("Puits");
		Puits puits = new Puits();
		VuePuits vue = new VuePuits(puits);
		
		// Enregistrement de vue comme listener de puits 
        puits.addPropertyChangeListener(vue);
		
		frame.add(vue);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	private void testConstructeurPuitsTaille() 
	{

		JFrame frame = new JFrame("Puits et taille");
		Puits puits = new Puits();
		VuePuits vue = new VuePuits(puits,40);
		VueTas vueTas = new VueTas(vue);
		
		// Enregistrement de vue comme listener de puits 
        puits.addPropertyChangeListener(vue);
       // puits.addPropertyChangeListener(vueTas);
		
		frame.add(vue);
		//frame.add(vueTas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		});
	}

}





