package it.prova.gestionesocieta.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;

@Service
public class SocietaServiceImpl implements SocietaService {

	@Autowired
	private SocietaRepository societaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Societa> listAllSocieta() {
		return(List<Societa>) societaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Societa caricaSingolaSocieta(Long id) {
		return societaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiornaSocieta(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void inserisciSocieta(Societa societaInstance) {
		societaRepository.save(societaInstance);
	}

	@Transactional
	public void rimuoviSocieta(Societa societaInstance) {
		societaRepository.delete(societaInstance);
	}

	@Transactional
	public List<Societa> findByExampleSocieta(Societa example) {
		String query = "select s from Societa s where s.id = s.id ";

		if (StringUtils.isNotEmpty(example.getRagioneSociale()))
			query += " and s.ragioneSociale like '%" + example.getRagioneSociale() + "%' ";
		if (StringUtils.isNotEmpty(example.getIndirizzo()))
			query += " and s.indirizzo like '%" + example.getIndirizzo() + "%' ";
		if (example.getDataFondazione() != null)
			query += " and s.dataFondazione = " + example.getDataFondazione();

		return entityManager.createQuery(query, Societa.class).getResultList();
	}
	

}
