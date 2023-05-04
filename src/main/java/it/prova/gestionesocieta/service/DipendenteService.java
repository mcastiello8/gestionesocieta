package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Dipendente;


public interface DipendenteService {
	
	public List<Dipendente> listAllDipendenti();

	public Dipendente caricaSingoloDipendente(Long id);

	public void aggiornaDipendente(Dipendente dipendenteInstance);

	public void inserisciDipendente(Dipendente dipendenteInstance);

	public void rimuoviDipendente(Dipendente dipendenteInstance);

	public List<Dipendente> findByExampleDipendente(Dipendente example);

}
