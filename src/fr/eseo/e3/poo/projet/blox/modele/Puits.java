package fr.eseo.e3.poo.projet.blox.modele;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import fr.eseo.e3.poo.projet.blox.FinDeLaPartie;
import fr.eseo.e3.poo.projet.blox.MyExtenssions;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.UsineDePiece;

public class Puits {

	// Mes constantes
	public static final int LARGEUR_PAR_DEFAUT = 10;
	public static final int PROFONDEUR_PAR_DEFAUT = 20;
	public static final String MODIFICATION_PIECE_ACTUELLE = "Piece actuelle est modifié";
	public static final String MODIFICATION_PIECE_SUIVANTE = "Piece suivante est modifié";

	private static int score = 0;

	// Mes variables
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private int largeur;
	private int profondeur;
	private PropertyChangeSupport pcs;
	private Tas tas;
	private Puits puits;
	private boolean perdu;
	MyExtenssions myExtenssions;

	// Mon constructeur1
	public Puits() {
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
		this.pcs = new PropertyChangeSupport(this.pcs);
	}

	// Mon constructeur2
	public Puits(int largeur, int profondeur) {
		setLargeur(largeur);
		setProfondeur(profondeur);
		this.pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
	}

	// Accesseurs qui me retourne la piece actuelle
	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}

	// Accesseurs qui me retourne la piece suivante
	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}

	// Accesseurs qui me retourne la profondeur
	public int getProfondeur() {
		return this.profondeur;
	}

	// Accesseurs qui me retourne la lageur
	public int getLargeur() {
		return this.largeur;
	}

	// Mutateurs pour modifier la piece actuelle par la nouvelle piece mise en
	// paramettre
	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	// Mutateurs pour modifier la piece suivante par la nouvelle piece mise en
	// paramettre en respectant les condition
	public void setPieceSuivante(Piece piece) {
		Piece pieceAncienneA = this.pieceActuelle;
		Piece pieceAncienneS = this.pieceSuivante;

		if (getPieceSuivante() != null) {
			this.pieceActuelle = this.pieceSuivante;
			this.pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, pieceAncienneA, this.pieceActuelle);
			this.getPieceActuelle().setPosition(this.largeur / 2, -4);
		}

		this.pieceSuivante = piece;
		this.getPieceSuivante().setPuits(this);
		this.pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, pieceAncienneS, this.pieceSuivante);
		// this.pieceSuivante.setPuits(this);
	}

	// Mutateurs pour modifier la profondeur par la nouvelle profondur mise en
	// paramettre en respectant les condition
	public void setProfondeur(int profondeur) throws IllegalArgumentException {
		if (profondeur < 15 || profondeur > 25) {
			throw new IllegalArgumentException("N'est pas possible");
		}

		this.profondeur = profondeur;
		this.pcs = new PropertyChangeSupport(this);
	}

	// Mutateurs pour modifier la largeur par la nouvelle profondur mise en
	// paramettre en respectant les condition
	public void setLargeur(int largeur) throws IllegalArgumentException {
		if (largeur < 5 || largeur > 15) {
			throw new IllegalArgumentException("N'est pas possible");
		}

		this.largeur = largeur;
		this.pcs = new PropertyChangeSupport(this);
	}

	// Mutateurs pour modifier puits par la nouveau puits mise en paramettre
	public void setPuits(Puits puits) {
		this.setPuits(puits);
		this.pcs = new PropertyChangeSupport(this);
	}

	// Mon accesseur me retourne le tas
	public Tas getTas() {
		return this.tas;
	}

	// Mon mutateur me permet de modifié le tas par le tas mise en paramettre
	public void setTas(Tas tas) {
		this.tas = tas;
	}

	public boolean getPerdu() {
		return this.perdu;
	}

	// Pour l'affichage
	@Override
	public String toString() {
		String affichage = "Puits : Dimension " + this.getLargeur() + " x " + this.getProfondeur() + "\n";

		// Cas de la pièce Actuelle
		if (this.pieceActuelle == null)
			affichage += "Piece Actuelle : <aucune>\n";

		else if (this.pieceActuelle != null)
			affichage += "Piece Actuelle : " + this.pieceActuelle.toString();

		// Cas de la pièce suivante
		if (this.pieceSuivante == null)
			affichage += "Piece Suivante : <aucune>\n";
		else
			affichage += "Piece Suivante : " + this.pieceSuivante.toString();

		return affichage;
	}

	// La méthode addPropertyChangeListener me permet d'ajouter un écouteur de
	// changement de propriété
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	// La méthode addPropertyChangeListener me permet supprimer un écouteur de
	// changement de propriété
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	// Mon constructeur
	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		this(largeur, profondeur);
		this.tas = new Tas(this, nbElements, nbLignes);
	}

	
	/*private void gererCollision() {
		if (this.pieceActuelle != null) {
			try {
				
			this.tas.ajouterElements(pieceActuelle);
			this.myExtenssions.suprimerTas();
			this.myExtenssions.scoreOfLabel.setText("Score: " + this.myExtenssions.score);

			this.setPieceSuivante(UsineDePiece.genererTetromino());
			}catch (ArrayIndexOutOfBoundsException e) {
				new FinDeLaPartie();				
				
			}
		}
	}*/
	
	
	// Gestion de collision
	private void gererCollision() {

		this.getTas().ajouterElements(pieceActuelle);

		this.setPieceSuivante(UsineDePiece.genererTetromino());
		//this.tas.ajouterElements(pieceActuelle);
		//this.myExtenssions.suprimerTas();
		//this.myExtenssions.scoreOfLabel.setText("Score: " + this.myExtenssions.score);

		//FinDeLaPartie finiDuJeux = new FinDeLaPartie();
		//System.out.println("La partie est terminer");
	}

	// La méthode pour appliquer la gravité :
	public void gravite() {
		try {
			pieceActuelle.deplacerDe(0, 1); // Déplacer la pièce d'une case vers le bas
		} catch (BloxException e) {
			gererCollision(); // La collision
		}
	}

	public MyExtenssions getExtenssions() {
		return this.myExtenssions;
	}

	public void monterScore(int d) {
		this.score = this.score + d;
	}

	public int getScore() {
		return this.getScore();
	}

}
