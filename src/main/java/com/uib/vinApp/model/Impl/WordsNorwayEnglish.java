import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.uib.vinApp.Interface.IWordsNorwayEnglish;

@Component
public class WordsNorwayEnglish implements IWordsNorwayEnglish{

	private HashMap<String, String> languageToNorwegianObject;
	private HashMap<String, String> languageToNorwegianPredicate;


	public WordsNorwayEnglish() {
		createWordList();
	}
	
	public HashMap<String, String> getWordListObject() {
		return languageToNorwegianObject;
	}
	
	public HashMap<String, String> getWordListPredicate() {
		return languageToNorwegianPredicate;
	}
		
	private void createWordList() {
		languageToNorwegianPredicate = new HashMap<String, String>();
		languageToNorwegianObject = new HashMap<String, String>();
		languageToNorwegianObject.put("red wine", "Rødvin");
		languageToNorwegianObject.put("rødvin", "Rødvin");
		languageToNorwegianObject.put("white wine", "Hvitvin");
		languageToNorwegianObject.put("hvitvin", "Hvitvin");
		languageToNorwegianPredicate.put("fra", "kommerFra");
		languageToNorwegianPredicate.put("from", "kommerFra");
		languageToNorwegianPredicate.put("goes well with", "passerTil");
		languageToNorwegianPredicate.put("passer til", "passerTil");
		languageToNorwegianPredicate.put("har alkoholprosent","alkoprosent");
		languageToNorwegianPredicate.put("have alcohol percentage","alkoprosent");
		languageToNorwegianPredicate.put("har bitterhet","bitterhet");
		languageToNorwegianPredicate.put("have bitterness","bitterhet");
		languageToNorwegianPredicate.put("har friskhet","friskhet");
		languageToNorwegianPredicate.put("have freshness","friskhet");
		languageToNorwegianPredicate.put("har fylde","fylde");
		languageToNorwegianPredicate.put("have richness","fylde");
		languageToNorwegianPredicate.put("har garvesyre","garvesyre");
		languageToNorwegianPredicate.put("have tannin","garvesyre");
		languageToNorwegianPredicate.put("har pris","pris");
		languageToNorwegianPredicate.put("have price","pris");
		languageToNorwegianPredicate.put("har sødme","sweetnes");
		languageToNorwegianPredicate.put("have sweetnes","sweetnes");
		languageToNorwegianPredicate.put("har varenummer","varenummer");
		languageToNorwegianPredicate.put("have item number","varenummer");
		languageToNorwegianPredicate.put("have volume","volum");
		languageToNorwegianPredicate.put("har volume","volum");
		languageToNorwegianObject.put("alkoholfritt","Alkoholfritt");
		languageToNorwegianObject.put("alcohol-free","Alkoholfritt");
		languageToNorwegianObject.put("brennevin","Brennevin");
		languageToNorwegianObject.put("liquor","Brennevin");
		languageToNorwegianObject.put("fruit wine","Fruktvin");
		languageToNorwegianObject.put("fruktvin","Fruktvin");
		languageToNorwegianObject.put("sparkling wine","MusserendeVin");
		languageToNorwegianObject.put("musserende vin","MusserendeVin");
		languageToNorwegianObject.put("rosevin","Rosévin");
		languageToNorwegianObject.put("rosévin","Rosévin");
		languageToNorwegianObject.put("rosé wine","Rosévin");
		languageToNorwegianObject.put("strong wine","Sterkvin");
		languageToNorwegianObject.put("sterkvin","Sterkvin");
		languageToNorwegianObject.put("frisk","isFrisk");
		languageToNorwegianObject.put("rich","isFylde");
		languageToNorwegianObject.put("fresh","isFrisk");
		languageToNorwegianObject.put("fyldig","isFylde");
		languageToNorwegianObject.put("syrlig","isGarvesyre");
		languageToNorwegianObject.put("tannin","isGarvesyre");
		languageToNorwegianObject.put("søt","isSweet");
		languageToNorwegianObject.put("sweet","isSweet");
		languageToNorwegianObject.put("ikke frisk","notFrisk");
		languageToNorwegianObject.put("not fresh","notFrisk");
		languageToNorwegianPredicate.put("er","rdf:type");
		languageToNorwegianPredicate.put("is","rdt:type");
		languageToNorwegianObject.put("ikke fyldig","notFylde");
		languageToNorwegianObject.put("not rich","notFylde");
		languageToNorwegianObject.put("ikke syrlig","notGarvesyre");
		languageToNorwegianObject.put("not tannin","notGarvesyre");
		languageToNorwegianObject.put("ikke søt","notSweet");
		languageToNorwegianObject.put("not sweet","notSweet");
		languageToNorwegianObject.put("øl","Øl");
		languageToNorwegianObject.put("beer","Øl");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
//		languageToNorwegian.put("","");
	}

}