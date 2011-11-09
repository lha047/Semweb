package com.uib.vinApp.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.query.ResultSet;
import com.uib.vinApp.Interface.IVare;
import com.uib.vinApp.model.IQuery;

@Service
public class Queries implements IQuery{


	@Autowired
	private ISemanticWeb semWeb;
	private boolean flag = true;

	public Queries () {}

	public Queries(ISemanticWeb semWeb) {
		this.semWeb = semWeb;
	}
	
	public IVare finnInfoOmVare(String vare) {
		IVare res = new Vare("Snake Dog IPA", 50.00, "USA", "Øl");
		
		return res;
	}
	
	

	public List<IVare> finnVarer(String query) {
		List<IVare> vareListe = new ArrayList<IVare>();
		
		List<String> tempListe = semWeb.runQuery(query);
		System.out.println("Templiste størrelse: " + tempListe.size());
		
		for (String vare : tempListe) {
			vareListe.add(semWeb.hentVareInfo(vare));
		}
//		vareListe.add(new Vare("Tuborg green", 14.00, "Danmark", "Øl"));
//		vareListe.add(new Vare("Gato Negro", 80.0 , "Chile", "Rødvin"));
//		vareListe.add(new Vare("Ch. Miraval Pink Floyd Rose 2010", 450.00, "Rosevin", "Frankrike"));
//		vareListe.add(new Vare("Leffe Blond", 43.60, "Øl", "Belgia"));
//		vareListe.add(new Vare("Rochefort 8 Trappist", 49.90, "Øl", "Belgia"));
		System.out.println("Varelisten størrelse: " + vareListe.size());
		return vareListe;
	}

}
