package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {

	// Mes variable
	private Puits puits;
	private VuePuits vuePuits;

	// Mon constructeur
	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
	}

	// La méthode est appelé lorsque la souris est cliquée (clic simple) sur un
	// composant graphique.
	@Override
	public void mouseClicked(MouseEvent event) {
		if (puits.getPieceActuelle() != null) {
			boolean boutonGauche = SwingUtilities.isLeftMouseButton(event);
			boolean boutonDroit = SwingUtilities.isRightMouseButton(event);

			// Vérifie si le bouton gauche de la souris a été enfoncé
			if (boutonGauche) {
				try {
					puits.getPieceActuelle().tourner(false);
				} catch (BloxException e) {
					e.printStackTrace();
				}
				vuePuits.repaint();
			}

			else if (boutonDroit) {
				try {
					puits.getPieceActuelle().tourner(true);
				} catch (BloxException e) {
					e.printStackTrace();
				}

				vuePuits.repaint();
			}
		}

	}
}
