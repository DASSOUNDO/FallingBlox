package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.awt.Color;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.tetrominos.Tetromino;

public interface Piece {

	public Element[] getElements();

	public void setPosition(int abscisse, int ordonnee);

	public Puits getPuits();

	public void setPuits(Puits puits);

	public Color getCouleurPourAffichage();

	public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException;

	public void tourner(boolean sensHoraire) throws BloxException;

	boolean collisionDetected();

	boolean reachedBottom();

	public abstract Tetromino changerCouleur(Couleur couleur);
}
