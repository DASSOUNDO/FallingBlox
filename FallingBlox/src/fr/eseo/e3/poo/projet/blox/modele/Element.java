package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
		
		// Mes variableS
		private Coordonnees coordonnees;
		private Couleur couleur;
		
		// Mon constructeur1 de ma classe Element
		public Element(Coordonnees coordonnees)
		{
			this(coordonnees, Couleur.values()[0]);
		}
		 
		// Mon constructeur2 de ma classe Element
		public Element(int abscisse, int ordonnee)
		{
			this(new Coordonnees(abscisse, ordonnee), Couleur.values()[0]);
		} 
		
		// Mon constructeur3 de ma classe Element
		public Element(Coordonnees coordonnees, Couleur couleur)
		{
			this.coordonnees = coordonnees;
			this.couleur = couleur;
		}
		
		// Mon constructeur4 de ma classe Element
		public Element(int abscisse, int ordonnee, Couleur couleur)
		{
			this(new Coordonnees(abscisse, ordonnee), couleur);
		}
		
		// Accesseurs pour les coordonnees
		public Coordonnees getCoordonnees()
		{
			return this.coordonnees;
		}
		
		// Accesseurs pour les couleurs
		public Couleur getCouleur()
		{
			return this.couleur;
		}
		
		// Mutateurs pour modifier le coordonnees
		public void setCoordonnees(Coordonnees coordonnees)
		{
			this.coordonnees = coordonnees;
		}
		
		// Mutateurs pour modifier couleur
		public void setCouleur(Couleur couleur)
		{
			this.couleur = couleur;
		}

		@Override
		public String toString() 
		{
			return this.coordonnees+" - "+this.couleur;
		}

		@Override
		public int hashCode() 
		{
			return Objects.hash(coordonnees, couleur);
		}
		
		// Ma méthode deplacerDe() me permet de me déplacer a un une autre coordonnees.
		public void deplacerDe(int deltaX, int deltaY) 
		{
			this.setCoordonnees(new Coordonnees(
				this.getCoordonnees().getAbscisse()
						+deltaX,this.getCoordonnees().
								getOrdonnee()+deltaY));
	    } 

		@Override
		public boolean equals(Object obj) 
		{
			if (this == obj)
				
				return true;
			 
			if (obj == null)
				 
				return false;
			
			if (getClass() != obj.getClass())
				
				return false;
			
			Element other = (Element) obj;
			
			return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
		}

		public Object get(int c) {
			// TODO Auto-generated method stub
			return null;
		}
		
		  
	}