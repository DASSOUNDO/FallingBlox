package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class OTetromino extends Tetromino{
	 
	
    // Factorisation
	public OTetromino(Coordonnees coordonneesRef, Couleur couleurRef) 
	{
		super(coordonneesRef, couleurRef);
		setElements(coordonneesRef, couleurRef);
	}

	// Pour remplir le tableau des Elements avec quatre nouvelles instances de la classe
	// -->Element en utilisant la couleur et les coordonnees de référence passée en argument                                
	protected void setElements(Coordonnees coordonneesRef, Couleur couleurRef) 
	{
		super.getElements()[0] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee(), couleurRef);
		super.getElements()[1] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()-1, couleurRef);
		super.getElements()[2] = new Element(coordonneesRef.getAbscisse()+1, coordonneesRef.getOrdonnee()-1, couleurRef);
		super.getElements()[3] = new Element(coordonneesRef.getAbscisse()+1, coordonneesRef.getOrdonnee(), couleurRef);
	}
	
	//Affichage
	public String toString() 
	{
		return "OTetromino"+super.toString();
	} 

	@Override
	public Color getCouleurPourAffichage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void tourner(boolean sensHoraire) 
	{
        // On ne faire rien ici car OTetromino ne peut pas tourner.
    }

	@Override
	public boolean collisionDetected() 
	{
		return false;
	}

	@Override
	public boolean reachedBottom() 
	{
		return false;
	}

	@Override
	public Tetromino changerCouleur(Couleur couleur) {
		// TODO Auto-generated method stub
		return null;
	}
}



	
	
	
