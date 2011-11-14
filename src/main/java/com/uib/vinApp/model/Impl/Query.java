package com.uib.vinApp.model.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.query.ResultSet;
import com.uib.vinApp.Interface.IQuery;
import com.uib.vinApp.Interface.IQueryString;
import com.uib.vinApp.Interface.ISemanticWeb;
import com.uib.vinApp.Interface.IWordsNorwayEnglish;
import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.IVare;
import com.uib.vinApp.model.mock.VareMock;

@Component
public class Query implements IQuery{

	@Autowired
	private ISemanticWeb semWeb;
	
	@Autowired
	private IWordsNorwayEnglish words;
	
	private boolean flag = true;

	
	public IVare finnInfoOmVare(String vare) {
		IVare res = new VareMock();
		
		return res;
	}
	
	

	public List<IVare> finnVarer(String query) {
		List<IVare> vareListe = new ArrayList<IVare>();
		IQueryString qs = createQuery(query);
//		if(semWeb == null ) System.out.println("ingenting i semWeb");
		List<String> tempListe = semWeb.runQuery(qs);
//		System.out.println("Templiste størrelse: " + tempListe.size());
//		
//		for (String vare : tempListe) {
//			vareListe.add(semWeb.hentVareInfo(vare));
//			System.out.println(vare);
//		}
//		vareListe.add(new Vare("Tuborg green", 14.00, "Danmark", "Øl"));
//		vareListe.add(new Vare("Gato Negro", 80.0 , "Chile", "Rødvin"));
//		vareListe.add(new Vare("Ch. Miraval Pink Floyd Rose 2010", 450.00, "Rosevin", "Frankrike"));
//		vareListe.add(new Vare("Leffe Blond", 43.60, "Øl", "Belgia"));
//		vareListe.add(new Vare("Rochefort 8 Trappist", 49.90, "Øl", "Belgia"));
		System.out.println("Varelisten størrelse: " + vareListe.size());
		return vareListe;
	}



	@Override
	public IDBpedia finnDBPediaArtikkel(String textfield) {
		IQueryString query = createQuery(textfield);
		IDBpedia dbpedia = semWeb.runDBPediaQuery(query);
		return dbpedia;
	}



	private IQueryString createQuery(String textfield) {
		textfield = "Rødvin fra Spania & koster < 150 & harGarveStoffer God";
		
		String[] liste = textfield.split(" ");
		for (String string : liste) {
			System.out.println(string);
			
		}
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		Query q = new Query();
		q.createQuery("");
	}

}
