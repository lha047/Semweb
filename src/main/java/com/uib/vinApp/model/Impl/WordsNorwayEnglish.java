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
		negationList.put("ikke søt","notSweet");
		negationList.put("not sweet","notSweet");
		languageToNorwegian.put("red wine", "Rødvin");
		languageToNorwegian.put("Red wine", "Rødvin");
		languageToNorwegian.put("rødvin", "Rødvin");
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
		languageToNorwegian.put("har sødme","sweetnes");
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
		languageToNorwegian.put("rosèvin","Rosevin");
		languageToNorwegian.put("Rosèvin","Rosevin");
		languageToNorwegian.put("rosè wine","Rosevin");
		languageToNorwegian.put("Rosè wine","Rosevin");
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
		languageToNorwegian.put("søt","isSweet");
		languageToNorwegian.put("sweet","isSweet");
		languageToNorwegian.put("ikke frisk","notFrisk");
		languageToNorwegian.put("not fresh","notFrisk");
		languageToNorwegian.put("ikke fyldig","notFylde");
		languageToNorwegian.put("not rich","notFylde");
		languageToNorwegian.put("ikke syrlig","notGarvesyre");
		languageToNorwegian.put("not tannin","notGarvesyre");
		languageToNorwegian.put("ikke søt","notSweet");
		languageToNorwegian.put("not sweet","notSweet");
		languageToNorwegian.put("Øl","Øl");
		languageToNorwegian.put("øl","Øl");
		languageToNorwegian.put("beer","Øl");
		languageToNorwegian.put("Ost","Ost");
		languageToNorwegian.put("ost","Ost");
		languageToNorwegian.put("cheese","Ost");
		languageToNorwegian.put("cost","pris");
		/*
		 * Lyst_kjøtt
Storvilt
Småvilt_og_fugl
Ost
Storfe
Fisk
Lam_og_sau
Svinekjøtt
Apertiff
Skalldyr
Dessert
Grønnsaker

		 */
		languageToNorwegian.put("lyst kjøtt","Lyst_kjøtt");
		languageToNorwegian.put("Lyst Kjøtt","Lyst_kjøtt");
		languageToNorwegian.put("Lystkjøtt","Lyst_kjøtt");
		languageToNorwegian.put("lystkjøtt","Lyst_kjøtt");
		languageToNorwegian.put("lyst Kjøtt","Lyst_kjøtt");
		languageToNorwegian.put("white meat","Lyst_kjøtt");
		languageToNorwegian.put("light meat","Lyst_kjøtt");
		languageToNorwegian.put("Light meat","Lyst_kjøtt");
		languageToNorwegian.put("light Meat","Lyst_kjøtt");
		languageToNorwegian.put("storvilt","Storvilt");
		languageToNorwegian.put("Storvilt","Storvilt");
		
		languageToNorwegian.put("big animals","Storvilt");

		

		languageToNorwegian.put("smal animals and birds","Småvilt_og_fugl");
		languageToNorwegian.put("småvilt og fugl","Småvilt_og_fugl");
		languageToNorwegian.put("beef","Storfe");
		languageToNorwegian.put("storfe","Storfe");
		languageToNorwegian.put("fisk","Fisk");
		languageToNorwegian.put("lam og sau","Lam_og_sau");
		languageToNorwegian.put("sheep","Lam_og_sau");
		languageToNorwegian.put("svinekjøtt","Svinekjøtt");
		languageToNorwegian.put("pork","Svinekjøtt");
		languageToNorwegian.put("svinekjøtt","Svinekjøtt");
		languageToNorwegian.put("svinekjøtt","Svinekjøtt");
		languageToNorwegian.put("apertiff","Apertiff");
		languageToNorwegian.put("apertif","Apertiff");
		languageToNorwegian.put("aperitif","Apertiff");

		languageToNorwegian.put("shellfish","Skalldyr");
		languageToNorwegian.put("skalldyr","Skalldyr");
		languageToNorwegian.put("skall dyr","Skalldyr");
		
		languageToNorwegian.put("dessert","Dessert");
		languageToNorwegian.put("dessert","Dessert");

		languageToNorwegian.put("vegetables","Grønnsaker");
		languageToNorwegian.put("grønnsaker","Grønnsaker");
		languageToNorwegian.put("fish","Fisk");
		languageToNorwegian.put("fisk","Fisk");
	
		
		
	}

}