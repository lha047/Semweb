package com.uib.vinApp.model.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IVare;

@Component
public class VareImpl implements IVare {

	private String navn;
	private String vareNummer;
	private String vareType;
	private String land;
	private String pris;
	private String alkoholProsent;
	private String garvestoffer;
	private String friskhet;
	private String bitterhet;
	private String soedme;
	private String fylde;
	private String volum;
	private List<String> passerTil;
	

	@Override
	public String getNavn() {
		return navn;
	}

	@Override
	public String getVareNummer() {
		return vareNummer;
	}

//	@Override
//	public int getAargang() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public String getPris() {
		
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

//	@Override
//	public String getDistrikt() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<String> getPasserTil() {
		return passerTil;
	}

	@Override
	public String getAlkoholProsent() {
		// TODO Auto-generated method stub
		return alkoholProsent;
	}

//	@Override
//	public String getBeskrivelse() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getSoedme() {
		// TODO Auto-generated method stub
		return soedme;
	}

	@Override
	public String getBitterhet() {
		// TODO Auto-generated method stub
		return bitterhet;
	}

	@Override
	public String getFriskhet() {
		// TODO Auto-generated method stub
		return friskhet;
	}

	@Override
	public String getGarvestoffer() {
		// TODO Auto-generated method stub
		return garvestoffer;
	}

	@Override
	public String getFylde() {
		// TODO Auto-generated method stub
		return fylde;
	}

	@Override
	public String getVolum() {
		// TODO Auto-generated method stub
		return volum;
	}

	@Override
	public void setVolum(String volum) {
		this.volum = volum;
		
	}

	@Override
	public void setNavn(String navn) {
		this.navn = navn;
		
	}

	@Override
	public void setVareNummer(String varenummer) {
this.vareNummer =  varenummer;
		
	}

	@Override
	public void setPris(String pris) {
		// TODO Auto-generated method stub
		this.pris = pris;
	}

	@Override
	public void setVareType(String vareType) {
		// TODO Auto-generated method stub
		this.vareType = vareType;
	}

	@Override
	public void setLand(String land) {
		// TODO Auto-generated method stub
		this.land = land;
	}

	@Override
	public void setPasserTil(List<String> passerTil) {
		// TODO Auto-generated method stub
		this.passerTil = passerTil;
	}

	@Override
	public void setAlkoholProsent(String alkoholprosent) {
		// TODO Auto-generated method stub
		this.alkoholProsent = alkoholprosent;
	}

	@Override
	public void setSoedme(String soedme) {
		// TODO Auto-generated method stub
		this.soedme = soedme;
	}

	@Override
	public void setBitterhet(String bitterhet) {
		// TODO Auto-generated method stub
		this.bitterhet = bitterhet;
	}

	@Override
	public void setFriskhet(String friskhet) {
		// TODO Auto-generated method stub
		this.friskhet = friskhet;
	}

	@Override
	public void setGarvestoffer(String garvestoffer) {
		// TODO Auto-generated method stub
		this.garvestoffer = garvestoffer;
	}

	@Override
	public void setFylde(String string) {
		// TODO Auto-generated method stub
		this.fylde = fylde;
	}
	
	public String toString() {
		String p ="";
		for (String s : passerTil) {
			p += s + " ";
		}
		return navn + " " + vareType + " " + vareNummer + " " + volum + " " + pris  + " " +p  + " " +alkoholProsent  + " " +
				bitterhet + " " +friskhet + " " +fylde + " " +garvestoffer + " " +land;
	}

}
