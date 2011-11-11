package com.uib.vinApp.Impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IVare;

@Component
public class VareMock implements IVare {
	
//	private String navn;
//	private double pris;
//	private double alkoholprosent;
//	private String beskrivelse;
//	private String vareType;
//	private String land;
//	private String distrikt;
//	private int aargang;
//	private int vareNummer;
//	private Set<String> passerTil;
//	private int soedme; //-1 = ingen verdi for denne karakteristikken
//	private int friskhet; //-1 = ingen verdi for denne karakteristikken
//	private int garvestoffer; //-1 = ingen verdi for denne karakteristikken
//	private int bitterher; //-1 = ingen verdi for denne karakteristikken
//	private int fylde;
		
//	public Vare(String navn, double pris, String land, String vareType) {
//		this.navn = navn;
//		this.pris = pris;
//		this.alkoholprosent = 0;
//		this.beskrivelse = "---";
//		this.vareType = vareType;
//		this.land = land;
//		this.distrikt = "Øvrig";
//		this.aargang = 0;
//		this.vareNummer = 0;
//		Set<String> set = new HashSet<String>();
//		set.add("--");
//		set.add("--");
//		set.add("--");
//		this.passerTil = set;
//		this.soedme = 0;
//		this.friskhet = 0;
//		this.fylde = 0;
//		this.garvestoffer = 0;
//		this.bitterher = 0;
//	}
//
//	public Vare() {
//		super();
//		this.navn = "Nøgne Ø Imperial India Pale Ale #500";
//		this.pris = 79.90;
//		this.alkoholprosent = 10;
//		this.beskrivelse = "Bygg, hvete, rug, humle. Overgjæret produksjonsprosess.";
//		this.vareType = "Øl";
//		this.land = "Norge";
//		this.distrikt = "Øvrig";
//		this.aargang = 2011;
//		this.vareNummer = 5286702;
//		Set<String> set = new HashSet<String>();
//		set.add("Svin");
//		set.add("Storfe");
//		set.add("Lam og sau");
//		this.passerTil = set;
//		this.soedme = -1;
//		this.friskhet = 8;
//		this.fylde = 9;
//		this.garvestoffer = -1;
//		this.bitterher = 10;
//	}
	
	public String getNavn() {
		return "Nøgne Ø Imperial India Pale Ale #500";
	}
	public int getVareNummer() {
		return 5286702;
	}
	public int getAargang() {
		return 2011;
	}
	public double getPris() {
		return 59.00;
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
	public Set<String> getPasserTil() {
		return passerTil();
	}
	private Set<String> passerTil() {
		Set<String> set = new HashSet<String>();
		set.add("Storfe");
		set.add("Vilt");
		return set;
	}
	public double getAlkoholProsent() {

		return 10.00;
	}
	public String getBeskrivelse() {

		return "Awsome beer!!!";
	}
	
	public int getSoedme() {
		return -1;
	}

	public int getFriskhet() {
		return 4;
	}

	public int getGarvestoffer() {
		return -1;
	}

	public int getBitterhet() {
		return 3;
	}

	public int getFylde() {
		return 6;
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


}
