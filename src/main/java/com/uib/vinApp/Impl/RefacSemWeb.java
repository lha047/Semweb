package com.uib.vinApp.Impl;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.ontology.OntModel;
import com.uib.vinApp.Interface.IVare;

public class RefacSemWeb implements ISemanticWeb{

	private OntModel _winModel;
	
	public RefacSemWeb() {
	
	}


	public List<String> runQuery(String query) {
		List<String> liste = new ArrayList<String>();
		liste.add("JAJAJAJAJ");
		return liste;
	}

	public IVare hentVareInfo(String vare) {
		System.out.println(_winModel.toString());
		return new Vare("Tull", 10.00, "Superland", "ØL" );
	}
	
	private String finnVare(String query) {
		
		return null;
	}

}
