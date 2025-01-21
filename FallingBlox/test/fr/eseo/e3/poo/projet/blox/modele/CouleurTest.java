package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class CouleurTest {

	// Test pour test les couleurs
	@Test
	void testColorPourAfficher() 
	{
		assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage(), "La couleur ROUGE ne correspond pas.");
        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage(), "La couleur ORANGE ne correspond pas.");
        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage(), "La couleur BLEU ne correspond pas.");
        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage(), "La couleur VERT ne correspond pas.");
        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage(), "La couleur JAUNE ne correspond pas.");
        assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage(), "La couleur CYAN ne correspond pas.");
        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage(), "La couleur VIOLET ne correspond pas.");
	}
}
