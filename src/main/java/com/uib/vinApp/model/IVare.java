package com.uib.vinApp.model;

import java.util.List;
import java.util.Set;

/**
 * @author Lisa
 * Fylde, Garvestoffer, Friskhet, Sødme, Bitterhet
 */
public interface IVare {

	public String getNavn();
	
//	public int getVareNummer();
	public String getVareNummer();
	
//	public int getAargang();
	
//	public double getPris();
	public String getPris();
	
	public String getVareType();
	
	public String getLand();
	
//	public String getDistrikt();
	
	public List<String> getPasserTil();
	
	public String getAlkoholProsent();
	
//	public String getBeskrivelse();
	
//	public int getSoedme();
	public String getSoedme();
	
//	public int getBitterhet();
	public String getBitterhet();
	
	public String getFriskhet();
	
	public String getGarvestoffer();
	
	public String getFylde();
	
	public String getVolum();
	public void setVolum(String volum);

	public void setNavn(String navn);
	
//	public int getVareNummer();
	public void setVareNummer(String varenummer);
	
//	public int getAargang();
	
//	public double getPris();
	public void setPris(String pris);
	
	public void setVareType(String vareType);
	
	public void setLand(String land);
	
//	public void setDistrikt();
	
	
	public void setAlkoholProsent(String alkoholprosent);
	
//	public String getBeskrivelse();
	
	
	public void setSoedme(String soedme);
	public void setBitterhet(String bitterhet);
	
	public void setFriskhet(String friskhet);
	
	public void setGarvestoffer(String garvestoffer);

	public void setFylde(String string);

	void setPasserTil(List<String> passerTil);
	
	
}
