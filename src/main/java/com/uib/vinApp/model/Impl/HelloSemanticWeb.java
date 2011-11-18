package com.uib.vinApp.model.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.ISemanticWeb;
import com.uib.vinApp.model.IVare;
import com.uib.vinApp.model.mock.DBpediaMock;

@Component
public class HelloSemanticWeb implements ISemanticWeb{
	private static final String NAME_SPACE = "http://www.semanticweb.org/ontologies/2011/10/TestWine.owl#";
	private static final String RDF_NS = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	private static final String INT_NS = "^^http://www.w3.org/2001/XMLSchema#int";
	private static final String SKILLETEGN = "#";
	private static final String PASSER_TIL = "passerTil";
	private static final String PRIS = "pris";
	private static final String VARNR = "varenummer";
	private static final String ALKO = "alkoprosent";
	private static final String KOMMER_FRA = "kommerFra";
	private static final String VOLUM = "volum";
	private static final String FRISKHET = "friskhet";
	private static final String FYLDE = "fylde";
	private static final String SOET = "sweet";
	private static final String GARVE = "garvesyre";
	private static final String BITTER = "bitterhet";
	private static final String LABEL = "label";
	private static final String RDF_LABEL = "http://www.w3.org/2000/01/rdf-schema#";

	//	static String defaultNameSpace = "http://www.semanticweb.org/ontologies/2011/9/Vinmonopolet.owl#";
	static String defaultNameSpace = "http://www.semanticweb.org/ontologies/2011/10/TestWine.owl#";

	private OntModel _wineModel;

	static boolean flag = true;
	
	

	@Override
	public List<IVare> finnTilfeldigeVarer() {
//		String q = " select DISTINCT ?x where {?x rdf:type wine:Goods} LIMIT 10";
		String q = " select DISTINCT ?x where {?x rdf:type wine:Goods} LIMIT 10";
		List<IVare> v = new ArrayList<IVare>();
		List<String> tilfeldigeVarer = runQueryOneVariable(q);
		for (int i = 0; i < tilfeldigeVarer.size(); i++) {	
			tilfeldigeVarer.set(i, fjernNameSpaces(tilfeldigeVarer.get(i)));
			System.out.println("finnTilfeldigVarer: " + tilfeldigeVarer.get(i));
//			varer.add(tilfeldigeVarer.get(i));
			 
		}
		
		//10 tilfeldige varer
		for(int j = 0; j < tilfeldigeVarer.size(); j++) {
			//henter info om hver vare
			List<String> s = hentInfo(tilfeldigeVarer.get(j));
			v.add(lagVare(s));
			
		}
		
		
		System.out.println("'''''''''''''''''''''''''''''''''");
		for (int i = 0; i < v.size(); i++) {
			System.out.println("tilfeldige: " + v.get(i).toString());
		}
		
		return v;
	}
	
	@Override
	public List<String> runQueryOneVariable(String query) {
		List<String> list = new ArrayList<String>();

		QueryExecution qexec = runWine(query);


		try {
			ResultSet response = qexec.execSelect();

			while( response.hasNext()){

				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?x");
				//				RDFNode name1 = soln.get("?y");
				if( name != null ){
					//					System.out.println(counter);
					//					System.out.println("");
					System.out.println( "Result " + name.toString() );
					list.add(name.toString());
					//					System.out.println( "Result " + name1.toString() );
					//					System.out.println("");
				}
				else
					System.out.println("NoResult!");
			}
		} finally { qexec.close();}	

		return list;
	}

	public static void main(String[] args) {
		HelloSemanticWeb h = new HelloSemanticWeb();
		h.getModel();
		h.finnTilfeldigeVarer();
	}

	@Override
	public IVare hentVareInfo(String vare) {
		//utfører spørring etter all infoen om varen og lager et nytt vare obj
		List<String> vareInfo = hentInfo(vare);

		return lagVare(vareInfo);
	}


	private List<String> hentInfo(String vareNr) {
		List<String> list = new ArrayList<String>();
		String s = lagQueryOmAllInfoOmVare(vareNr);
		System.out.println("query " + s);
		QueryExecution qexec = runWine(s);
		try {
			ResultSet res = qexec.execSelect();
			List<String> variabler = res.getResultVars();
			for (String string : variabler) {
				System.out.println("variabler " + string);
			}
			while(res.hasNext()) {
				QuerySolution qs = res.nextSolution();

				RDFNode node = qs.get("?x");
				RDFNode node2 = qs.get("?y");

				if(node != null) {
					String xarg = fjernNameSpaces(node.toString());
					String yarg = fjernNameSpaces(node2.toString());
				
					list.add(xarg + SKILLETEGN + yarg);
					System.out.println("result x: " + xarg);
					System.out.println("result y: " + yarg);
				}
				else System.out.println("No Result");

			}
		} finally {qexec.close();}
		System.out.println("liste størrelse " + list.size());
		return list;
	}

	private String fjernNameSpaces(String list) {
		if(list.contains(NAME_SPACE)) {

			list = list.replace(NAME_SPACE, "");
		}
		else if(list.contains(RDF_NS)) {
			list = list.replace(RDF_NS, "");
		}
		else if(list.contains(INT_NS)){
			list = list.replace(INT_NS, "");
		}
		else if(list.contains(RDF_LABEL)) {
			list = list.replace(RDF_LABEL, "");
		}
		
		return list;
	}

	private String lagQueryOmAllInfoOmVare(String vareNr) {

		return " select DISTINCT ?x ?y where {wine:"+ vareNr +" ?x ?y}";
	}

	private String lagQueryOmLand(String vare) {

		return " select DISTINCT ?x where {wine:"+ vare +" wine:kommerFra ?x}";
	}



	@Override
	public IDBpedia runDBPediaQuery(IVare vare) {
		String land = vare.getLand();
		IDBpedia dbp = finnDBPediaOmLand(land);
		return dbp;
	}


	private IDBpedia finnDBPediaOmLand(String land) {
		//kjør spørring mot dbpedia om land
		IDBpedia dbp = new DBPediaImpl();
		return dbp;
	}

	
	public void getModel(){
		_wineModel = ModelFactory.createOntologyModel();
		if(flag) System.out.println("Laget modell");
		InputStream inFoafInstance = FileManager.get().open("vareNUmmerSomID.owl");

		if(inFoafInstance == null) {

			System.out.println("--------- Får ikke lese rdf filen-----------------");
		}
		if(flag) System.out.println("lest Fil");
		_wineModel.read(inFoafInstance,defaultNameSpace);

		try {
			inFoafInstance.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(flag) System.out.println("Lest fil inn i modell " + _wineModel.size());

//		return _wineModel;
	}

	private QueryExecution runWine(String queryRequest){

		StringBuffer queryStr = new StringBuffer();

		queryStr.append("PREFIX wine" + ": <" + defaultNameSpace + "> ");
		queryStr.append("PREFIX rdfs" + ": <" + "http://www.w3.org/2000/01/rdf-schema#" + "> ");
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-rdf-syntax-ns#" + "> ");
		queryStr.append("PREFIX owl" + ": <" + "http://www.w3.org/2002/07/owl#" + "> ");

		//Now add query
		queryStr.append(queryRequest);
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, _wineModel);


		return qexec;

	}
	
	private IVare lagVare(List<String> vareInfo) {
		IVare item = new VareImpl();
		
		
		List<String> passerTil = new ArrayList<String>();
		for(int i = 0 ; i < vareInfo.size(); i++) {
			String s = vareInfo.get(i);
			int j = s.indexOf(SKILLETEGN);
			if(s.startsWith(LABEL)) {
				item.setNavn(s.substring(j+1));
			}
			
			if(s.toLowerCase().endsWith("øl")||s.toLowerCase().endsWith("rødvin")||s.toLowerCase().endsWith("hvitvin")||
					s.toLowerCase().endsWith("muserendevin")||s.toLowerCase().endsWith("brennevin")||s.toLowerCase().endsWith("rosevin")||
					s.toLowerCase().endsWith("fruktvin")||s.toLowerCase().endsWith("sterkvin")) {

				item.setVareType(s.substring(j+1));
			}
			if(s.startsWith(PASSER_TIL)) {
				passerTil.add(s.substring(j+1));
			}
					
			if(s.startsWith(PRIS)) {
				item.setPris(s.substring(j+1));
			}
			if(s.startsWith(VARNR)) {
				item.setVareNummer(s.substring(j+1));
			}

			if(s.startsWith(ALKO)) {
				item.setAlkoholProsent(s.substring(j+1));
			}

			if(s.startsWith(KOMMER_FRA)) {

				item.setLand(s.substring(j+1));
			}
			if(s.startsWith(VOLUM)) {
				item.setVolum(s.substring(j+1));
			}
			if(s.startsWith(FRISKHET)) {
				item.setFriskhet(s.substring(j+1));
			}
			if(s.startsWith(FYLDE)) {
				item.setFylde(s.substring(j+1));
			}
			if(s.startsWith(SOET)) {
				item.setSoedme(s.substring(j+1));
			}
			if(s.startsWith(GARVE)) {
				item.setGarvestoffer(s.substring(j+1));
			}
			if(s.startsWith(BITTER)) { //legg inn i ont
				item.setBitterhet(s.substring(j+1));
			}
		}
		item.setPasserTil(passerTil);
		return item;
		
	}

	
}

