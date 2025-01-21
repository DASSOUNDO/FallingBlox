package fr.eseo.e3.poo.projet.blox;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {

	private VuePuits vuePuits;

	public static void main(String[] args) {
		FallingBloxVersion1 p = new FallingBloxVersion1();
		p.testConstructeurPuits();
		//ajoutMusique(path);
		
		FallingBloxVersion1 fallingBlox = new FallingBloxVersion1();
        
        // Appel de la fonction ajoutMusique avec le chemin du fichier audio en argument
        fallingBlox.ajoutMusique("Musique");
	}
	
	
	public void ajoutMusique(String path) {
	    try {
	        // Chargement du fichier audio
	        File file = new File(path);
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
	        
	        // Création d'un Clip
	        Clip clip = AudioSystem.getClip();
	        
	        // Ouverture du fichier audio
	        clip.open(audioInputStream);
	        
	        // Lecture en boucle du fichier audio
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}  

	
	private void testConstructeurPuits() {
		Puits puits = new Puits();
		vuePuits = new VuePuits(puits);

		UsineDePiece.setMode(3);
		PanneauInformation p = new PanneauInformation(puits);
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		// puits.setPieceSuivante(UsineDePiece.genererTetromino());
		// puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.getPieceActuelle().setPosition(4, 0);

		Gravite graphique = new Gravite(vuePuits); 
		
		JFrame frame = new JFrame("Falling Blox");
		frame.add(vuePuits);
		frame.add(p, BorderLayout.EAST);
		
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// PanneauInformation info = new PanneauInformation("Score");
		// frame.add(info, BorderLayout.EAST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		vuePuits.setFocusable(true);
		frame.requestFocus();
		vuePuits.requestFocus();
		
		
		 
		
		//frame.repaint();
		
	}

}