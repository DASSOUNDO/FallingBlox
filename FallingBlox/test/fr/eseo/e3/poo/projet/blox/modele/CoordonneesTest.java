package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoordonneesTest { 

	@Test
	public void testConstructeurCoordonnees() 
	{
		
		Coordonnees coor = new Coordonnees(2, 4);
		
		assertEquals(2,coor.getAbscisse(),"abcisse n'est pas valide");
		assertEquals(4,coor.getOrdonnee(),"Ordonnee n'est pas valide");
	} 
	
	@Test
	public void testMutateurCoordonnees() 
	{
		
		Coordonnees coor = new Coordonnees(2, 4);
		coor.setAbscisse(5);
		coor.setOrdonnee(10);
		
		assertEquals(5,coor.getAbscisse(),"abcisse n'est pas correcte");
		assertEquals(10,coor.getOrdonnee(),"Ordonnee n'est pas correcte");
	}
	
	@Test
	public void testToStringCoordonnees() 
	{
		
		Coordonnees coor1 = new Coordonnees(4, 8);
		
		assertEquals("(4, 8)", coor1.toString(),"Affichage incorrecte");
	}
	
	@Test
	public void testHashCode() 
	{
		
		Coordonnees coor1 = new Coordonnees(4, 8);
		Coordonnees coor2 = new Coordonnees(4, 8);
		Coordonnees coor3 = new Coordonnees(4, 6);
		Coordonnees coor4 = new Coordonnees(1, 8);
			
		System.out.println(coor1.hashCode());
		System.out.println(coor2.hashCode());
		System.out.println(coor3.hashCode());
		System.out.println(coor4.hashCode());
		
		assertEquals(1093, coor1.hashCode(), "1093 n,est pas la bonne valeur");
		assertEquals(1091, coor3.hashCode(), "1091 n,est pas la bonne valeur");
		assertEquals(1000, coor4.hashCode(), "1000 n,est pas la bonne valeur");
		assertEquals("(4, 8)", coor1.toString(),"Affichage incorrecte");
		assertFalse(coor1.equals(null));
		assertTrue(coor1.equals(coor2),"N'est pas égal");
		
		coor1.equals("1093");
		coor2.equals(coor3);
		coor2.equals(coor4); 
		coor2.equals(coor1);
		
	}
	
}


