package com.uib.vinApp.Impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import com.hp.hpl.jena.rdf.model.Model;
import com.uib.vinApp.Interface.ISemanticWeb;
import com.uib.vinApp.model.IVare;

@Component
public class RefacSemWeb {

	
	private Model _winModel;
	
	public RefacSemWeb() {
	
	}


	public List<String> runQuery(String query) {
		List<String> liste = new ArrayList<String>();
		liste.add("JAJAJAJAJ");
		return liste;
	}

	public IVare hentVareInfo(String vare) {
		System.out.println(_winModel.toString());
		return new VareMock();
	}
	
	private String finnVare(String query) {
		
		return
				null;
	}

}
