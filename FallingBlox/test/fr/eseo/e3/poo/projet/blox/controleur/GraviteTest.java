package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {

	private VuePuits vuePuits;
	private Puits puits;
	private Gravite gravite;

	@Before
	public void setUp() throws Exception 
	{
		this.puits = new Puits(13, 21);
		this.vuePuits = new VuePuits(puits);
		this.gravite = new Gravite(vuePuits);
	}  
	
	@Test
	public void testDeSetPeriodicite() 
	{
		gravite.setPeriodicite(155);
		assertEquals(155, gravite.getPeriodicite());
	}

	@Test
	public void testConstructeur() 
	{
		assertEquals(2000, gravite.getPeriodicite());
	}

	@Test
	public void testActionPerformed() throws BloxException // Ma méthode effectue un test d'action.
	{
		// Ajout d'une pièce au puits :
		OTetromino otetromino = new OTetromino(new Coordonnees(1,1),Couleur.BLEU);
		 
		try 
		{
			Thread.sleep(gravite.getPeriodicite() + 200);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

	}
}
