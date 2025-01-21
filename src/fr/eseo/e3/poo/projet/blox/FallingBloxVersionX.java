package fr.eseo.e3.poo.projet.blox;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersionX {

	private VuePuits vuePuits;

	public static void main(String[] args) {
		FallingBloxVersionX pdt = new FallingBloxVersionX();
		pdt.testConstructeurPuits();
	}

	private void testConstructeurPuits() {

		Puits puits = new Puits();
		vuePuits = new VuePuits(puits);

		UsineDePiece.setMode(3);
		PanneauInformation p = new PanneauInformation(puits);

		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());

		puits.getPieceActuelle().setPosition(5, 0);
		// System.out.println(vuePuits.getGravite().getPeriodicite());
		JFrame frame = new JFrame("Tetris");

		Gravite graphique = new Gravite(vuePuits);

		frame.add(vuePuits);
		frame.add(p, BorderLayout.EAST);
		// frame.add(puits.getExtenssions().bonScoreLabel,BorderLayout.NORTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();

		
	}

}

