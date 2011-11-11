package com.uib.vinApp.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
		InputStream inFoafInstance = FileManager.get().open("Ontologies/Vinmonopolet.rdf");
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

	private void runQuaryWithModel(Model model){

		runWine(" select DISTINCT ?x where{ ?x rdf:type wine:Øl; wine:harPris ?y. FILTER (?y <=15) }", model);  //add the query string

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
		//		try {
		//		ResultSet response = qexec.execSelect();
		//		
		//		while( response.hasNext()){
		//			QuerySolution soln = response.nextSolution();
		//			RDFNode name = soln.get("?x");
		//			
		//			if( name != null ){
		//				System.out.println( "Result " + name.toString() );
		//			}
		//			else
		//				System.out.println("NoResult!");
		//			}
		//		} finally { qexec.close();}				
	}

	@Override
	public List<String> runQuery(String query) {
		List<String> list = new ArrayList<String>();

		QueryExecution qexec = runWine(" select DISTINCT ?x ?y ?z where {?x wine:hasCounty ?z}", getModel());
//		QueryExecution qexec = runWine(" select DISTINCT ?x where{ ?x rdf:type wine:Øl; wine:harPris ?y. FILTER (?y <=15) }", getModel());

		try {
			ResultSet res = qexec.execSelect();

			while(res.hasNext()) {
				QuerySolution qs = res.nextSolution();
				RDFNode node = qs.get("?x");
				RDFNode node2 = qs.get("?y");
				RDFNode node3 = qs.get("?z");
				
				if(node != null) {
					list.add(node.toString());
//					list.add(node2.toString());
					list.add(node3.toString());
					System.out.println("result: " + node.toString());
//					System.out.println("result: " + node2.toString());
					System.out.println("result: " + node3.toString());
				}
				else System.out.println("No Result");

			}
		} finally {qexec.close();}

		System.out.println("'''''''''''''''''''''''");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("'''''''''''''''''''''''");

		return list;
	}

	@Override
	public IVare hentVareInfo(String vare) {
		// TODO Auto-generated method stub
		return new VareMock();
	}
}

