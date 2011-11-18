package com.uib.vinApp.model.Impl;


import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.rdf.model.RDFNode;

abstract class DBPediaCountryQuery {


	public static String norwegianToEnglish(String norwegianCountryWord){

		String sparqlQueryString1= "PREFIX dbont: <http://dbpedia.org/ontology/> "+
				"PREFIX dbp: <http://dbpedia.org/property/>"+
				"PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>"+
				"   SELECT ?x  ?c"+
				"   WHERE {      ?x ?y '"+norwegianCountryWord+"'@no . ?x ?y ?c"+
				"        }";


		Query query = QueryFactory.create(sparqlQueryString1);
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://live.dbpedia.org/sparql", query);

		com.hp.hpl.jena.query.ResultSet results = qexec.execSelect();
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();
			RDFNode name = soln.get("?x");
			RDFNode name2 = soln.get("?c");
			if( name != null ){

				if(name2.toString().endsWith("@en")){
					return name2.toString().substring(0, name2.toString().indexOf("@en"));

				}
			}
		}


		qexec.close() ;
		return "NO REUSULT";

	}
}