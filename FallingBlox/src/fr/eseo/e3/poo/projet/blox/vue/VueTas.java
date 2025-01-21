package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

    public static final double MULTIPLIER_NUANCE = 0.4;  // Constante MULTIPLIER_NUANCE
    private final VuePuits vuePuits;
    private final Tas tas;
	private int taille; 

	// Mon constructeur 
    public VueTas(VuePuits vuePuits)  
    {
        this.vuePuits = vuePuits;
        this.taille = vuePuits.getTaille();
        this.tas = vuePuits.getPuits().getTas(); 
    }

    // Application de la nuance 
    public static Color nuance(Color couleur) 
    {  
        int rouge = couleur.getRed();
        int vert = couleur.getGreen();
        int bleu = couleur.getBlue();

        rouge = (int) (rouge * (1 - MULTIPLIER_NUANCE));
        vert = (int) (vert * (1 - MULTIPLIER_NUANCE));
        bleu = (int) (bleu * (1 - MULTIPLIER_NUANCE));
        return new Color(rouge, vert, bleu); 

    }
    
    // Ma méthode publique pour afficher quelque chose en utilisant Graphics2D
    public void afficher(Graphics2D g) 
    {
        if (this.tas != null) 
        {
            List<Element> elements = this.tas.getElements(); // Obtient la liste de mes éléments
            for (Element element : elements) 				// Parcourt chaque élément de la liste
            { 												
                if (element != null)
                {
                										// Application de la nuance sur l'élément dessine
                    g.setColor(nuance(element.getCouleur().getCouleurPourAffichage()));

                    								// Dessine l'élément en utilisant fill3DRect
                    g.fill3DRect(
                        element.getCoordonnees().getAbscisse() * this.vuePuits.getTaille(), 
                        element.getCoordonnees().getOrdonnee() * this.vuePuits.getTaille(), 
                        this.vuePuits.getTaille(), 
                        this.vuePuits.getTaille(),
                        false 
                    );
                }
            }
        }
    }

    // Mon accesseur me permet d'obtenir l'objet VuePuits associé à cette instance. 
    public VuePuits getVuePuits() 
    {
        return this.vuePuits;
    }

}
