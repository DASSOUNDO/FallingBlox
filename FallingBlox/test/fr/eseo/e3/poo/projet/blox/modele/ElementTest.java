package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
	
	// ROUGE
	@Test 
	void testConstructeur1Element1() 
	{
		Coordonnees c1 = new Coordonnees(2, 4);
		
		assertEquals(2, c1.getAbscisse(), "Le abscisse est incorrect");
		assertEquals(4, c1.getOrdonnee(), "L'ordonnee est incorrect");
	}

	@Test 
	void testConstructeur2Element1() 
	{
		Coordonnees c1 = new Coordonnees(2, 4);
		Element e1 = new Element(c1, Couleur.ROUGE);
		
		assertEquals(c1, e1.getCoordonnees(), "Le coordonnees est incorrect");
		assertEquals(Couleur.ROUGE, e1.getCouleur(), "La couleur est incorrete");
	}
	
	@Test 
	void testConstructeur3Element1() 
	{
		Coordonnees c1 = new Coordonnees(4, 8);
		Element e1 = new Element(c1, Couleur.ROUGE);
		
		assertEquals(4, e1.getCoordonnees().getAbscisse(), "L'abscisse est incorrect");
		assertEquals(8, e1.getCoordonnees().getOrdonnee(), "L'ordonnee est incorrect");
		assertEquals(Couleur.ROUGE, e1.getCouleur(), "La couleur est incorrete");
	}
	
	// JAUNE
	@Test 
	void testConstructeur2Element2() 
	{
		Coordonnees c1 = new Coordonnees(9, 1);
		Element e1 = new Element(c1, Couleur.JAUNE);
		
		assertEquals(c1, e1.getCoordonnees(), "Le coordonnees est incorrect");
		assertEquals(Couleur.JAUNE, e1.getCouleur(), "La couleur est incorrete");
	}
	
	@Test 
	void testConstructeur3Element2() 
	{
		Coordonnees c1 = new Coordonnees(5, 7);
		Element e1 = new Element(c1, Couleur.JAUNE);
		
		assertEquals(5, e1.getCoordonnees().getAbscisse(), "L'abscisse est incorrect");
		assertEquals(7, e1.getCoordonnees().getOrdonnee(), "L'ordonnee est incorrect");
		assertEquals(Couleur.JAUNE, e1.getCouleur(), "La couleur est incorrete");
	}
	
	// CYAN
	
	@Test 
	void testConstructeur2Element3() 
	{
		Coordonnees c1 = new Coordonnees(2, 4);
		Element e1 = new Element(c1, Couleur.BLEU);
		
		assertEquals(c1, e1.getCoordonnees(), "Le coordonnees est incorrect");
		assertEquals(Couleur.BLEU, e1.getCouleur(), "La couleur est incorrete");
	}
	
	@Test 
	void testConstructeur3Element3() 
	{
		Coordonnees c1 = new Coordonnees(4, 8);
		Coordonnees c2 = new Coordonnees(100, 200);
		Element e1 = new Element(c1, Couleur.JAUNE);
		
		e1.setCoordonnees(c2);
		e1.setCouleur(Couleur.BLEU);
		
		assertEquals(c2, e1.getCoordonnees(), "Le coordonnees est incorrect");
		assertEquals(Couleur.BLEU, e1.getCouleur(), "La couleur est incorrete");
	}
	
 
	@Test
	void testToStringElement() 
	{
		Coordonnees coor = new Coordonnees(5, 6);
		Element elem = new Element(coor,Couleur.VIOLET);
		
		assertEquals("(5, 6) - VIOLET", elem.toString(), "Affichage incorrecte");
	}
	
	/*@Test 
	void testDeplacerDe()
	{
		Coordonnees coor = new Coordonnees(5, 6);
	    
	}*/
	
	@Test
    public void testDeplacerDe() {
        
		 Element e = new Element(new Coordonnees(0, 0), Couleur.BLEU);
	        
	        // Déplacer vers la droite et le bas
	        e.deplacerDe(2, 3);
	        Assertions.assertEquals(2, e.getCoordonnees().getAbscisse());
	        Assertions.assertEquals(3, e.getCoordonnees().getOrdonnee());
	        
	        // Déplacer vers la gauche et le haut
	        e.deplacerDe(-1, -2);
	        Assertions.assertEquals(1, e.getCoordonnees().getAbscisse());
	        Assertions.assertEquals(1, e.getCoordonnees().getOrdonnee());
    }
	   
}
