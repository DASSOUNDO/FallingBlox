
package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

//public class PieceDeplacement implements java.awt.event.MouseMotionListener {
public class PieceDeplacement extends MouseAdapter {

	private VuePuits vuePuits;
	private Puits puits;
	private int maColonneDeFin = -1;

	public PieceDeplacement(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.setPuits(this.vuePuits.getPuits());
	}

	@Override
	public void mouseMoved(MouseEvent event) {

		if (vuePuits.getPuits().getPieceActuelle() != null) {
			int maColonneActuelle = getColumn(event);

			if (this.maColonneDeFin == -1) {
				this.maColonneDeFin = maColonneActuelle;
			}

			else if (this.maColonneDeFin != maColonneActuelle) {
				try {
					int b = maColonneActuelle - this.maColonneDeFin;

					if (b > 0) // Si la souris se déplace vers la droite
					{
						// Le deplacement de la pièce vers la droite
						this.vuePuits.getPuits().getPieceActuelle().deplacerDe(1, 0);
					} else if (b < 0) // Si la solastColumnuris se déplace vers la gauche
					{
						// Le deplacement de la pièce vers la gauche
						this.vuePuits.getPuits().getPieceActuelle().deplacerDe(-1, 0);
					}
					maColonneDeFin = maColonneActuelle;
					this.vuePuits.repaint();
				}

				catch (IllegalArgumentException | BloxException ev) {
					throw new IllegalArgumentException("Deplacement impossible :" + ""
							+ " " + ev.getMessage());
				}

			}

		}

	}

	public int getColumn(MouseEvent event) {

		int a = event.getX();

		int taille = this.vuePuits.getTaille();

		int largeurPuits = taille * this.puits.getLargeur();

		int colonne = a / taille;

		if (colonne < 0) {
			return 0;
		} else if (colonne >= largeurPuits) {
			return this.puits.getLargeur() - 1;
		} else {
			return colonne;
		}

	}

	private Puits getPieceActuelle() {
		return getPieceActuelle();
	}

	public int deplacerDe(int coloneA, int coloneF) {
		int dX = coloneA - coloneF;

		if (dX > 0) {
			dX = 1;
		}

		if (dX < 0) {
			dX = -1;
		}

		try {
			this.puits.getPieceActuelle().deplacerDe(dX, 0);
		} catch (IllegalArgumentException | BloxException ex) {
			// Rien dedans
		}

		return coloneA;
	}

	public void mouseEntered(MouseEvent e) {
		maColonneDeFin = -1;
	}

	public void mouseWheelMoved(MouseWheelEvent event) {

		if (vuePuits.getPuits().getPieceActuelle() != null && event.getWheelRotation() > 0) {
			try {
				vuePuits.getPuits().getPieceActuelle().deplacerDe(0, 1);
				vuePuits.repaint();
			}

			catch (IllegalArgumentException | BloxException exp) {
				// throw new IllegalArgumentException("Error --> Methode MouseWheelMoved
				// incorrecte :" + exp.getMessage());
			}
		}

	}

	private void setPuits(Puits puits) {
		this.puits = puits;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// No touch
	}

	public VuePuits getVuePuits() {
		return vuePuits;
	}

}
