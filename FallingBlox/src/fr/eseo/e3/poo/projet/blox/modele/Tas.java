
package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {

	private List<Element> elements;
	private Puits puits;

	// Constructeur1
	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new ArrayList<>();
	}

	// Constructeur2
	public Tas(Puits puits, int nbElements, int nbLignes) {
		this(puits);
		construireTas(nbElements, nbLignes, new Random());
	}

	// Constructeur3
	public Tas(Puits puits, int nbElements) {
		this(puits, nbElements, (nbElements / puits.getLargeur()) + 1);
	}

	public Tas(Puits puits, int nbElements, int nbLignes, Random r) {

	}

	// Mon accesseuer me retourne ma listen d'élément
	public List<Element> getElements() {
		return elements;
	}

	// Mon accesseur me retourne le puits
	public Puits getPuits() {
		return puits;
	}

	// Méthode privée pour construire mon tas d'éléments avec un nombre spécifié
	// d'éléments et de lignes.
	private void construireTas(int nbElements, int nbLignes, Random rand) {
		if (nbElements != 0 && nbElements > puits.getLargeur() * nbLignes) {
			throw new IllegalArgumentException("Nb éléments plus bcp grand pour le tas");
		} else {
			int elementsPose = 0;
			while (elementsPose < nbElements) {
				int ordonnee = puits.getProfondeur() - rand.nextInt(nbLignes) - 1;
				int abscisse = rand.nextInt(puits.getLargeur());

				if (!elementExists(abscisse, ordonnee)) {
					Element newElement = new Element(new Coordonnees(abscisse, ordonnee),
							Couleur.values()[rand.nextInt(Couleur.values().length)]);

					elements.add(newElement);
					elementsPose++;
				}
			}
		}
	}

	// Vérifie si un élément existe aux coordonnées spécifiées.
	public boolean elementExists(int abs, int ord) {
		// return elements.stream().anyMatch(e -> e.getCoordonnees().getAbscisse() ==
		// abs && e.getCoordonnees().getOrdonnee() == ord);
		for (int i = 0; i < elements.size(); i++) {
			Element e = elements.get(i);
			if (e.getCoordonnees().getAbscisse() == abs && e.getCoordonnees().getOrdonnee() == ord) {
				return true;
			}
		}
		return false;
	}

	// Ma méthode me permet d'ajouter des pièces
	public void ajouterElements(Piece piece) {
		if (piece != null) {
			for (Element element : piece.getElements()) {
				int abscisse = element.getCoordonnees().getAbscisse();
				int ordonnee = element.getCoordonnees().getOrdonnee();

				if (!elementExists(abscisse, ordonnee)) {
					elements.add(element);
				}
			}
		}
	}
}
