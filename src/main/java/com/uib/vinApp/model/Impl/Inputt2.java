package com.uib.vinApp.model.Impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Inputt2 {

	public static ArrayList<String>  inputtString(String inputtString){

		try {
			VineModelFactory.startModelAndGetModel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> passertilListe = new ArrayList<String>();
		passertilListe.add("Lyst_kjøtt");
		passertilListe.add("Storvilt");
		passertilListe.add("Småvilt_og_fugl");
		passertilListe.add("Ost");
		passertilListe.add("Storfe");
		passertilListe.add("Fisk");
		passertilListe.add("Lam_og_sau");
		passertilListe.add("Svinekjøtt");
		passertilListe.add("Apertiff");
		passertilListe.add("Skalldyr");
		passertilListe.add("Dessert");
		passertilListe.add("Grønnsaker");

		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
		ArrayList<String> vareliste = new ArrayList<String>();
		vareliste.add("Rødvin");
		vareliste.add("Øl");
		vareliste.add("Hvitvin");
		vareliste.add("Alkoholfritt");
		vareliste.add("Brennevin");
		vareliste.add("Fruktvin");
		vareliste.add("Hvitvin");
		vareliste.add("Rosevin");
		vareliste.add("MusserendeVin");
		vareliste.add("Sterkvin");

		ArrayList<String> connectListe = new ArrayList<String>();

		connectListe.add("kommerFra");
		connectListe.add("passerTil");

		ArrayList<String> connectListeTall = new ArrayList<String>();

		connectListeTall.add("pris");
		connectListeTall.add("volum");
		connectListeTall.add("garvesyre");
		connectListeTall.add("varenummer");
		connectListeTall.add("sweetnes");
		connectListeTall.add("bitterhet");
		connectListeTall.add("alkoprosent");
		connectListeTall.add("friskhet");
		connectListeTall.add("fylde");

		ArrayList<String> booleanListe = new ArrayList<String>();
		booleanListe.add("isSweet");
		booleanListe.add("notSweet");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");
		booleanListe.add("");

		HashMap<String, String> operatorer = new HashMap<String, String>();
		operatorer.put("mer enn", ">");
		operatorer.put("mer", ">");
		operatorer.put("mindre enn", ">");
		operatorer.put("mindre", ">");

		//		String in = " Rødvin som kommerFra Europa og har pris <100 og har volum >30 og eller hvitvin kommerFra Afrika";
		//		String in = " musserendevin som koster <120 og er fra Europa og er ikke søt and goes well with fish eller beer som koster <200";
		String in = " "+inputtString+" ";
		in = WordsNorwayEnglish.manupulatetInputt(in);
		System.out.println(in);
		String[] antallQuery = in.split("eller");
		String query ="";
		for(String s : antallQuery){
			String[] sp = s.split(" ");
			ArrayList<String> qu = new ArrayList<String>();
			for(String t : sp){
				if(!t.equals("og") && !t.equals("som")  && !t.equals("har")&& !t.equals("er")){
					qu.add(t);
				}

			}
			boolean vare = false;
			while (!qu.isEmpty()){
				System.out.println(qu.get(0));

				if(vareliste.contains(qu.get(0))){
					if(query.equals("")){
						vare = true;
						query += "?x rdf:type wine:"+qu.get(0);
						qu.remove(0);
						if(!qu.isEmpty()){
							query+=".";
						}
					}else if(vare){
						System.out.println("FEIL I QUARY");
						qu.remove(0);
					}

				}
				else if(!vare){
					System.out.println("FEIL");
					qu.remove(0);
				}
				else if(connectListe.contains(qu.get(0))){

					if(qu.get(0).equals("kommerFra")){ 
						String testString = qu.toString();
						System.out.println(testString);
						testString = testString.substring(1, testString.length()-1);
						testString = testString.replaceFirst("kommerFra,", "");
						testString = testString.replace(",", "");
						testString = testString.trim();
						System.out.println(testString);

						Map<String, String> country =VineModelFactory.countryModel;
						Iterator<String> iter = country.keySet().iterator();
						String countryName = "";
						int removercounter = 0;
						while (iter.hasNext()) {

							String key = (String) iter.next();
							String value =country.get(key);
							if(testString.startsWith(key)){
								removercounter = key.split(" ").length;
								countryName = value;
								break;
							}

						}
						if(countryName.equals("")){
							System.out.println(" NOT CORRECT");
						}
						else{
							query += "?x wine:"+qu.get(0)+" wine:"+countryName+"";
							qu.remove(0);
							for(int y = 0; y<removercounter;y++){
								qu.remove(0);
							}
							if(!qu.isEmpty()){
								query+=".";
							}

						}
					}

					else if(qu.size()>1){
						if(!passertilListe.contains(qu.get(1))){
							System.out.println("NOT CORRECT");
							qu.remove(0);
						}
						else{
							query += "?x wine:"+qu.get(0)+" wine:"+qu.get(1)+"";
							qu.remove(0);
							qu.remove(0);
							if(!qu.isEmpty()){
								query+=".";
							}
						}
					}

				}
				else if(connectListeTall.contains(qu.get(0))){
					if(qu.size()>1){
						Random r = new Random();
						String nextRanom = ""+r.nextInt(10000);
						r.nextInt(13);
						if(!qu.get(1).startsWith("<")&& !qu.get(1).startsWith(">")){
							qu.set(1, "="+ qu.get(1));
						}
						query += "?x wine:"+qu.get(0)+" ?"+nextRanom + ". FILTER ( ?"+nextRanom +" "+qu.get(1)+")";
						qu.remove(0);
						qu.remove(0);
						if(!qu.isEmpty()){
							query+=".";
						}
					}
				}

				else if(booleanListe.contains(qu.get(0))){
					query += "?x rdf:type wine:"+qu.get(0);
					qu.remove(0);

					if(!qu.isEmpty()){
						query+=".";
					}
				}
				else{
					qu.remove(0);
				}

			}
			System.out.println(query);
			ArrayList<String> temp = QueryAndMerge.runQueryWithOneVariable(VineModelFactory._tempModel, query);
			if(temp ==null){

			}
			else{
				resultList.add(temp);
			}

			query ="";

		}
		ArrayList<String> returnResult = new ArrayList<String>();
		for(ArrayList<String> list : resultList){
			for(String result : list){

				returnResult.add(result);
			}
		}
		return returnResult;

	}
}
