package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.BoutonDirection;
import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
//import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;


public class VuePuits extends JPanel implements PropertyChangeListener { 

	public static final int TAILLE_PAR_DEFAUT = 15;
	public static final long serialVersionUID = 1L; 
	private Puits puits;
	private int taille;
	private VuePiece vuePiece;
	private PieceDeplacement pieceDeplacement;
	private PieceRotation rotation;
	private final VueTas vueTas;
	private Gravite gravite;
	private Graphics graphique;
	private VuePuits vuePuits;
	private BoutonDirection clavier;
	 

	public VuePuits(Puits puits) 
	{
		this(puits, TAILLE_PAR_DEFAUT); 
	}
	
	public VuePuits(Puits puits, int taille) 	
	{
       this.setPuits(puits); 
   	   this.taille=taille;
   	   this.setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
	   this.vuePiece = null;
	 		
	   this.setBackground(Color.WHITE);
		
	   pieceDeplacement = new PieceDeplacement(this);
	   this.addMouseMotionListener(pieceDeplacement);                
	   this.addMouseListener(pieceDeplacement);                        
	   this.addMouseWheelListener(pieceDeplacement);   
	 
	   rotation = new PieceRotation(this);        
	   this.addMouseListener(rotation); 
	   
	   this.vueTas = new VueTas(this);
	   
	  
		
	   repaint();
	}
	
	
	public Puits getPuits() 
	{
		return this.puits;
	}

	public int getTaille() 
	{
		return this.taille;
	}
		
	// La méthode me permet d'instancier puits associée.
	public void setPuits(Puits puits) 
	{
		if (getPuits() != null) 
		{
			getPuits().removePropertyChangeListener(this);
		}

		this.puits = puits;
		setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
		this.puits.addPropertyChangeListener(this);
		
		// Vérifie si une pièce de déplacement existe déjà
		if (pieceDeplacement != null)  
		{
			// Supprime les écouteurs d'événements de la souris de l'ancienne pièce de déplacement                        
			this.removeMouseListener(pieceDeplacement);
			this.removeMouseWheelListener(pieceDeplacement);
			this.removeMouseMotionListener(pieceDeplacement);                 
			
			// Crée une nouvelle instance de pièce de déplacement 
			pieceDeplacement = new PieceDeplacement(this);
	
			// Ajoute les écouteurs d'événements de la souris à la nouvelle pièce de déplacement
			this.addMouseMotionListener(pieceDeplacement);
			this.addMouseListener(pieceDeplacement);
			this.addMouseWheelListener(pieceDeplacement);
			
			clavier  = new BoutonDirection(this); 
			this.addKeyListener(clavier);
			
	} 
		  
		// Condition pour géré la rotation de ma pièce.
		if (rotation != null)
		{
			this.removeMouseListener(rotation);
			rotation = new PieceRotation(this);
			this.addMouseListener(rotation);
		}
	   
	}

	// Permet de modifier la taiile
	public void setTaille(int taille) 
	{
		this.taille = taille;
		setPreferredSize(new Dimension(puits.getLargeur() * taille, puits.getProfondeur() * taille));
		repaint();
	}
	
	// Accesseur --> return  vuePiece
	public VuePiece getVuePiece() 
	{
        return this.vuePiece; 
    }
	
	// Accesseur --> return  vueTas
	public VueTas getVueTas()
	{
		return getVueTas();
	}
	
	// Mutateur permet la modification --> vuePiece
    private void setVuePiece(VuePiece vuePiece) 
    {
        this.vuePiece = vuePiece;
    }
	
    // Cette méthode est appelée pour dessiner les composants --> (vuePiece, vueTas ..)
	protected void paintComponent(Graphics graph) 
	{ 
		super.paintComponent(graph);
		this.setBackground(Color.WHITE);
		Graphics2D g2D = (Graphics2D) graph.create();  

		// creer les lignes pour le cadrillage 
		int maLargeur = (int) getPreferredSize().getWidth();
		int maProfondeur = (int) getPreferredSize().getHeight();
		
		g2D.setColor(Color.LIGHT_GRAY);
		
		for(int i = 0; i <= maLargeur; i+=taille) 
		{
			g2D.drawLine(i, 0, i, maProfondeur);    
		}        
		
		for(int i = 0; i <= maProfondeur; i+=taille) 
		{
			g2D.drawLine(0, i, maLargeur, i);
		}
		
		if (this.vueTas != null)  
		{
			this.vueTas.afficher(g2D);
		}
		
		// Pour dessine la VuePiece
		if (vuePiece != null)   
		{
	        vuePiece.afficherPiece(g2D);
	    }
		
		if (vueTas != null)  
		{
	        vueTas.afficher(g2D);
	    }
		
		g2D.dispose();
		
	}
	
	public void supprimerPuits(Graphics g2D)
	{
		int maLargeur = (int) getPreferredSize().getWidth();
		int maProfondeur = (int) getPreferredSize().getHeight();
		
			for(int i = 0; i <= maLargeur; i+=taille) 
			{
				g2D.clearRect(i, 0, i, maProfondeur);    
			}  
	
			for(int i = 0; i <= maProfondeur; i+=taille) 
			{
				g2D.clearRect(0, i, maLargeur, i);
			}
	}
	
	
	// La méthode est appelé lorsqu'un changement de propriété est détecté.
	public void propertyChange(PropertyChangeEvent event) 
	{
		String name = event.getPropertyName();
		if (name.equals(Puits.MODIFICATION_PIECE_ACTUELLE)) 
		{
			Piece newPiece = (Piece) event.getNewValue();
			if (newPiece != null) 
			{
				VuePiece newVuePiece = new VuePiece(newPiece, this.getTaille());
				this.setVuePiece(newVuePiece);
			}
		}
	}

	public Gravite getGravite() 
	{
		return this.gravite;
	}		
}
