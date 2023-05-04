package it.prova.gestionesocieta.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService{

	@Autowired
	private DipendenteRepository dipendenteRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Dipendente> listAllDipendenti() {
		return(List<Dipendente>) dipendenteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Dipendente caricaSingoloDipendente(Long id) {
		return dipendenteRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiornaDipendente(Dipendente dipendenteInstance) {
		dipendenteRepository.save(dipendenteInstance);
	}

	@Transactional
	public void inserisciDipendente(Dipendente dipendenteInstance) {
		dipendenteRepository.save(dipendenteInstance);
	}

	@Transactional
	public void rimuoviDipendente(Dipendente dipendenteInstance) {
		dipendenteRepository.delete(dipendenteInstance);
	}

	@Transactional
	public List<Dipendente> findByExampleDipendente(Dipendente example) {
		String query = "select d from Dipendente d where d.id = d.id ";

		if (StringUtils.isNotEmpty(example.getNome()))
			query += " and d.nome like '%" + example.getNome() + "%' ";
		if (StringUtils.isNotEmpty(example.getCognome()))
			query += " and d.cognome like '%" + example.getCognome() + "%' ";
		if (example.getDataAssunzione() != null)
			query += " and d.dataAssunzione = " + example.getDataAssunzione();
		if (example.getRedditoAnnuoLordo() != null && example.getRedditoAnnuoLordo() > 0)
			query += " and d.redditoAnnuoLordo = " + example.getRedditoAnnuoLordo();

		return entityManager.createQuery(query, Dipendente.class).getResultList();
	}


}
