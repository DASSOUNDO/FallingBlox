package fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos;

import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class JTetromino extends Tetromino {

	public JTetromino(Coordonnees coordonneesRef, Couleur couleurRef) 
	{
		super(coordonneesRef, couleurRef);
		setElements(coordonneesRef, couleurRef);
	}

	@Override
	public Color getCouleurPourAffichage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setElements(Coordonnees coordonneesRef, Couleur couleurRef)  
	{
		super.getElements()[0] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee(), couleurRef);
		super.getElements()[1] = new Element(coordonneesRef.getAbscisse()-1, coordonneesRef.getOrdonnee(), couleurRef);
		super.getElements()[2] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()-1, couleurRef);
		super.getElements()[3] = new Element(coordonneesRef.getAbscisse(), coordonneesRef.getOrdonnee()-2, couleurRef);
	}
	
	public String toString() 
	{
		return "JTetromino"+super.toString();
	}


	@Override
	public boolean collisionDetected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reachedBottom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tetromino changerCouleur(Couleur couleur) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
