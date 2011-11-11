package com.uib.vinApp.Interface;

import java.util.List;

import com.uib.vinApp.model.IVare;

public interface ISemanticWeb {


	public List<String> runQuery(String query);

	public IVare hentVareInfo(String vare);
}
