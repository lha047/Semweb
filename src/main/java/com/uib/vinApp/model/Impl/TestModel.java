package com.uib.vinApp.model.Impl;
import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;


public class TestModel {
	static String defaultNameSpace = "http://www.semanticweb.org/ontologies/2011/10/TestWine.owl#";


	public TestModel() throws IOException{

		Model _wineModel = ModelFactory.createDefaultModel();
		InputStream inFoafInstance = FileManager.get().open("finalOntologyWithAllIndividuals.owl");
		_wineModel.read(inFoafInstance,defaultNameSpace);
		inFoafInstance.close();
		runQuaryWithModel(_wineModel);

	}
	public static void main(String[] args) {
		try {
			new TestModel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
	private void runQuaryWithModel(Model model){
		//After Coffee Liquor
		//		runWine(" select DISTINCT ?x ?y where{ wine:testvin ?y ?x}", model);  //add the query string
		//		runWine(" select DISTINCT ?x ?y where{ ?x ?y wine:Duvel }", model);  //add the query string
		//				runWine(" select DISTINCT ?x where{ ?x wine:hasCounty  ?b. ?b rdf:type wine:Land;}", model);  //add the query string
		//				runWine(" select DISTINCT ?x where{ ?x wine:hasCounty  wine:Belgia. ?x wine:harAlkoholprosent ?y. FILTER (?y >20)}", model);
		//		runWineXY(" select DISTINCT ?x ?y where{ ?x wine:harBitterhet  ?y}", model);  //add the query string
		//		runWine(" select DISTINCT ?x where{ wine:After_Coffee_Liquor wine:harPris  ?x}", model);  //add the query string
		//		runWine(" select DISTINCT ?x where{ wine:After_Coffee_Liquor wine:harVarenummer  ?x}", model);  //add the query string
		//		runWine(" select DISTINCT ?x where{ {?x ?z wine:Storvilt} UNION  {wine:Storvilt ?b ?x}}", _wineModel);
		//		runWine(" select DISTINCT ?x where{ wine:SterkGarvesyre ?b ?x}", model);
		//		runWine(" select DISTINCT ?x where{ wine:R?dvin ?b ?x. ?x wine:fylde 7}", model);
		System.out.println("test");

		runWine(" select DISTINCT ?x ?y where {wine:Duvel ?x ?y}", model);
		//		runWine(" select DISTINCT ?x where{  wine:Halvt?rr ?v ?x }", model);
		//-6bb48dee:13384e2530d:-7ff3
		System.out.println("END");
	}
	private void runWine(String queryRequest, Model model){

		StringBuffer queryStr = new StringBuffer();

		queryStr.append("PREFIX wine" + ": <" + defaultNameSpace + "> ");
		queryStr.append("PREFIX rdfs" + ": <" + "http://www.w3.org/2000/01/rdf-schema#" + "> ");
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-rdf-syntax-ns#" + "> ");
		queryStr.append("PREFIX owl" + ": <" + "http://www.w3.org/2002/07/owl#" + "> ");


		//Now add query
		queryStr.append(queryRequest);
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		try {
			ResultSet response = qexec.execSelect();
			int counter = 0;
			while( response.hasNext()){
				counter++;
				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?x");
				//				RDFNode name1 = soln.get("?y");
				if( name != null ){
					//					System.out.println(counter);
					//					System.out.println("");
					System.out.println( "Result " + name.toString() );
					//					System.out.println( "Result " + name1.toString() );
					//					System.out.println("");
				}
				else
					System.out.println("NoResult!");
			}
		} finally { qexec.close();}				
	}


}
