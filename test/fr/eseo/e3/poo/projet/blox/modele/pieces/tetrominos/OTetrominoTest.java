package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetrominoTest {
	
	@Test
    public void testConstructor1()
    {
        Coordonnees coordonneesRef = new Coordonnees(6, 7);
        Couleur couleurRef = Couleur.JAUNE;
        OTetromino otetromino = new OTetromino(coordonneesRef, couleurRef);
    }

    @Test
    public void testConstructorElementPositions() 
    {
        Coordonnees coordonneesRef = new Coordonnees(6, 7);
        Couleur couleurRef = Couleur.JAUNE;
        OTetromino otetromino = new OTetromino(coordonneesRef, couleurRef);

        Element[] elementsRef = otetromino.getElements();

        assertNotNull(elementsRef, "L'élément n'est pas null");
        assertEquals(4, elementsRef.length, "La taille est incorrecte");

        assertEquals(new Element(6, 7, couleurRef), elementsRef[0], "L'élément n'est pas l'origine du otetromino");
        assertEquals(new Element(6, 6, couleurRef), elementsRef[1], "L'élément de coordonnées incorrect");
        assertEquals(new Element(7, 6, couleurRef), elementsRef[2], "L'élément de coordonnées incorrect");
        assertEquals(new Element(7, 7, couleurRef), elementsRef[3], "L'élément de coordonnées incorrect");
    }

    @Test
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
    }
    
    public void testDeplacerDe() throws IllegalArgumentException, BloxException {

    	OTetromino otetromino = new OTetromino(new Coordonnees(0, 0), Couleur.VIOLET);

        assertThrows(IllegalArgumentException.class, () -> otetromino.deplacerDe(0, 2));

        otetromino.deplacerDe(1, 0);

        assertEquals(otetromino.getElements()[0].getCoordonnees(), new Coordonnees(1, 0));

        assertEquals(otetromino.getElements()[1].getCoordonnees(), new Coordonnees(2, 0));

        assertEquals(otetromino.getElements()[2].getCoordonnees(), new Coordonnees(1, -1));

        assertEquals(otetromino.getElements()[3].getCoordonnees(), new Coordonnees(2, -1));

        otetromino.deplacerDe(1, 1);

        assertEquals(otetromino.getElements()[0].getCoordonnees(), new Coordonnees(2, 1));

        assertEquals(otetromino.getElements()[1].getCoordonnees(), new Coordonnees(3, 1));

        assertEquals(otetromino.getElements()[2].getCoordonnees(), new Coordonnees(2, 0));

        assertEquals(otetromino.getElements()[3].getCoordonnees(), new Coordonnees(3, 0));

        assertThrows(IllegalArgumentException.class, () -> otetromino.deplacerDe(0, 0));

        }
    
    @Test
    void testDeplacementValid() {}

    @Test
    void testDeplacementInvalid() {}
   
    
}

