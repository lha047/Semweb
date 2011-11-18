package com.uib.vinApp.model.Impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;


// This class is a model factory class, to prevent the model beeing loaded several times this class
// will make sure the model is only loaded once, if the model have been loaded before it will 
// load the pre loaded model
abstract class  VineModelFactory  {

	public static String defaultNameSpace = "http://www.semanticweb.org/ontologies/2011/10/TestWine.owl#";
	private static boolean modelExsist = false;
	static Model _tempModel;
	static Map<String,String> countryModel;
	
	public static Model startModelAndGetModel()	throws IOException{
		
		
		if(!modelExsist)
		{
			Model _wineModel = ModelFactory.createDefaultModel();
			InputStream inFoafInstance = FileManager.get().open("vareNUmmerSomID.owl");
//			InputStream inFoafInstance = FileManager.get().open("finalOntologyWithAllIndividuals.owl");
			_wineModel.read(inFoafInstance,defaultNameSpace);
			inFoafInstance.close();
			_tempModel = _wineModel;
			modelExsist = true;
			
			Map<String,String> countryMap = new HashMap<String,String>();
			ArrayList<String> allCountriesFromOntology = QueryAndMerge.findAllCountriesFromModel(_tempModel);
			for(int i = 0; i<allCountriesFromOntology.size();i++){
				if(allCountriesFromOntology.get(i).equals("EU")){
					continue;
				}
				countryMap.put(allCountriesFromOntology.get(i), allCountriesFromOntology.get(i));
				countryMap.put(allCountriesFromOntology.get(i).replace("_", " "), allCountriesFromOntology.get(i));
				countryMap.put(allCountriesFromOntology.get(i).replace("_", " ").toLowerCase(), allCountriesFromOntology.get(i));
//				String testString = DBPediaCountryQuery.norwegianToEnglish(allCountriesFromOntology.get(i).replace("_", " "));
//				if(!testString.equals("NO REUSULT")|| !allCountriesFromOntology.get(i).trim().equals("EU")){
//					testString = testString.replace(" (country)", "");
//					countryMap.put(testString.toLowerCase(), allCountriesFromOntology.get(i));
//					countryMap.put(testString, allCountriesFromOntology.get(i));
//				}

			}
			countryModel = countryMap;
		}

		return _tempModel;
	}
	
	public static HashMap<String,String> currencyMap(){
		HashMap<String,String> currencyMap = new HashMap<String, String>();
		try{
			 
			  FileInputStream fstream = new FileInputStream("currency.txt");
			 
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  
			  
			  while ((strLine = br.readLine()) != null)   {
		
			  String nameOfCurrency = strLine.substring(strLine.indexOf(" "), strLine.indexOf("("));
			  String codeOfCurrency = strLine.substring(0, strLine.indexOf(" "));
			  currencyMap.put(nameOfCurrency.toLowerCase(), codeOfCurrency);
			  currencyMap.put(codeOfCurrency.toLowerCase(), codeOfCurrency);
			  }
			  currencyMap.put("kr", "NOK");
			  currencyMap.put("£", "GBP");
			  currencyMap.put("$", "USD");
			  currencyMap.put("€", "EUR");
			 
			  in.close();
			    }catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
			  }
			    return currencyMap;
	}
}
