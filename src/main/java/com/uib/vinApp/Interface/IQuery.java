package com.uib.vinApp.Interface;

import java.util.List;

import com.uib.vinApp.model.IVare;


public interface IQuery {

	public List<IVare> finnVarer(String query);
	
	public IVare finnInfoOmVare(String vare);
}
