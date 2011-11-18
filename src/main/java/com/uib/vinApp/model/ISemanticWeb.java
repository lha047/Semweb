package com.uib.vinApp.model;

import java.util.List;

public interface ISemanticWeb {

	public List<String> runQueryOneVariable(String query);

	public IVare hentVareInfo(String vare);

	public IDBpedia runDBPediaQuery(IVare vare);

	public List<IVare> finnTilfeldigeVarer();

	public void getModel();
}
