package com.uib.vinApp.model.Impl;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IDBpedia;

@Component
public class DBPediaImpl implements IDBpedia{

	private String artikkel;
	private String tittel;

	public DBPediaImpl(String tittel, String artikkel) {
		this.tittel = tittel;
		this.artikkel = artikkel;
				
	}

	@Override
	public String getTittel() {
		return tittel;
	}

	@Override
	public String getArtikkel() {
		return artikkel;
	}
}
