package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

//package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
//import fr.eseo.e3.poo.projet.blox.controleur.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public abstract class Tetromino implements Piece {  
	

	// Mes variables 
	private Element[] elements; // Tableau 
	private Puits puits;
	
	// Constructeur de la classe Tetromino
	public Tetromino(Coordonnees coordonneesRef, Couleur couleurRef) 
	{
		 elements = new Element[4];
         setElements(coordonneesRef, couleurRef);
	}
	
	// Pour remplir le tableau des Elements avec quatre nouvelles instances de la classe 
	//Element en utilisant la couleur et les coordonnees de référence passée en argument 
	protected abstract void setElements(Coordonnees coordonneesRef, Couleur couleurRef);
	
	// Mon accesseur me retourne mon éléments
	public Element[] getElements()
	{
        return elements; 
    }
	
	// Mon mutateur fait une modification en utilisant les denner mise en paramettre 
	public void setPosition(int abscisse, int ordonnee)
	{
		if(getClass().getSimpleName().equals("ITetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse, ordonnee+1));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse, ordonnee-2));
		}
		else if(getClass().getSimpleName().equals("OTetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse+1, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse+1, ordonnee));
		} 
		else if(getClass().getSimpleName().equals("TTetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse-1, ordonnee));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee+1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse+1, ordonnee));
		}
		else if(getClass().getSimpleName().equals("LTetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse+1, ordonnee));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse, ordonnee-2));
		}
		else if(getClass().getSimpleName().equals("JTetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse-1, ordonnee));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse, ordonnee-2));
		}
		else if(getClass().getSimpleName().equals("ZTetromino"))
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse+1, ordonnee));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse-1, ordonnee-1));
		}
		else 
		{
			this.elements[0].setCoordonnees(new Coordonnees(abscisse, ordonnee));
			this.elements[1].setCoordonnees(new Coordonnees(abscisse-1, ordonnee));
			this.elements[2].setCoordonnees(new Coordonnees(abscisse, ordonnee-1));
			this.elements[3].setCoordonnees(new Coordonnees(abscisse+1, ordonnee-1));
		}
	}
	  
	// Affichage 
	@Override
	public String toString() 
	{
		return " :" 
	               + "\n" + "\t" +
				           this.getElements()[0].toString() 
				   + "\n" + "\t" + 
				           this.getElements()[1].toString() 
				   + "\n" + "\t" + 
				           this.getElements()[2].toString()  
				   + "\n" + "\t" + 
				           this.getElements()[3].toString() 
				   + "\n";
	}
	
	// Mon accesseur me retourne le puits 
	public Puits getPuits()
	{
		return puits;
	}
	
	// Fait une modification en utilisant puits mise en paramettre 
	public void setPuits(Puits puits)
	{
		this.puits = puits;
	}
	
	 // Ma métode deplacerDe me permet de fait un deplacement d'un coordonnees a une autre.. 
	 public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException 
	 {
		 deplacerDeIllega(deltaX,deltaY);
	     
		 if(this.puits != null && this.puits.getTas() != null)
		 {
			 // Applle de mes fonctions pour gérée les BloxException 
			 deplacerDeExepSortie(deltaX,deltaY);	 
			 deplacerDeExepColision(deltaX,deltaY);	                                                                	
			 deplacerDeExepDer(deltaX,deltaY);
		 }

		 for(int k = 0; k<this.elements.length; k++)
	     { 
			 int abs = this.elements[k].getCoordonnees().getAbscisse() + deltaX;
			 int ord = this.elements[k].getCoordonnees().getOrdonnee() + deltaY;
			 this.elements[k].setCoordonnees(new Coordonnees(abs, ord));    
	     }
	 }
	 
	 
	 public void deplacerDeIllega(int deltaX, int deltaY) throws IllegalArgumentException, BloxException
	 {
		 if (deltaX > 1 || deltaX < -1  || deltaY < 0 || deltaY > 1) 
	     {
	            throw new IllegalArgumentException("Le déplacement est limité");
	     }
	 }
	 
	 public void deplacerDeExepSortie(int deltaX, int deltaY) throws IllegalArgumentException, BloxException
	 {
		 if(this.puits != null && this.puits.getTas() != null)
		 {
			 for(int k = 0; k<this.elements.length; k++) 
	         {
	              int abs = this.elements[k].getCoordonnees().getAbscisse() + deltaX;
	              int ord = this.elements[k].getCoordonnees().getOrdonnee() + deltaY;
	 
	        	if(abs >= getPuits().getLargeur() || abs < 0)
	        		{  
	        				throw new BloxException("La piece touche un des bords du puits,"
	        						+ "--> Sortie impossible du puits",
	        						BloxException.BLOX_SORTIE_PUITS); 
	        		} 
	         }
		 } 
	 }
	 
	 public void deplacerDeExepColision(int deltaX, int deltaY) throws IllegalArgumentException, BloxException
	 {
		 if(this.puits != null && this.puits.getTas() != null)
		 {
			 for(int k = 0; k<this.elements.length; k++) 
	         {
	              int abs = this.elements[k].getCoordonnees().getAbscisse() + deltaX;
	              int ord = this.elements[k].getCoordonnees().getOrdonnee() + deltaY;
	           if(puits.getTas().elementExists(abs, ord) || ord >= getPuits().getProfondeur())
	        	{
	        			throw new BloxException("La piece touche le fond du puits au tas"
	        						+ " ---> Collision impossible",
	        						BloxException.BLOX_COLLISION);
	        	}
	         }
		 }   
	 }
	 
	 public void deplacerDeExepDer(int deltaX, int deltaY) throws IllegalArgumentException, BloxException
	 {
		 if(this.puits != null && this.puits.getTas() != null)
		 {
			 for(int k = 0; k<this.elements.length; k++) 
	         {
	              int abs = this.elements[k].getCoordonnees().getAbscisse() + deltaX;
	              int ord = this.elements[k].getCoordonnees().getOrdonnee() + deltaY;
	           if (collisionDetected() || reachedBottom()) 
		       {
		        	 throw new BloxException("Collision détectée ou atteint le fond du puits", ord);	
		       }
	        }
		 } 
	}
	 
	 
	 public abstract boolean collisionDetected();

	 public abstract boolean reachedBottom();

	 // La méthode tourner me permet de tpourner ma piece en respectant les condition qu'il faut   
	 public void tourner(boolean sensHoraire) throws BloxException 
	 { 
		    if (this.puits != null) 
		    {
		    	Element reference = this.getElements()[0]; // Supposons que l'élément de référence est le premier élément.
		        int refAbscisse = reference.getCoordonnees().getAbscisse();
		        int refOrdonnee = reference.getCoordonnees().getOrdonnee();
		        Coordonnees[] nouvellesCoordonnees = new Coordonnees[this.elements.length];
		       
		        for (int k = 0; k < this.elements.length; k++) 
		        {
		            int x = this.elements[k].getCoordonnees().getAbscisse() - refAbscisse;
		            int y = this.elements[k].getCoordonnees().getOrdonnee() - refOrdonnee;

		            int newAbscisse, newOrdonnee;
		            if (sensHoraire) 
		            {
		                newAbscisse = -y;
		                newOrdonnee = x;   
		            } 
		            else 
		            {
		                newAbscisse = y;
		                newOrdonnee = -x;
		            }
		            int abs = newAbscisse + refAbscisse;
		            int ord = newOrdonnee + refOrdonnee; 
		           
			            tournerExep(abs, ord);
		            	nouvellesCoordonnees[k] = new Coordonnees(abs, ord);
		        }
		        
		        // Nouvelles coordonnées après avoir passé les vérifications
		        for (int k = 0; k < this.elements.length; k++) 
		        {
		            this.elements[k].setCoordonnees(nouvellesCoordonnees[k]);
		        } 
		    }
		}
	 
	 public void tournerExep(int abs, int ord) throws BloxException 
	 {
		 
		 if (this.puits != null)
		 {
			 if (abs < 0 || abs >= puits.getLargeur()) 
		     {
		         throw new BloxException("Sortie impossible du puits", BloxException.BLOX_SORTIE_PUITS);
		     } 
		     else if (ord < 0 || ord >= puits.getProfondeur() || puits.getTas().elementExists(abs, ord)) 	
		     {
		         throw new BloxException("Collision n'est pas possible", BloxException.BLOX_COLLISION);
		     }
		 }
	 }
		  
 }

	 