package fr.eseo.e3.poo.projet.blox;

import java.util.List;

import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class MyExtenssions {
	
	private Puits puits;
	public int ligneSc;
	public int score;
	
	public  int bonScore;
	public int lignesDelet = 0;
	public int myCompteurOfLigne = 0;
	
	
	public JLabel scoreOfLabel = new JLabel("Le Score: 0");
	public JLabel bonScoreLabel = new JLabel("Le meilleur score: 0");
	//public Component scoreLabel;   
	
	 public MyExtenssions(Puits puits)
	 {
		this.puits = puits;
		this.score = 0;
		this.bonScore = 0;
		this.lignesDelet = 0;
		this.ligneSc = 0;
	 }

	 public int getScore() 
	 {
			return this.score;
	 }
	   
	 
	 public void suprimerTas() 
	 {
			int ligneDeFin = this.puits.getTas().getPuits().getProfondeur() - 1;
			boolean ligneComplet = false;
			boolean estComplet = true;
			
			for (int k = ligneDeFin; k >= 0; k--) {
			    estComplet = true;
			    
			    List<Element> elements = (List<Element>) this.puits.getTas().getElements().get(k);
			    int largeur = this.puits.getTas().getPuits().getLargeur();

			    for (int i = 0; i < largeur; i++) {
			        if (this.puits.getTas().getElements().get(i) == null  
			        		&& this.puits.getTas().getElements().get(k) == null){
			        	
			            estComplet = false;
			            
			        } else {
			            break;
			        }
			    }
			    if(estComplet) { 
					int supr = suprimeLigne(k);
					ligneSc++; // Incrémente le nombre de lignes supprimées
					ligneComplet = true;
					lignesDelet += ligneSc;
				}
			    if(ligneComplet) {
			    	
			    	miseAJourScore(ligneSc); // met à jour le score en fonction du nombre de lignes supprimées
			    	suprimerTas();
			    	ligneSc = 0;
					this.myCompteurOfLigne++;
					bonScoreLabel.setText("Score : " + this.score);
					ligneSc = 0;   
			}      
 	
		} 
	}
	 
	public int suprimeLigne(int a) { 
		
	 for (int b = a; b > 0; b--) 
	 {
		    List<Element> elements1 = (List<Element>) this.puits.getTas().getElements().get(b);
		    int largeur = puits.getTas().getPuits().getLargeur();

		    for (int c = 0; c < largeur; c++) {
		    	List<Element> elements2 = (List<Element>) this.puits.getTas().getElements().get(b - 1).get(c);
		    	List<Element> elements3 =  (List<Element>) elements1.get(c);
		    	elements3 =  elements2;
		    	
		       // this.puits.getTas().getElements().get(b) = this.puits.getTas().getElements()get(b - 1);//[c];
		    }
	 }
		    
		    for (int c = 0; c < this.puits.getTas().getPuits().getLargeur(); c++) {
		    	List<Element> elements4 = (List<Element>) this.puits.getTas().getElements().get(0);
		    	List<Element> elements5 =  (List<Element>) elements4.get(c);
				elements5 = null;
				
			}
		     			return 0;
	}
	
	

	public void changementDeLaPiece() 
	{
		Coordonnees o = this.puits.getPieceActuelle().getElements()[0].getCoordonnees();
		
		if (puits.getPieceActuelle() != null && puits.getPieceSuivante() != null) 
		{
			puits.setPieceSuivante(this.puits.getPieceActuelle());
			puits.getPieceActuelle().setPosition(o.getAbscisse(),o.getOrdonnee());
			puits.getPieceSuivante().setPosition( 2,3);
  
		}
	}
	
	
	public void miseAJourScore(int p) 
	{
		int somme = 0;
		
		if( p == 1)
		{
			somme = 10;
		}
		else if(p == 2)
		{
			somme = 20;
		}
		else if(p == 3)
		{
			somme = 30;
		}
		else if(p == 4)
		{
			somme = 50;
		}
		else
		{
			somme = 0;
		} 
		
		this.score += somme;
		if(this.score > bonScore)
			this.bonScore = score;
	}
		
		
}

	
	/*public void miseAJourScore1(int p) {
		int points = 0;
		switch (p) {
		case 1:
			points = 10;
			break; 
		case 2:
			points = 25;
			break;
		case 3:
			points = 50;
			break;
		case 4:
			points = 100;
			break;
		default:
			break;
		}
		this.score += points;
		if(this.score > bonScore)
			this.bonScore = score;
	}*/


