package com.uib.vinApp.model.Impl;
import java.util.ArrayList;
import java.util.HashSet;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;

abstract class QueryAndMerge {

	public static HashSet<String> mergeResults(ArrayList<ArrayList<String>> mergeAll){
		HashSet<String> results = new HashSet<String>();
		for(ArrayList<String> aList : mergeAll){
			if(aList==null){
				continue;
			}
			for(String result : aList){
				results.add(result);
			}
		}
		if(results.isEmpty()){
			return null;
		}
		else{
			return results;
		}
	}
//	public static void main(String[] args) throws IOException {
//		VineModelFactory.startModelAndGetModel();
//		runQueryWithOneVariableXSysout("?y wine:passerTil ?x");
//	}
	public static ArrayList<String> runQueryWithOneVariableXSysout( String query){


		ArrayList<String> test = null;
		try{
			test=	runWine(" select DISTINCT ?x where{ "+query+" }", VineModelFactory._tempModel);
		}
		catch (Exception e){

		}
		for(String s : test){
			System.out.println(s);
		}

		if (test==null){
			System.out.println("The query was not correct");
			return null;
		}
		return test;
	}

	public static ArrayList<String> runQuerNumbers(Model model, String query){


		ArrayList<String> test = null;
		try{
			test=	runWineNumbers(" select DISTINCT ?x where{ "+query+"}", model);
		}
		catch (Exception e){

		}

		if (test==null){
		test = new ArrayList<String>();
		test.add("no results");
		}
		return test;
	}
	
	public static ArrayList<String> runQueryWithOneVariable(Model model, String query){


		ArrayList<String> test = null;
		try{
			test=	runWine(" select DISTINCT ?x where{ "+query+"}", model);
		}
		catch (Exception e){

		}

		if (test==null){
			System.out.println("No results found");
			return null;
		}
		return test;
	}


	public static ArrayList<String> findAllCountriesFromModel(Model model){


		ArrayList<String> test =	runWine(" select DISTINCT ?x where{ ?x rdf:type wine:Country}", model);

		if (test==null){
			System.out.println("There were not found any countries");
			return null;
		}
		return test;
	}

	private void runQuaryWithModel(Model model){


		runWine(" select DISTINCT ?x where{ ?x rdf:type wine:Country}", model);

	}
	private static ArrayList<String> runWine(String queryRequest, Model model){
		ArrayList<String> temp = new ArrayList<String>();

		StringBuffer queryStr = new StringBuffer();

		queryStr.append("PREFIX wine" + ": <" + VineModelFactory.defaultNameSpace + "> ");
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
					temp.add(name.toString().substring( name.toString().indexOf("#")+1) );
					//					System.out.println( "Result " + name1.toString() );
					//					System.out.println("");
				}
				else
					System.out.println("NoResult!");
			}
		} finally { qexec.close();}		
		if(temp.isEmpty()){
			return null;
		}
		return temp;
	}

	private static ArrayList<String> runWineNumbers(String queryRequest, Model model){
		ArrayList<String> temp = new ArrayList<String>();

		StringBuffer queryStr = new StringBuffer();

		queryStr.append("PREFIX wine" + ": <" + VineModelFactory.defaultNameSpace + "> ");
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
					temp.add(name.toString() );
					//					System.out.println( "Result " + name1.toString() );
					//					System.out.println("");
				}
				else
					System.out.println("NoResult!");
			}
		} finally { qexec.close();}		
		if(temp.isEmpty()){
			return null;
		}
		return temp;
	}


}
