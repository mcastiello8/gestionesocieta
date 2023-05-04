package it.prova.gestionesocieta.service;

import java.util.List;

import it.prova.gestionesocieta.model.Societa;


public interface SocietaService {

	public List<Societa> listAllSocieta() ;

	public Societa caricaSingolaSocieta(Long id);

	public void aggiornaSocieta(Societa societaInstance);

	public void inserisciSocieta(Societa societaInstance);

	public void rimuoviSocieta(Societa societaInstance);

	public List<Societa> findByExampleSocieta(Societa example);
	
	
	
	
}
