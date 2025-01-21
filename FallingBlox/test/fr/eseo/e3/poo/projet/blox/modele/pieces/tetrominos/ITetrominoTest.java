package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
 
public class ITetrominoTest {
	
	

    @Test
    public void testConstructorITetromino() 
    {
        Coordonnees coordonneesRef = new Coordonnees(7, 8);
        Couleur couleurRef = Couleur.JAUNE;
        ITetromino itetromino = new ITetromino(coordonneesRef, couleurRef);

        Element[] elementsRef = itetromino.getElements();

        // Vérification du contenu de l'élément
        assertNotNull(elementsRef, "L'élément ne doit pas être null");

        // Vérification de la taille
        assertEquals(4, elementsRef.length, "La taille est incorrecte");

        assertEquals(new Element(7, 8, couleurRef), elementsRef[0], "L'élément n'est pas l'origine de l'ITetromino");
        assertEquals(new Element(7, 9, couleurRef), elementsRef[1], "L'élément de coordonnées est incorrect");
        assertEquals(new Element(7, 7, couleurRef), elementsRef[2], "L'élément de coordonnées est incorrect");
        assertEquals(new Element(7, 6, couleurRef), elementsRef[3], "L'élément de coordonnées est incorrect");
    }
    
    @Test

	  public void testDeplacerDe() throws IllegalArgumentException, BloxException {

    	 ITetromino itetromino = new ITetromino(new Coordonnees(0, 0), Couleur.VERT);

		  assertThrows(IllegalArgumentException.class, () -> itetromino.deplacerDe(0, -2));
	
		  itetromino.deplacerDe(1, 0);
	
		  assertEquals(itetromino.getElements()[0].getCoordonnees(), new Coordonnees(1, 0));
		  
		  assertEquals(itetromino.getElements()[1].getCoordonnees(), new Coordonnees(1, 1));
	
		  assertEquals(itetromino.getElements()[2].getCoordonnees(), new Coordonnees(1, -1));
	
		  assertEquals(itetromino.getElements()[3].getCoordonnees(), new Coordonnees(1, -2));

		  itetromino.deplacerDe(1, 1);
	
		  assertEquals(itetromino.getElements()[0].getCoordonnees(), new Coordonnees(2, 1));
		  
		  assertEquals(itetromino.getElements()[1].getCoordonnees(), new Coordonnees(2, 2));
	
		  assertEquals(itetromino.getElements()[2].getCoordonnees(), new Coordonnees(2, 0));
	
		  assertEquals(itetromino.getElements()[3].getCoordonnees(), new Coordonnees(2, -1));


		  //assertThrows(IllegalArgumentException.class, () -> itetromino.deplacerDe(0, 0));

	  }
    
    
    @Test
    void testDeplacementValid() {
        // Créez une instance de OTetromino
        // Exécutez une action de déplacement valide
        // Vérifiez l'état attendu après le déplacement
    }

    @Test
    void testDeplacementInvalid() 
    {
        // Créez une instance de OTetromino
        // Essayez d'exécuter une action de déplacement invalide
        // Vérifiez que l'état de l'objet n'a pas changé ou qu'une exception est lancée
    }
    
    @Test
    void testRotation() {
    	Coordonnees c = new Coordonnees(0, 0);
        ITetromino tetromino = new ITetromino(c, Couleur.BLEU); 
       
       // Element[] elements = tetromino.getElements();
      
        //assertEquals(new Coordonnees(0, 0), elements[0].getCoordonnees());
        assertNotNull(c.getAbscisse());
        assertNotNull(c.getOrdonnee());
        
        //Element testedElement = null;
		//boolean condition = testedElement.getCoordonnees().equals(new Coordonnees(0, 0));
        //assertTrue(condition);  CounterClockwise
    }
}
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    Tetromino iTetromino = null;

    @Test
    void testRotationValide() 
    {
        
		iTetromino.tourner(false); // Rotation anti-horaire
        // Verifiez que la piece est tournee correctement
        // Puisque c'est un ITetromino, vérifiez que les éléments ont bien bougé en croix autour de l'élément de référence
        Element[] elements = iTetromino.getElements();
        assertEquals(new Coordonnees(5, 5), elements[0].getCoordonnees()); // Element de référence
        assertEquals(new Coordonnees(5, 4), elements[1].getCoordonnees());
        assertEquals(new Coordonnees(5, 6), elements[2].getCoordonnees());
        assertEquals(new Coordonnees(5, 3), elements[3].getCoordonnees());
        
    }

    @Test
    void testRotationInvalide() 
    {
        iTetromino.setPosition(0, 0); // posisition de rotatino invalide
        iTetromino.tourner(false); // Rotation anti-horaire
    }
    */







