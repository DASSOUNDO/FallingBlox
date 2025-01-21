package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {

	// Mes variable
	private Timer timer;
	private final VuePuits vuePuits;
	private final Puits puits;
	private int periodicite;

	// Mon constructeur de la classe Gravite
	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.periodicite = 2000;
		this.timer = new Timer(periodicite, this);
		this.timer.start();
	}

	// Mes accesseur pour obtenir la périodicité actuelle du timer
	public int getPeriodicite() {
		return this.periodicite;
	}

	// Mon mutateur pour définir la périodicité du timer avec la nouvelle valeur
	// passée en paramètre
	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
		this.timer.setDelay(periodicite);
	}

	// Ma méthode est appele lorsqu'un événement est déclenché par le Timer
	public void actionPerformed(ActionEvent event) {
		this.puits.gravite();
		this.vuePuits.repaint();
	}

	// Mon accesseur pour obtenir l'objet Timer utilisé pour déclencher les
	// événements périodiques
	public Timer getTimer() {
		return this.timer;
	}

}
