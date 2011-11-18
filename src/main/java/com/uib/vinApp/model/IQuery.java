package com.uib.vinApp.model;

import java.util.List;



public interface IQuery {

	public List<IVare> finnVarer(String query);
	
	public IVare finnInfoOmVare(String vare);

	public IDBpedia finnDBPediaArtikkel(IVare vare);

	public List<IVare> finnTiTilfeldigeVarer();
}
