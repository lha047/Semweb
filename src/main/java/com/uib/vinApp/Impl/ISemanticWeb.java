package com.uib.vinApp.Impl;

import java.util.List;

import com.uib.vinApp.Interface.IVare;

public interface ISemanticWeb {


	public List<String> runQuery(String query);

	public IVare hentVareInfo(String vare);
}
