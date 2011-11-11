package com.uib.vinApp.Impl;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IDBpedia;

@Component
public class DBpedia implements IDBpedia{

	private String tittel;
	private String artikkel;
	
	public DBpedia() {
		this.tittel = "Norge";
		this.artikkel = "Kongeriket Norge (nynorsk: Kongeriket Noreg) er et nordisk, " +
				"europeisk land og en selvstendig stat vest p� den skandinaviske halv�y. " +
				"Landet er langt og smalt, og kysten strekker seg langs Nordatlanteren med " +
				"havomr�der som Skagerrak, Nordsj�en, Norskehavet og Barentshavet, hvor " +
				"ogs� Norges kjente fjorder befinner seg. Totalt dekker det relativt tynt " +
				"befolkede landet 385 000 kvadratkilometer med n�rmere fem millioner " +
				"innbyggere. Det politiske styret er konstitusjonelt monarki med " +
				"parlamentarisk demokrati. Norge er et E�S-land og deltar b�de i " +
				"Schengen og Dublin-samarbeidet, men st�r utenfor EU.";
	}
	
	public String getTittel() {

		return tittel;
	}

	public String getArtikkel() {
		return artikkel;
	}

	
}
