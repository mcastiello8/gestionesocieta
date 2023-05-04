package it.prova.gestionesocieta.service;

import java.time.LocalDate;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionesocieta.model.Societa;

@Service
public class BatteriaDiTestService {
	
	@Autowired
	private SocietaService societaService;
	
	@Autowired
	private DipendenteService dipendenteService;
	
	public void testInserisciNuovaSocieta() {
		
		Societa gameStop = new Societa("GameStop", "Via Buonvento 55", LocalDate.now());
		
		societaService.inserisciSocieta(gameStop);
		if(gameStop.getId()==null || gameStop.getId() < 1)
			throw new RuntimeException("testInserisciNuovaSocieta fallito: inserimento fallito");
		
		Societa bershka = new Societa("Bershka", "Via delle Rose 21", LocalDate.of(2002, 10, 12));
		
		societaService.inserisciSocieta(bershka);
		if(bershka.getId()==null || bershka.getId() < 1)
			throw new RuntimeException("testInserisciNuovaSocieta fallito: inserimento fallito");
		
		
		System.out.println("testInserisciNuovaSocieta........OK");
	}

}
