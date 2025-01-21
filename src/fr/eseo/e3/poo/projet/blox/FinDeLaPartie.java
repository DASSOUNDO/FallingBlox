package fr.eseo.e3.poo.projet.blox;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FinDeLaPartie extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private VuePuits vuePuits;

	public FinDeLaPartie() {
		
        JLabel label = new JLabel("La Partie est Terminer");
        
        label.setFont(label.getFont().deriveFont(45.0f)); // Pour le changement de la taille de police
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);// centrage du texte
        this.getContentPane().add(label);
        this.pack(); // Redimensionne de la fenêtre pour s'adapter à son contenu
        this.setLocationRelativeTo(null); // centre la fenêtre sur l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermerture de l'application lorsque la fenêtre est fermée
        this.setVisible(true); // affiche la fenêtre
        this.vuePuits.getGravite().getTimer().stop(); // Affichage de la fenêtre

    }


}

