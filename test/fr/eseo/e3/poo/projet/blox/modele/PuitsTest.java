package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;

public class PuitsTest {

	@Test  
	void testParDefaut() 
	{
		Puits  p1 = new Puits();
		
		assertEquals(10, p1.LARGEUR_PAR_DEFAUT, "La largeur par defaut est incorrecte");
		//assertEquals(20, puits.PROFONDEUR_PAR_DEFAUT, "La largeur par defaut est incorrecte");
		assertEquals(p1.PROFONDEUR_PAR_DEFAUT, p1.getProfondeur(), "La largeur par defaut est incorrecte");
		
		assertNotNull(p1.LARGEUR_PAR_DEFAUT, "La largeur est null");
		assertNotNull(p1.PROFONDEUR_PAR_DEFAUT, "La largeur est null");
	}
	
	@Test
	public void testConstructeur()
	{
		Puits p2 = new Puits(11, 16); 
		
		assertEquals(11, p2.getLargeur(), "La largeur par defaut est incorrecte");
		assertEquals(16, p2.getProfondeur(), "La largeur par defaut est incorrecte");
		
	}
	
	@Test 
	public void testConstructeurSet()
	{ 
		Puits p3 = new Puits(12, 18);
		
		p3.setLargeur(13);
		p3.setProfondeur(19);
		
		assertEquals(13, p3.getLargeur(), "La largeur par defaut est incorrecte");
		assertEquals(19, p3.getProfondeur(), "La largeur par defaut est incorrecte");
		
	}
	 
	/*@Test
	public void testsetPieceSuivante()
	{
		Puits puits = new Puits(11, 16);
	    Piece puitsSuivante = null;
	    puits.setPieceSuivante(puitsSuivante);
	    assertEquals(null,puits.getPieceSuivante());
	}*/ 
	
	@Test 
	public void testToStringPasDePiece()
	{
		Puits p = new Puits(5, 15); 
		
		String affichage = "Puits : Dimension 5 x 15\n" + "Piece Actuelle : <aucune>\n" 
							+ "Piece Suivante : <aucune>\n";        
	}
	
	@Test 
	public void testToStringPiecePresente()
	{
		Coordonnees c1 = new Coordonnees(4, 6);
		Coordonnees c2 = new Coordonnees(4, 6);
		Puits p = new Puits(6, 16);
		Couleur color = Couleur.VERT;
		ITetromino actu = new ITetromino(c1, color);
		OTetromino next = new OTetromino(c2, color);
		
	    p.setPieceSuivante(actu);
	    p.setPieceSuivante(next);
	    
		String affichage = "Puits : Dimension 6 x 16\n" + "Piece Actuelle : " +actu.toString()+ 
							"Piece Suivante : " +next.toString();    
		
		assertEquals(affichage, p.toString(), "L'affichage  n'est pas correcte");
		assertTrue(p.toString().contains(affichage), "C'est faux");
		assertNotNull(p.toString(), "L'aficharge est vide");				
	}
	



	private Puits puits;
	
	@BeforeEach
	void setUp() {
	    puits = new Puits(10, 20);
	}
	
	@Test
	@DisplayName("Test de déplacement valide dans le puits")
	void testDeplacementValide() {
		Coordonnees cd = new Coordonnees(9, 10);
	    Piece piece = new OTetromino(cd, Couleur.BLEU);
	    puits.setPieceActuelle(piece);
	    assertDoesNotThrow(() -> puits.gravite());
	} 
	
	@Test
	@DisplayName("Test de déplacement invalide (collision avec le tas)")
	void testDeplacementInvalide() 
	{
		Coordonnees c = new Coordonnees(8, 14);
	    Piece piece = new OTetromino(c, Couleur.BLEU);
	    piece.setPosition(0, 19); 
	    puits.setPieceActuelle(piece);
	    //assertThrows(BloxException.class, () -> puits.gravite());
	}
}


/*@Test
public void testToString()
{
    Coordonnees coordonneesRef = new Coordonnees(6, 7);
    Couleur couleurRef = Couleur.VIOLET;
    OTetromino otetromino = new OTetromino(coordonneesRef, couleurRef);

    String attendue = "OTetromino :\n" +
            "\t(6, 7) - VIOLET\n" +
            "\t(6, 6) - VIOLET\n" +
            "\t(7, 6) - VIOLET\n" +
            "\t(7, 7) - VIOLET\n";

    assertEquals(attendue, otetromino.toString(), "Le résultat à la sortie de toString ne correspond pas au résultat attendu.");
}*/
