package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

	// Mes variable : 
    private VuePiece vuePiece;
    private final Puits puits;
    private int score = 0;
    // Constructeur de ma classe PanneauInformation.
    public PanneauInformation(Puits puits) 
    {
        this.puits = puits;
        this.puits.addPropertyChangeListener(this); // Enregistrement en tant que PropertyChangeListener
        this.setPreferredSize(new Dimension(70, 70)); // Ajustement de la taille
    }
    
    /*String chaine;
    public void Puits(String chaine)
    { 
    	this.chaine = chaine;
    }*/
    
    public PanneauInformation(String score)
    {
    	String chaine3 = "Score :";
		this.puits = new Puits();
		
		//this.puits.addPropertyChangeListener(chaine3); 
        this.setPreferredSize(new Dimension(78, 78));
    }

    // La méthode est appelé lorsqu'un événement de changement de propriété est détecté.
    @Override
    public void propertyChange(PropertyChangeEvent e)
    {
        if (e.getPropertyName().equals(puits.MODIFICATION_PIECE_SUIVANTE)) 
        {
            Piece nouvellePiece = (Piece) e.getNewValue();
	   
	        if(nouvellePiece != null)
	        {
	            this.vuePiece = new VuePiece(nouvellePiece, 10);
	            repaint();
	        }
        }
    }
    
    // La méthode protégée est appelée pour dessiner les composants
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        //
        //Graphics2D g2D2 = (Graphics2D) g.create();
        //g2D2.drawString("Score :" +this.puits.getScore(), 5, 150);
        
        
        Graphics2D g2D = (Graphics2D) g.create();
//		g2D.setClip(Couleur.JAUNE);
//         g2D.setColor(Color.BLEU);
//         g2D.drawRect(2, 120, 65, 65);
        
         
//         g2D.setColor(Color.BLEU);
        
        if (vuePiece != null) 
        {
            vuePiece.afficherPiece((Graphics2D) g);
        }
        g2D.drawString("Score :" +this.score, 6, 100);
        g2D.dispose();
		repaint();
    }
    	
}