package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TasTest {


	@Test
	public void testConstructeurVide()
	{
	    Puits puits = new Puits(12, 17);
	    Tas tas = new Tas(puits);
	    List<Element> elements = tas.getElements();

	    // Confirmer que la liste des éléments est vide pour un Tas nouvellement créé
	    assertTrue("La liste des éléments devrait être vide", elements.isEmpty());
	    // Vérifications supplémentaires sur les dimensions du puits si nécessaire
	    assertEquals("La largeur du puits devrait être de 12", 12, puits.getLargeur());
	    assertEquals("La profondeur du puits devrait être de 17", 17, puits.getProfondeur());
	}
	
 
    @Test
    public void testConstructeurAleatoire() 
    {
        Puits puits = new Puits(10, 20);
        int nbElements = 20;
        int nbLignes = 3;
        Tas tas = new Tas(puits, nbElements, nbLignes);
        List<Element> elements = tas.getElements();
        assertTrue("Nombre d'éléments devrait être égal ou inférieur à nbElements", elements.size() <= nbElements);
        assertTrue("Tous les éléments devraient être dans les dernières nbLignes du puits",
        elements.stream().allMatch(e -> e.getCoordonnees().getOrdonnee() >= (puits.getProfondeur() - nbLignes)));
    }

    
    @Test
    public void testConstructeurAleatoireCalcul() 
    {
        Puits puits = new Puits(10, 20);
        int nbElements = 50;
        Tas tas = new Tas(puits, nbElements);
        List<Element> elements = tas.getElements();
        assertTrue("Nombre d'éléments devrait être égal ou inférieur à nbElements", elements.size() <= nbElements);
        int nbLignesCalculees = nbElements / puits.getLargeur() + 1;
        assertTrue("Tous les éléments devraient être dans les dernières lignes calculées du puits",
        elements.stream().allMatch(e -> e.getCoordonnees().getOrdonnee() >= (puits.getProfondeur() - nbLignesCalculees)));
    }
     
    
    /*@Test(expected = IllegalArgumentException.class)
    public void testConstructeurNbElementsTropGrandCalcul() {
        Puits puits = new Puits(5, 5);
        int nbElements = 50; // Nombre d'éléments impossible pour la largeur du puits
        new Tas(puits, nbElements);
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void testConstructeurNbLignesTropGrandCalcul() {
        Puits puits = new Puits(5, 5);
        int nbElements = 10;
        int nbLignes = puits.getProfondeur() + 1; // nbLignes calculé interne, mais supposons il serait trop grand
        new Tas(puits, nbElements, nbLignes);
    }*/



}
