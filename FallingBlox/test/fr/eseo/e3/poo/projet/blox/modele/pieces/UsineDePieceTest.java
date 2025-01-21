package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;

public class UsineDePieceTest {

	private static final Integer ALEATOIRE_COMPLET = 1;
	private static final Integer CYCLIC = 3;
	private static final Integer ALEATOIRE_PIECE = 2;
	//Integer modeActuel = null;

	// Test pour vérifier les valeur par defaut 
	@Test
	void test1() 
	{
		 Coordonnees c = new Coordonnees(2, 3);
		//UsineDePiece usinep = new UsineDePiece();
		assertEquals(1, ALEATOIRE_COMPLET, "'est faux");
		assertEquals(2, ALEATOIRE_PIECE, "'est faux");
		assertEquals(3, CYCLIC, "'est faux");
		
		//assertEquals(modeActuel, ALEATOIRE_PIECE, "mode actuel incorrect"); 
	}
	
	// Test pour la methode set
	@Test
    public void testSetMode() 
	{
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
    }
	
	/*@Test
    public void testSetModeAleatoireComplet() 
	{
        
    }*/

}
