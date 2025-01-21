package fr.eseo.e3.poo.projet.blox.modele;

import java.awt.Color;

public enum Couleur {

	ROUGE(Color.RED), ORANGE(Color.ORANGE), BLEU(Color.BLUE), VERT(Color.GREEN), JAUNE(Color.YELLOW), CYAN(Color.CYAN),
	VIOLET(Color.MAGENTA);

	private final Color couleurPourAffichage;

	// Constructeur privé pour initialiser la couleur pour affichage
	Couleur(Color couleurPourAffichage) {
		this.couleurPourAffichage = couleurPourAffichage;
	}

	// Accesseur pour prendre la couleur et affichage
	public Color getCouleurPourAffichage() {
		return couleurPourAffichage;
	}
}
