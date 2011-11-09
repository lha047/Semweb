package com.uib.vinApp.model;

import java.util.List;

import com.uib.vinApp.Interface.IVare;

public interface IQuery {

	public List<IVare> finnVarer(String query);
	
	public IVare finnInfoOmVare(String vare);
}
