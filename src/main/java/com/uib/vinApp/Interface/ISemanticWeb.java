package com.uib.vinApp.Interface;

import java.util.List;

import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.IVare;

public interface ISemanticWeb {


	public List<String> runQuery(IQueryString query);

	public IVare hentVareInfo(String vare);

	public IDBpedia runDBPediaQuery(IQueryString query);
}
