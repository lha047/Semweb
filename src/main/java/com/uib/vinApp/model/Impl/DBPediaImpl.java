package com.uib.vinApp.model.Impl;

import org.springframework.stereotype.Component;

import com.hp.hpl.jena.vocabulary.DB;
import com.uib.vinApp.model.IDBpedia;

@Component
public class DBPediaImpl implements IDBpedia{

	private String artikkel;
	private String tittel;
	private String bilde;
	
//	public DBPediaImpl(String tittel, String artikkel, String bilde) {
//		this.artikkel = artikkel;
//		this.tittel = tittel;
//		this.bilde = bilde;
//	}

	@Override
	public String getTittel() {
		return tittel;
	}

	@Override
	public String getArtikkel() {
		return artikkel;
	}

	@Override
	public String getBilde() {
		return bilde;
	}

	@Override
	public void setTittel(String tittle) {
		this.tittel = tittle;
		
	}

	@Override
	public void setArtikkel(String artikkel) {
		this.artikkel = artikkel;
		
	}

	@Override
	public void setBilde(String bilde) {
		this.bilde = bilde;		
	}
}
