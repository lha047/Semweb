package com.uib.vinApp.model.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IVare;


public class VareMock implements IVare {
	

	
	public String getNavn() {
		return "Nøgne Ø Imperial India Pale Ale #500";
	}
	public String getVareNummer() {
		return "5286702";
	}
	public int getAargang() {
		return 2011;
	}
	public String getPris() {
		return "59.00";
	}
	public String getVareType() {
		return "Øl";
	}
	public String getLand() {

		return "Norge";
	}
	public String getDistrikt() {

		return "Øverig";
	}
	public List<String> getPasserTil() {
		return passerTil();
	}
	private List<String> passerTil() {
		List<String> set = new ArrayList<String>();
		set.add("Storfe");
		set.add("Vilt");
		return set;
	}
	public String getAlkoholProsent() {

		return "10.00";
	}
	public String getBeskrivelse() {

		return "Awsome beer!!!";
	}
	
	public String getSoedme() {
		return "-1";
	}

	public String getFriskhet() {
		return "4";
	}

	public String getGarvestoffer() {
		return "-1";
	}

	public String getBitterhet() {
		return "3";
	}

	public String getFylde() {
		return "6";
	}

	public boolean equals(VareMock vare) {
		if(getVareNummer() == vare.getVareNummer()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return getNavn() + " " + getPris() + " " + getLand()  + " " + getVareType();
	}
	@Override
	public String getVolum() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setVolum(String volum) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setNavn(String navn) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setVareNummer(String varenummer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPris(String pris) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setVareType(String vareType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLand(String land) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setAlkoholProsent(String alkoholprosent) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSoedme(String soedme) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBitterhet(String bitterhet) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFriskhet(String friskhet) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setGarvestoffer(String garvestoffer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFylde(String string) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPasserTil(List<String> passerTil) {
		// TODO Auto-generated method stub
		
	}


}
