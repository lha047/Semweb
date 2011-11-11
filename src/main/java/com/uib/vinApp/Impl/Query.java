package com.uib.vinApp.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.query.ResultSet;
import com.uib.vinApp.Interface.IQuery;
import com.uib.vinApp.Interface.ISemanticWeb;
import com.uib.vinApp.model.IVare;

@Component
public class Query implements IQuery{

	@Autowired
	private ISemanticWeb semWeb;
	private boolean flag = true;

	
	public IVare finnInfoOmVare(String vare) {
		IVare res = new VareMock();
		
		return res;
	}
	
	

	public List<IVare> finnVarer(String query) {
		List<IVare> vareListe = new ArrayList<IVare>();
//		if(semWeb == null ) System.out.println("ingenting i semWeb");
		List<String> tempListe = semWeb.runQuery(query);
//		System.out.println("Templiste st�rrelse: " + tempListe.size());
//		
//		for (String vare : tempListe) {
//			vareListe.add(semWeb.hentVareInfo(vare));
//			System.out.println(vare);
//		}
//		vareListe.add(new Vare("Tuborg green", 14.00, "Danmark", "�l"));
//		vareListe.add(new Vare("Gato Negro", 80.0 , "Chile", "R�dvin"));
//		vareListe.add(new Vare("Ch. Miraval Pink Floyd Rose 2010", 450.00, "Rosevin", "Frankrike"));
//		vareListe.add(new Vare("Leffe Blond", 43.60, "�l", "Belgia"));
//		vareListe.add(new Vare("Rochefort 8 Trappist", 49.90, "�l", "Belgia"));
		System.out.println("Varelisten st�rrelse: " + vareListe.size());
		return vareListe;
	}

}
