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
import com.uib.vinApp.Interface.ISemanticWeb;
import com.uib.vinApp.Interface.IWordsNorwayEnglish;
import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.IInput;
import com.uib.vinApp.model.IVare;
import com.uib.vinApp.model.mock.VareMock;

@Component
public class Query implements IQuery{

	@Autowired
	private ISemanticWeb semWeb;
	@Autowired
	private IInput input;
	private boolean flag = true;

	
	public IVare finnInfoOmVare(String vare) {
		IVare res = new VareMock();
		
		return res;
	}
	
	

	public List<IVare> finnVarer(String query) {
		List<IVare> vareListe = new ArrayList<IVare>();
		
		String q = input.createQueryFromInput(query);
//		if(semWeb == null ) System.out.println("ingenting i semWeb");
		
		//Liste med varer, kun vare navn
		List<String> tempListe = semWeb.runQuery(q);
		for(int i = 0; i < tempListe.size(); i++) {
			String temp = tempListe.get(i);
			//Tegn før navn
			int index = temp.indexOf("#");
			temp = temp.substring(index);
			tempListe.set(i, temp);
			vareListe.add(semWeb.hentVareInfo(tempListe.get(i)));
		}
		
		if(flag) {
			for (IVare iVare : vareListe) {
				System.out.println(iVare.toString());
			}
		}
	
		System.out.println("Varelisten størrelse: " + vareListe.size());
		return vareListe;
	}



	@Override
	public IDBpedia finnDBPediaArtikkel(String vare) {
		
		IDBpedia dbpedia = semWeb.runDBPediaQuery(vare);
		return dbpedia;
	}




	
//	public static void main(String[] args) {
//		Query q = new Query();
//		q.createQuery("");
//	}

}
