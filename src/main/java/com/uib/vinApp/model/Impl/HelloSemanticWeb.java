package com.uib.vinApp.model.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.uib.vinApp.Interface.ISemanticWeb;
import com.uib.vinApp.model.IVare;

@Component
public class HelloSemanticWeb implements ISemanticWeb{
	static String defaultNameSpace = "http://www.semanticweb.org/ontologies/2011/9/Vinmonopolet.owl#";

	private OntModel _wineModel;
	boolean flag = true;

	//	public HelloSemanticWeb(){
	////		getModel();
	////		_wineModel = ModelFactory.createOntologyModel();
	//
	//	}

	public static void main(String[] args) throws IOException {
		boolean flag = true;
		if(flag) System.out.println("???");
		HelloSemanticWeb hello = new HelloSemanticWeb();
		hello.runQuery("");
		if(flag) System.out.println("???");

	}


	public Model getModel(){
		_wineModel = ModelFactory.createOntologyModel();
		if(flag) System.out.println("inni getmodel");
		InputStream inFoafInstance = FileManager.get().open("Vinmonopolet.rdf");
		FileManager f = FileManager.get();
		System.out.println(f.getLocationMapper().DEFAULT_PATH);
		if(inFoafInstance == null) {
			
			System.out.println("--------- Får ikke lese rdf filen-----------------");
		}
		if(flag) System.out.println("inni getmodel");
		_wineModel.read(inFoafInstance,defaultNameSpace);
//		_wineModel.read(inFoafInstance, null);
		if(flag) System.out.println("inni getmodel");


		// Lager test resurser og individer
		Resource r = _wineModel.getResource( defaultNameSpace + "Øl" );
//		Resource r = _wineModel.getResource( null + "Øl" );
		Resource roseVin = _wineModel.getResource( defaultNameSpace + "Rosévin" );
		Resource country = _wineModel.getResource( defaultNameSpace + "Belgia" );
		OntClass Ol = _wineModel.createClass(defaultNameSpace + "Øl"); 
//		OntClass Ol = (OntClass) r.as( OntClass.class );
		Individual ind1 = Ol.createIndividual( defaultNameSpace + "Duvel" );
		Property  hasCountry = _wineModel.getProperty(defaultNameSpace+"hasCounty");
		Property  harPris = _wineModel.getProperty(defaultNameSpace+"harPris");
		Statement statement = _wineModel.createStatement(ind1,hasCountry,country);
		double test = 10;
		Statement ste = _wineModel.createLiteralStatement(ind1, harPris, test);
		_wineModel.add(ste);
		_wineModel.add(statement);

		// kjører spørring på modellen
		//		runQuaryWithModel(_wineModel);
		return _wineModel;


	}


	public QueryExecution runWine(String queryRequest, Model model){

		StringBuffer queryStr = new StringBuffer();

		queryStr.append("PREFIX wine" + ": <" + defaultNameSpace + "> ");
		queryStr.append("PREFIX rdfs" + ": <" + "http://www.w3.org/2000/01/rdf-schema#" + "> ");
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-rdf-syntax-ns#" + "> ");


		//Now add query
		queryStr.append(queryRequest);
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		

		return qexec;
		
	}

	@Override
	public List<String> runQuery(String query) {
		List<String> list = new ArrayList<String>();

		
		QueryExecution qexec = runWine(" select DISTINCT ?x ?y where {wine:Duvel ?x ?y}", getModel());
//		QueryExecution qexec = runWine(" select DISTINCT ?x ?y ?z where {?x wine:hasCounty ?z}", getModel());
//		QueryExecution qexec = runWine(" select DISTINCT ?x where{ ?x rdf:type wine:Øl; wine:harPris ?y. FILTER (?y <=15) }", getModel());

		try {
			ResultSet res = qexec.execSelect();

			while(res.hasNext()) {
				QuerySolution qs = res.nextSolution();
				RDFNode node = qs.get("?x");
				RDFNode node2 = qs.get("?y");
//				RDFNode node3 = qs.get("?z");
				
				if(node != null) {
					list.add(node.toString());
					System.out.println("result: " + node.toString());
					System.out.println("result: " + node2.toString());
//					System.out.println("result: " + node3.toString());
				}
				else System.out.println("No Result");

			}
		} finally {qexec.close();}


		return list;
	}

	@Override
	public IVare hentVareInfo(String vare) {
		Map<String, String> vareInfo = hentInfo(vare);
		
		return new VareImpl(vareInfo.get("harVareType"),vareInfo.get("harNavn"), 
				vareInfo.get("harVareNummer"), vareInfo.get("harLand"), vareInfo.get("harPris"),
				vareInfo.get("harAlkoholProsent"));
	}


	private Map<String, String> hentInfo(String vare) {
		Map<String, String> list = new HashMap<String, String>();
		QueryExecution qexec = runWine(hentAllInfoOnVareSporring(vare), getModel());
		try {
			ResultSet res = qexec.execSelect();

			while(res.hasNext()) {
				QuerySolution qs = res.nextSolution();
				RDFNode node = qs.get("?x");
				RDFNode node2 = qs.get("?y");
				
				if(node != null) {
					list.put(node.toString(), node2.toString());
					System.out.println("result: " + node.toString());
					System.out.println("result: " + node2.toString());
				}
				else System.out.println("No Result");

			}
		} finally {qexec.close();}

		return list;
	}


	private String hentAllInfoOnVareSporring(String vare) {
		
		return " select DISTINCT ?x ?y where {wine:"+ vare +" ?x ?y}";
	}
}

