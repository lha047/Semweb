package com.uib.vinApp.model.Impl;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IWordsNorwayEnglish;

@Component
public abstract class WordsNorwayEnglish implements IWordsNorwayEnglish{
	static boolean havePopulated = false;
	static HashMap<String,String> languageToNorwegian = new HashMap<String, String>();
	static HashMap<String,String> negationList = new HashMap<String, String>();
	
	static public String manupulatetInputt(String in){
		if(!havePopulated){
		populate();
		havePopulated = true;
		}
		String manipulatedInputt = in;
		
		manipulatedInputt= " "+manipulatedInputt+" ";
		manipulatedInputt = manipulatedInputt.toLowerCase();
		Iterator<String> languageitterN = negationList.keySet().iterator();
		while (languageitterN.hasNext()) {
			String string = (String) languageitterN.next();
//			System.out.println(string);
//			System.out.println(languageToNorwegian.get(string));
			manipulatedInputt = manipulatedInputt.replace(" "+string+" ", " "+negationList.get(string)+" ");
			
		}
		
		
		Iterator<String> languageitter = languageToNorwegian.keySet().iterator();
		
		while (languageitter.hasNext()) {
			String string = (String) languageitter.next();
//			System.out.println(string);
//			System.out.println(languageToNorwegian.get(string));
			manipulatedInputt = manipulatedInputt.replace(" "+string+" ", " "+languageToNorwegian.get(string)+" ");
			
		}
		
		
		manipulatedInputt = manipulatedInputt.trim();
		return manipulatedInputt;
	}
	
	public static void populate(){
	
	
		negationList.put("ikke frisk","notFrisk");
		negationList.put("ikke frisk","notFrisk");
		negationList.put("not fresh","notFrisk");
		negationList.put("ikke fyldig","notFylde");
		negationList.put("not rich","notFylde");
		negationList.put("ikke syrlig","notGarvesyre");
		negationList.put("not tannin","notGarvesyre");
		negationList.put("ikke s�t","notSweet");
		negationList.put("not sweet","notSweet");
		languageToNorwegian.put("red wine", "R�dvin");
		languageToNorwegian.put("Red wine", "R�dvin");
		languageToNorwegian.put("r�dvin", "R�dvin");
		languageToNorwegian.put("white wine", "Hvitvin");
		languageToNorwegian.put("hvitvin", "Hvitvin");
		languageToNorwegian.put("fra", "kommerFra");
		languageToNorwegian.put("kommer fra", "kommerFra");
		languageToNorwegian.put("from", "kommerFra");
		languageToNorwegian.put("goes well with", "passerTil");
		languageToNorwegian.put("passer til", "passerTil");
		languageToNorwegian.put("har alkoholprosent","alkoprosent");
		languageToNorwegian.put("have alcohol percentage","alkoprosent");
		languageToNorwegian.put("har bitterhet","bitterhet");
		languageToNorwegian.put("have bitterness","bitterhet");
		languageToNorwegian.put("har friskhet","friskhet");
		languageToNorwegian.put("have freshness","friskhet");
		languageToNorwegian.put("har fylde","fylde");
		languageToNorwegian.put("have richness","fylde");
		languageToNorwegian.put("har garvesyre","garvesyre");
		languageToNorwegian.put("have tannin","garvesyre");
		languageToNorwegian.put("har pris","pris");
		languageToNorwegian.put("koster","pris");
		languageToNorwegian.put("have price","pris");
		languageToNorwegian.put("har s�dme","sweetnes");
		languageToNorwegian.put("have sweetnes","sweetnes");
		languageToNorwegian.put("har varenummer","varenummer");
		languageToNorwegian.put("have item number","varenummer");
		languageToNorwegian.put("have volume","volum");
		languageToNorwegian.put("har volume","volum");
		languageToNorwegian.put("Alkoholfritt","Alkoholfritt");
		languageToNorwegian.put("alkoholfritt","Alkoholfritt");
		languageToNorwegian.put("alcohol-free","Alkoholfritt");
		languageToNorwegian.put("Alcohol-free","Alkoholfritt");
		languageToNorwegian.put("brennevin","Brennevin");
		languageToNorwegian.put("Brennevin","Brennevin");
		languageToNorwegian.put("liquor","Brennevin");
		languageToNorwegian.put("Liquor","Brennevin");
		languageToNorwegian.put("fruit wine","Fruktvin");
		languageToNorwegian.put("Fruit wine","Fruktvin");
		languageToNorwegian.put("fruktvin","Fruktvin");
		languageToNorwegian.put("Fruktvin","Fruktvin");
		languageToNorwegian.put("sparkling wine","MusserendeVin");
		languageToNorwegian.put("Sparkling wine","MusserendeVin");
		languageToNorwegian.put("musserende vin","MusserendeVin");
		languageToNorwegian.put("Musserende vin","MusserendeVin");
		languageToNorwegian.put("musserendevin","MusserendeVin");
		languageToNorwegian.put("musserendeVin","MusserendeVin");
		languageToNorwegian.put("rosevin","Rosevin");
		languageToNorwegian.put("Rosevin","Rosevin");
		languageToNorwegian.put("ros�vin","Rosevin");
		languageToNorwegian.put("Ros�vin","Rosevin");
		languageToNorwegian.put("ros� wine","Rosevin");
		languageToNorwegian.put("Ros� wine","Rosevin");
		languageToNorwegian.put("strong wine","Sterkvin");
		languageToNorwegian.put("Strong wine","Sterkvin");
		languageToNorwegian.put("sterkvin","Sterkvin");
		languageToNorwegian.put("Sterkvin","Sterkvin");
		languageToNorwegian.put("frisk","isFrisk");
		languageToNorwegian.put("Frisk","isFrisk");
		languageToNorwegian.put("rich","isFylde");
		languageToNorwegian.put("fresh","isFrisk");
		languageToNorwegian.put("fyldig","isFylde");
		languageToNorwegian.put("ikke syrlig","notGarvesyre");
		languageToNorwegian.put("syrlig","isGarvesyre");
		languageToNorwegian.put("ikke syrlig","notGarvesyre");
		languageToNorwegian.put("tannin","isGarvesyre");
		languageToNorwegian.put("s�t","isSweet");
		languageToNorwegian.put("sweet","isSweet");
		languageToNorwegian.put("ikke frisk","notFrisk");
		languageToNorwegian.put("not fresh","notFrisk");
		languageToNorwegian.put("ikke fyldig","notFylde");
		languageToNorwegian.put("not rich","notFylde");
		languageToNorwegian.put("ikke syrlig","notGarvesyre");
		languageToNorwegian.put("not tannin","notGarvesyre");
		languageToNorwegian.put("ikke s�t","notSweet");
		languageToNorwegian.put("not sweet","notSweet");
		languageToNorwegian.put("�l","�l");
		languageToNorwegian.put("�l","�l");
		languageToNorwegian.put("beer","�l");
		languageToNorwegian.put("Ost","Ost");
		languageToNorwegian.put("ost","Ost");
		languageToNorwegian.put("cheese","Ost");
		languageToNorwegian.put("cost","pris");
		/*
		 * Lyst_kj�tt
Storvilt
Sm�vilt_og_fugl
Ost
Storfe
Fisk
Lam_og_sau
Svinekj�tt
Apertiff
Skalldyr
Dessert
Gr�nnsaker

		 */
		languageToNorwegian.put("lyst kj�tt","Lyst_kj�tt");
		languageToNorwegian.put("Lyst Kj�tt","Lyst_kj�tt");
		languageToNorwegian.put("Lystkj�tt","Lyst_kj�tt");
		languageToNorwegian.put("lystkj�tt","Lyst_kj�tt");
		languageToNorwegian.put("lyst Kj�tt","Lyst_kj�tt");
		languageToNorwegian.put("white meat","Lyst_kj�tt");
		languageToNorwegian.put("light meat","Lyst_kj�tt");
		languageToNorwegian.put("Light meat","Lyst_kj�tt");
		languageToNorwegian.put("light Meat","Lyst_kj�tt");
		languageToNorwegian.put("storvilt","Storvilt");
		languageToNorwegian.put("Storvilt","Storvilt");
		
		languageToNorwegian.put("big animals","Storvilt");

		

		languageToNorwegian.put("smal animals and birds","Sm�vilt_og_fugl");
		languageToNorwegian.put("sm�vilt og fugl","Sm�vilt_og_fugl");
		languageToNorwegian.put("beef","Storfe");
		languageToNorwegian.put("storfe","Storfe");
		languageToNorwegian.put("fisk","Fisk");
		languageToNorwegian.put("lam og sau","Lam_og_sau");
		languageToNorwegian.put("sheep","Lam_og_sau");
		languageToNorwegian.put("svinekj�tt","Svinekj�tt");
		languageToNorwegian.put("pork","Svinekj�tt");
		languageToNorwegian.put("svinekj�tt","Svinekj�tt");
		languageToNorwegian.put("svinekj�tt","Svinekj�tt");
		languageToNorwegian.put("apertiff","Apertiff");
		languageToNorwegian.put("apertif","Apertiff");
		languageToNorwegian.put("aperitif","Apertiff");

		languageToNorwegian.put("shellfish","Skalldyr");
		languageToNorwegian.put("skalldyr","Skalldyr");
		languageToNorwegian.put("skall dyr","Skalldyr");
		
		languageToNorwegian.put("dessert","Dessert");
		languageToNorwegian.put("dessert","Dessert");

		languageToNorwegian.put("vegetables","Gr�nnsaker");
		languageToNorwegian.put("gr�nnsaker","Gr�nnsaker");
		languageToNorwegian.put("fish","Fisk");
		languageToNorwegian.put("fisk","Fisk");
	
		
		
	}

}