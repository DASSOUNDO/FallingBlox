
package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class VuePiece {
	
	// Constante pour le mutiliccation de la tiente 
	public static final double MULTIPLIER_TEINTE = 0.3;
	
	// Mes variaables
	private final int taille;
	private final Piece piece;
	public static Color color;

	// Mon constructeur 
	public VuePiece(Piece piece, int taille) 
	{
		this.piece = piece;
		this.taille = taille;
	}

	// Gestion de la tiente 
	public static Color teinte(Color couleur) 
	{
		int rouge = couleur.getRed();
		int vert = couleur.getGreen();
		int bleu = couleur.getBlue();
		int alpha = couleur.getAlpha();

		// Application de l'algorithme pour éclaircir la couleur
		rouge = (int) (rouge + (255 - rouge) * MULTIPLIER_TEINTE);
		vert = (int) (vert + (255 - vert) * MULTIPLIER_TEINTE);
		bleu = (int) (bleu + (255 - bleu) * MULTIPLIER_TEINTE);

		return new Color(rouge,vert, bleu, alpha); 

	}

	// Gestion de l'afficgage de la piece 
	public void afficherPiece(Graphics2D g2D) 
	{
		Element[] elements = this.piece.getElements();

		for (int i = 0; i < elements.length; i++) 
		{
			Coordonnees c = elements[i].getCoordonnees();
			Color couleurRefTeinte = elements[i].getCouleur().getCouleurPourAffichage();

			if (i == 0) 
				couleurRefTeinte = teinte(couleurRefTeinte); 
			
			g2D.setColor(couleurRefTeinte);
			g2D.fill3DRect(c.getAbscisse() * this.taille, c.getOrdonnee() * 	
								this.taille, this.taille, this.taille,true);                                         
		}
	}
}

