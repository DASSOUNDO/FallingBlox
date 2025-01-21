package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BoutonDirection extends KeyAdapter {
	
	private Puits puits;
	private VuePuits vuePuits;

	public BoutonDirection(VuePuits vuePuits)
	{
		this.vuePuits = vuePuits;
		puits = this.vuePuits.getPuits();
	}
	
	/*public void boutonO (KeyEvent e) throws IllegalArgumentException, BloxException 
	{
		int event = e.getKeyCode();
		 
		if (event == KeyEvent.VK_Q )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }

		   if (event == KeyEvent.VK_LEFT )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }
		   
		   else if(event == KeyEvent.VK_D)
		   {
			   this.puits.getPieceActuelle().deplacerDe(1, 0);
		   }
		   
		   if (event == KeyEvent.VK_RIGHT )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }
	}*/
	
	public void keyPressed (KeyEvent e) 
	{
		System.out.println(" ");
		try {
		int event =e.getKeyCode();
		System.out.println("ndwfvj kwbf");
		//bouton(e);
			
		  if (event == KeyEvent.VK_Q )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }

		   /*if (event == KeyEvent.VK_LEFT )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }*/
		   
		   else if(event == KeyEvent.VK_D)
		   {
			   this.puits.getPieceActuelle().deplacerDe(1, 0);
		   }
		   
		   /*if (event == KeyEvent.VK_RIGHT )
		   {
			  this.puits.getPieceActuelle().deplacerDe(-1, 0);
		   }*/
		   
		   if(event == KeyEvent.VK_W)
		   {
			   this.puits.getPieceActuelle().deplacerDe(0, 1);
		   }
		   
		   else if(event == KeyEvent.VK_DOWN)
		   {
			   this.puits.getPieceActuelle().tourner(false);
		   }
		    
		   else if(event == KeyEvent.VK_UP)
		   {
			   this.puits.getPieceActuelle().tourner(true);
		   }
		   	   vuePuits.repaint();	
	}
		
		catch (BloxException ev) {
			
		}
	}
		   
		   
		   
		  /* public void keyPressed (KeyEvent e) 
			{
				
				try {
				
					switch (e.getKeyCode())
					{
					case KeyEvent.VK_Q:
					case KeyEvent.VK_LEFT:
						
						this.puits.getPieceActuelle().deplacerDe(-1, 0);
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
						
						this.puits.getPieceActuelle().deplacerDe(1, 0);
						break;
						
					case KeyEvent.VK_W:
						
						this.puits.getPieceActuelle().deplacerDe(0, 1);
						break;
						
					case KeyEvent.VK_DOWN:
					
						this.puits.getPieceActuelle().tourner(false);
						break;
						
					case KeyEvent.VK_UP:
						
						this.puits.getPieceActuelle().tourner(true);
						break;
						
						default:
							break;
					}
					  this.vuePuits.repaint();
			   	     // vuePuits.repaint();	
			}
				
				catch (BloxException ev) {
					
				}
			}*/

	/*@Override
	public void keyPressed(KeyEvent e) {
	    try {
	    	bouton(e);
	    } catch (IllegalArgumentException ex) {
	        ex.printStackTrace();
	    }
	}*/

	
	/*@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		System.out.println(e);
	}*/
	
	
	
	
}
