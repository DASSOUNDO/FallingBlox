package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	/*@Test
	void test() {
		 
		
	}*/
	
	
	@Test
    public void testDeplacementPiece() 
	{
        Puits puits = new Puits(15, 25);
        puits.setPieceSuivante(UsineDePiece.genererTetromino());
        assertNotNull(puits.getPieceActuelle(), "La pièce actuelle ne devrait pas être nulle après l'avoir définie");
    }
	
	@Test
	/*public void PieceDeplacementTest()
	{
		testConstructeurDeplacerDe();
	}*/

	private void testConstructeurDeplacerDe() 
	{ 
		
		JFrame frame = new JFrame("Puits");
		Puits puits = new Puits(15, 25);
		VuePuits vueP = new VuePuits(puits);
		
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		puits.setPieceSuivante(UsineDePiece.genererTetromino());
		// Enregistrement de vue comme listener de puits 
        //puits.addPropertyChangeListener(vue);
		
		//frame.add(vue);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(vueP);
		frame.pack();
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}                                                                                                
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PieceDeplacementTest();
			}
		});
	}

}






/*
 package fr.eseo.e3.poo.projet.blox.controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	private VuePuits vuePuits;
	private PieceDeplacement pieceDeplacement;
	private Puits puits;
	private Piece piece;

	    @Before
	    public void setUp() throws Exception {
	        this.puits = new Puits(10, 20);
	        this.vuePuits = new VuePuits(puits);
	        this.pieceDeplacement = new PieceDeplacement(vuePuits);
	       
	     // Création d'un puits avec une pièce
	      UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
	        piece = UsineDePiece.genererPiece();
	       
	     // Ajouter une pièce dans le puits
	       
	        puits.setPieceSuivante(piece);
	        puits.setPieceSuivante(piece);
	        puits.addPropertyChangeListener(vuePuits);
	      //  vuePuits.addMouseListener(pieceDeplacement);
	        vuePuits.addMouseMotionListener(pieceDeplacement);
	       
	       
	    }
	   
	    @Test
	public void testGetColumn() {
	MouseEvent event = new MouseEvent(vuePuits, MouseEvent.MOUSE_MOVED, 0, 0, 90, 0, 0, false);
	int column = pieceDeplacement.getColumn(event);
	assertEquals(3, column);
	}
	   
	    @Test
	  public void testDeplacementHorizontalPiece() {
	     
	   
	         // Création de la fenêtre avec une vue du puits
	         JFrame fenetre = new JFrame("Test");
	         fenetre.add(vuePuits);
	         fenetre.pack();
	         fenetre.setLocationRelativeTo(null);
	         fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         fenetre.setVisible(true);
	 
	        MouseEvent event = new MouseEvent(vuePuits, MouseEvent.MOUSE_MOVED, 0, 0, 50, 0, 0, false);
	        pieceDeplacement.getColumn(event);
	  pieceDeplacement.mouseMoved(event);
	  assertEquals(5, piece.getElements()[0].getCoordonnees().getAbscisse());
	  }
	   
	}
*/