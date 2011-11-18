package com.uib.vinApp.model.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.IInput;
import com.uib.vinApp.model.IQuery;
import com.uib.vinApp.model.ISemanticWeb;
import com.uib.vinApp.model.IVare;
import com.uib.vinApp.model.mock.DBpediaMock;
import com.uib.vinApp.model.mock.VareMock;

@Component
public class Query implements IQuery{

	@Autowired
	private ISemanticWeb semWeb;
	@Autowired
	private IInput input;
	private boolean flag = true;

	
	public IVare finnInfoOmVare(String vare) {
		
//		return semWeb.hentVareInfo(vare);
		return new VareMock();
		
	}
	public static void main(String[] args) {
		Query q = new Query();
		q.finnVarer("rødvin kommerFra Spania");
	}
	
	public List<IVare> finnVarer(String query) {
		List<IVare> vareListe = new ArrayList<IVare>();
		
		String q = " select DISTINCT ?x where {"+ input.createQueryFromInput(query)+ "}";
		
		System.out.println("Query: " + q);
		
		//Liste med varer, kun vare navn
		List<String> tempListe = semWeb.runQueryOneVariable(q);
		
		for(int i = 0; i < tempListe.size(); i++) {
			String temp = tempListe.get(i);
			//Tegn før navn
			int index = temp.indexOf("#");
			temp = temp.substring(index+1);
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
	public IDBpedia finnDBPediaArtikkel(IVare vare) {
		
		IDBpedia dbpedia = semWeb.runDBPediaQuery(vare);
		return dbpedia;
//		return new DBpediaMock();
	}



	@Override
	public List<IVare> finnTiTilfeldigeVarer() {
		List<IVare> varer = semWeb.finnTilfeldigeVarer();
//		System.out.println("'''''''''''''''''''''''''''''''''");
//		for (IVare iVare : varer) {
//			System.out.println("Vare :" + iVare.toString());
//		}
//		System.out.println("'''''''''''''''''''''''''''''''''");
		return varer;
//		List<IVare> mock = new ArrayList<IVare>();
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		mock.add(new VareMock());
//		return mock;
	}

	@Override
	public void lagModel() {
		semWeb.getModel();
		
	}




	
//	public static void main(String[] args) {
//		Query q = new Query();
//		q.createQuery("");
//	}

}
