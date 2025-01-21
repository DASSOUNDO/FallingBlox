package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

	@Test
	void test1() {
		Puits p = new Puits(10, 20);
		VuePuits vp = new VuePuits(p, 4);
		 
		assertEquals(10, p.getLargeur(), "Lageur incorrect");
		assertEquals(20, p.getProfondeur(), "Profondeur incorrect");
		assertEquals(4, vp.getTaille(), "La taille est incorrect");
		//assertEquals(4, p..getTaille(), "Lageur incorrect");
		 
	}

}







