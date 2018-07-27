package br.com.uol.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseFileUtils {
	
	
	public static List<String> getListVingadores(String json) {
		
		List<String> codinames = new ArrayList<String>();
		
		JsonParser parser = new JsonParser();
		
		JsonObject jsonObject = parser.parse(json).getAsJsonObject();
		
		JsonArray jsonArray = jsonObject.get("vingadores").getAsJsonArray();
		
		for(JsonElement el : jsonArray) {
			codinames.add(el.getAsJsonObject().get("codinome").getAsString());
		}
		
		return codinames;
	}
	
	public static List<String> getListLigaDaJustica(String xml) {
		
		List<String> codinames = new ArrayList<String>();
		
		try {
			
			JsonParser parser = new JsonParser();
			
			JSONObject jsonFormatado = XML.toJSONObject(xml);
			
			JsonObject jsonObject = parser.parse(jsonFormatado.toString()).getAsJsonObject();
			
			JsonArray jsonArray = jsonObject.get("liga_da_justica").getAsJsonObject().get("codinomes").getAsJsonObject().get("codinome").getAsJsonArray();
			
			for(JsonElement el : jsonArray) {
				codinames.add(el.getAsString());
			}
					
					
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return codinames;
	}

}
