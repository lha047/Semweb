package com.uib.vinApp.model.Impl;

import java.util.Set;

import com.uib.vinApp.model.IVare;

public class VareImpl implements IVare {

	private String navn;
	private int vareNummer;
	private String vareType;
	private String land;
	private double pris;
	private String alkoholProsent;
	
	public VareImpl(String vareType, String navn, String vareNummer, String land, String pris, String alkoholProsent) {
		this.vareType = vareType;
		this.navn = navn;
		int nr = -1;
		double p = -1;
		try {
			nr = Integer.parseInt(vareNummer);
			p = Double.parseDouble(pris);
		} catch (NumberFormatException n) {
			
		}
		this.vareNummer = nr;
		this.land = land;
		this.pris = p;
		this.alkoholProsent = alkoholProsent;
	}

	@Override
	public String getNavn() {
		return navn;
	}

	@Override
	public int getVareNummer() {
		return vareNummer;
	}

	@Override
	public int getAargang() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPris() {
		
		return pris;
	}

	@Override
	public String getVareType() {
		return vareType;
	}

	@Override
	public String getLand() {
		return land;
	}

	@Override
	public String getDistrikt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getPasserTil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAlkoholProsent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getBeskrivelse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSoedme() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBitterhet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFriskhet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGarvestoffer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
