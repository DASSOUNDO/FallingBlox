package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {
	
	
	
		/*@Test
		void test() {
			 
			
		}*/
		
		
	/*	public void PieceRotationTest()
		{
			testConstructeurRotation();
			
		}*/

		private void testConstructeurRotation() 
		{
			
			JFrame frame = new JFrame("Puits");
			Puits puits = new Puits();
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
					new PieceRotationTest();
				}
			});
		}

	}
	
	
	
	

	/*@Test
	void test() 
	{
		
	}
	
	/*@Test
    void testT() throws BloxException {
		Coordonnees c = new Coordonnees(2, 6);
		ITetromino it = new ITetromino(c, Couleur.ROUGE);
        assertEquals("(2,6) - ROUGE", it.toString());

        it.tourner(false);
        assertEquals("(2,6) - ROUGE", it.toString()); // Assert the state after one rotation

         
    }*/

	



