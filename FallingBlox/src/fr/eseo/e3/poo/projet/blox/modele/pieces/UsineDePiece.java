/*package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.Random;

//import org.junit.jupiter.api.MethodOrderer.Random;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public class UsineDePiece {
    
	// Mes constantes
    public static final int ALEATOIRE_COMPLET = 1;
    public static final int ALEATOIRE_PIECE = 2;
    public static final int CYCLIC = 3;
    
    private static int modeActuel = ALEATOIRE_PIECE;
    private static int cyl = 0; // Cette variable conserver son état entre les appels
    
    
    private UsineDePiece() 
    {
        // Constructeur privé
    }
    
    // La méthode définir le mode de jeu.
    public static void setMode(int mode) 
    {
        modeActuel = mode; 
    }
    
    // La méthodess générer un nouveau tétromino.
    public static Tetromino genererTetromino() 
    {
    	Random r = new Random();
        Coordonnees c = new Coordonnees(2, 3);
        Couleur color = Couleur.values()[r.nextInt(Couleur.values().length)];
      
        int type = r.nextInt(2); //  choix simple entre deux options pour
        
        switch (modeActuel) 
        {
            case CYCLIC:
                if (cyl == 0) 
                {
                    cyl = 1;
                    return new OTetromino(c, Couleur.ROUGE);
                }
                else 
                {
                    cyl = 0;
                    return new ITetromino(c, Couleur.ORANGE); // Retour d'un ITetromino pour respecter l'erreur 
                }
                
            case ALEATOIRE_PIECE:
                
                if (type == 0) 
                {
                    return new OTetromino(c, Couleur.ROUGE);
                } 
                else 
                {
                    return new ITetromino(c, Couleur.ORANGE);
                }
                
            default:
   
            	if (type == 0) 
            	{
            	    return new OTetromino(c, color);
            	}
            	else 
            	{
            	    return new ITetromino(c, color);
            	}
            	
        }
    }

}  */




package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ITetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.JTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.LTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.OTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.STetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.TTetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.ZTetromino;



public class UsineDePiece {

	public static final int CYCLIC = 3;
	public static final int ALEATOIRE_COMPLET = 1;
	public static final int ALEATOIRE_PIECE = 2;

	private static Random rc = new Random();
	
	// public static Coordonnees new Coordonnees(2,3) = new Coordonnees(2, 3);
	private static int nbPieceUsine = 0;

	static int mode = ALEATOIRE_PIECE;

	private UsineDePiece() 
	{ 
		// C'est privé
	}

	public static void setMode(int mode) 
	{
		
		if (UsineDePiece.mode == UsineDePiece.CYCLIC || UsineDePiece.mode == UsineDePiece.ALEATOIRE_COMPLET  
				|| UsineDePiece.mode == UsineDePiece.ALEATOIRE_PIECE ) 
		{
			UsineDePiece.mode = mode;
			//LTetromino
			//LTetromino tretomino = new LTetromino(new Coordonnees(0, -1), Couleur.VERT);
			//nbPieceUsine = 0;
			//mode = ALEATOIRE_PIECE;
		}
	}
	
	public static Tetromino modeCyclic() 
	{
		Tetromino[] tretomino = new Tetromino[7] ;
		tretomino[0] = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
		tretomino[1] = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
		tretomino[2] = new 	TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
		tretomino[3] = new LTetromino(new Coordonnees(2, 3), Couleur.VERT);
		tretomino[4] = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
		tretomino[5] = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
		tretomino[6] = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);		
		return tretomino[nbPieceUsine % 7]; // nbPieceUsine % 7 garantit que l'indice sélectionné 
		//dans le tableau tab est compris entre 0 et 6, ce qui correspond aux indices valides du tableau.
	}
	
	public static Tetromino modeAleatoirePiece() 
	{
		Tetromino[] tretomino = new Tetromino[7] ;
		tretomino[0] = new OTetromino(new Coordonnees(2, 3), Couleur.ROUGE);
		tretomino[1] = new ITetromino(new Coordonnees(2, 3), Couleur.ORANGE);
		tretomino[2] = new TTetromino(new Coordonnees(2, 3), Couleur.BLEU);
		tretomino[3] = new LTetromino(new Coordonnees(2,3), Couleur.VERT);
		tretomino[4] = new JTetromino(new Coordonnees(2, 3), Couleur.JAUNE);
		tretomino[5] = new ZTetromino(new Coordonnees(2, 3), Couleur.CYAN);
		tretomino[6] = new STetromino(new Coordonnees(2, 3), Couleur.VIOLET);
		return  tretomino[rc.nextInt(7)];
	}
	
	public static Tetromino modeAleatoireComplet() 
	{
		Tetromino[] tretomino = new Tetromino[7] ;
		int nColor = rc.nextInt(Couleur.values().length);	
		tretomino[0] = new OTetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[1] = new ITetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[2] = new TTetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[3] = new LTetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[4] = new JTetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[5] = new ZTetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		tretomino[6] = new STetromino(new Coordonnees(2, 3), Couleur.values()[nColor]);
		return tretomino[rc.nextInt(7)]; 
	}

	public static Tetromino genererTetromino() 
	{
		Tetromino tetromino = null;  
		switch (mode) 
		{
			case CYCLIC:
				tetromino = modeCyclic();
				nbPieceUsine++;  
				break;	
			case ALEATOIRE_PIECE:
				tetromino = modeAleatoirePiece();
				break;
			case ALEATOIRE_COMPLET:
				tetromino = modeAleatoireComplet();
			    break;
			default:
				System.out.println("PaS DE ModE");
				break;
		}
			return tetromino; 
	}
}

