package it.prova.gestionesocieta.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dipendente")
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dataAssunzione")
	private LocalDate dataAssunzione;
	@Column(name = "redditoAnnuoLordo")
	private Integer redditoAnnuoLordo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "societa_id",nullable = false)
	private Societa societa;
	
	
	public Dipendente(String nome, String cognome, LocalDate dataAssunzione, Integer redditoAnnuoLordo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataAssunzione = dataAssunzione;
		this.redditoAnnuoLordo = redditoAnnuoLordo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}


	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}


	public Integer getRedditoAnnuoLordo() {
		return redditoAnnuoLordo;
	}


	public void setRedditoAnnuoLordo(Integer redditoAnnuoLordo) {
		this.redditoAnnuoLordo = redditoAnnuoLordo;
	}


	public Societa getSocieta() {
		return societa;
	}


	public void setSocieta(Societa societa) {
		this.societa = societa;
	}


	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataAssunzione=" + dataAssunzione
				+ ", redditoAnnuoLordo=" + redditoAnnuoLordo + "]";
	}

	
	
	
	
}





