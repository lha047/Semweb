package com.uib.vinApp.Interface;

import java.util.Set;

public interface IVare {

	public String getNavn();
	
	public int getVareNummer();
	
	public int getAargang();
	
	public double getPris();
	
	public String getVareType();
	
	public String getLand();
	
	public String getDistrikt();
	
	public Set<String> getPasserTil();
	
	public double getAlkoholProsent();
	
	public String getBeskrivelse();
	
	public int getSoedme();
	
	public int getBitterhet();
	
	public int getFriskhet();
	
	public int getGarvestoffer();
	
}
