package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {

	private int abscisse;
	private int ordonnee;

	// Constructeur pour les coordonnees
	public Coordonnees(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	// Accesseurs pour l'abscisse
	public int getAbscisse() {
		return this.abscisse;
	}

	// Accesseurs pour l'ordonnee
	public int getOrdonnee() {
		return this.ordonnee;
	}

	// Mutateurs pour modifier l'abscisse
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	// Mutateurs pour modifier l'ordonnee
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	// Afficher l'abcisse et l'ordonnee
	@Override
	public String toString() {
		return "(" + this.abscisse + ", " + this.ordonnee + ")";
	}

	//
	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Coordonnees other = (Coordonnees) obj;

		return this.abscisse == other.abscisse && this.ordonnee == other.ordonnee;
	}
}
