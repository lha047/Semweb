package com.uib.vinApp.model.Impl;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.uib.vinApp.model.IInput;

@Component
public class Inputt implements IInput {

	private ArrayList<String> connectListeTall;
	private ArrayList<String> connectListe;
	private ArrayList<String> vareliste;

//	public static void main(String[] args) {
//		Inputt i = new Inputt();
//		i.createQueryFromInput(" Rødvin som kommerFra Europa og har pris <100 og har volum >30 og eller hvitvin kommerFra Afrika");
//	}

	public String createQueryFromInput(String in) {
		lagListe();		

		//		String in = " Rødvin som kommerFra Europa og har pris <100 og har volum >30 og eller hvitvin kommerFra Afrika";
		//		String in = " Rødvin som har pris >100 og har pris <120 og har garvesyre 7 og passerTil Ost og kommerFra Frankrike";
		String[] antallQuery = in.split("eller");
		String query ="";
		for(String s : antallQuery){
			String[] sp = s.split(" ");
			ArrayList<String> qu = new ArrayList<String>();
			for(String t : sp){
				if(!t.equals("og") && !t.equals("som")  && !t.equals("har")){
					qu.add(t);
				}

			}
			while (!qu.isEmpty()){
				System.out.println(qu.get(0));
				if(vareliste.contains(qu.get(0))){
					query += "?x rdf:type wine:"+qu.get(0);
					qu.remove(0);
					if(!qu.isEmpty()){
						query+=".";
					}
				}
				else if(connectListe.contains(qu.get(0))){

					if(qu.size()>1){

						query += "?x wine:"+qu.get(0)+" wine:"+qu.get(1)+"";
						qu.remove(0);
						qu.remove(0);
						if(!qu.isEmpty()){
							query+=".";
						}
					}

				}
				else if(connectListeTall.contains(qu.get(0))){
					if(qu.size()>1){
						Random r = new Random();
						String nextRanom = ""+r.nextInt(100);
						String randomChar = "f";
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
				else{
					qu.remove(0);
				}

			}
			System.out.println(query);
			//			query ="";


		}
		return query;
		//		String[] te = in.split(" ");
		//			String i ="?x rdf:type vare. ?x pris  ?y. FILTER (?y <100). ?x kommerFra Spania";
		//			String ii ="?x rdf:type vare. ?x pris  ?y. FILTER (?y <100) OR ?x kommerFra Spania";
	}

	private void lagListe() {
		vareliste = new ArrayList<String>();
		vareliste.add("Rødvin");
		vareliste.add("hvitvin");

		connectListe = new ArrayList<String>();

		connectListe.add("kommerFra");
		connectListe.add("passerTil");

		connectListeTall = new ArrayList<String>();

		connectListeTall.add("pris");
		connectListeTall.add("volum");
		connectListeTall.add("garvesyre");


	}
}
