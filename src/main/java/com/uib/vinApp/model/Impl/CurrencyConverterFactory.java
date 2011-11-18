package com.uib.vinApp.model.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * This class consist of one method that is a currency converter
 * that takes in a currency code such as NOK and an amount in int
 * 
 */

abstract class CurrencyConverterFactory {

	public static int convertToNOK(String currencyCode, int amount) throws IOException{
		int amountInNOK =0;
		String webSite ="http://www.google.com/finance/converter?a="+amount+"&from="+currencyCode+"&to=NOK";
		URL currencyURL = new URL(webSite);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						currencyURL.openStream()));
		String inputLine;
		String codeTag ="<span class=bld>";
		while ((inputLine = in.readLine()) != null){	 
			if(inputLine.contains(codeTag)){
				inputLine = inputLine.substring(inputLine.indexOf(codeTag)+codeTag.length());
				inputLine = inputLine.substring(0, inputLine.indexOf("."));
				amountInNOK = Integer.parseInt(inputLine.trim());
			}

		}
		in.close();
		return amountInNOK;
	}
	public static void main(String[] args) {
		try {
		System.out.println(	convertToNOK("NOK", 200));
		System.out.println(	convertToOtherCurrency("USD", 200));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int convertToOtherCurrency(String currencyCode, int amountInNok) throws IOException{
		int amountInNOK =0;
		String webSite ="http://www.google.com/finance/converter?a="+amountInNok+"&from=NOK&to="+currencyCode;
		URL currencyURL = new URL(webSite);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						currencyURL.openStream()));
		String inputLine;
		String codeTag ="<span class=bld>";
		while ((inputLine = in.readLine()) != null){	 
			if(inputLine.contains(codeTag)){
				inputLine = inputLine.substring(inputLine.indexOf(codeTag)+codeTag.length());
				inputLine = inputLine.substring(0, inputLine.indexOf("."));
				amountInNOK = Integer.parseInt(inputLine.trim());
			}

		}
		in.close();
		return amountInNOK;
	}

}
