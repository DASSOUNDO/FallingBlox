
package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {
	
    public static final int BLOX_COLLISION = 0;
    public static final int BLOX_SORTIE_PUITS = 1;
	
    
    private  int type; 

    // Mon constructeur :
    public BloxException(String message, int type) 
    {
        super(message); 	// Appelle le constructeur de la classe mère (Exception) avec le message spécifié
        this.type = type;
    }

    public int getType() // Mon accesseur me permet d'obtenir le type de l'exception.
    {
        return type;
    }
}