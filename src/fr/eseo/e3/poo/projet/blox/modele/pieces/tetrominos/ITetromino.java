package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class ITetromino extends Tetromino {
	
	// Mon constructeur
	public ITetromino(Coordonnees coordonneesRef, Couleur couleurRef) 
	{
		super(coordonneesRef, couleurRef);
		setElements(coordonneesRef, couleurRef);
	}

	// La méthode protégée définir les éléments à une position donnée avec une couleur donnée.
	@Override
	protected void setElements(Coordonnees coordonneesRef, Couleur couleurRef)  
	{
		super.getElements()[0] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee(), couleurRef);
		super.getElements()[1] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()+1, couleurRef);
		super.getElements()[2] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()-1, couleurRef);
		super.getElements()[3] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()-2, couleurRef);
	}
	
	//Affichage 
	public String toString() 
	{
		return "ITetromino"+super.toString();
	}

	// La méthode permet d'obtenir la couleur appropriée pour l'affichage.
	@Override 
	public Color getCouleurPourAffichage() 
	{
		return null;
	}

	// Vérifie s'il y a une collision détectée avec cet élément.
	@Override
	public boolean collisionDetected() 
	{
		return false;
	}

	// Vérifie si cet élément a atteint le bas de son emplacement.
	@Override
	public boolean reachedBottom() 
	{
		return false;
	}

	@Override
	public Tetromino changerCouleur(Couleur couleur) {
		
		return null;
	}

}


