package br.com.uol.utils.test;

import java.util.List;

import org.junit.Test;

import br.com.uol.utils.ParseFileUtils;

public class PlayerTest {
	
	
	@Test
	public void testeParseXml() throws Exception {
		StringBuilder xml = new StringBuilder();
		
		xml.append("<liga_da_justica>");
		xml.append("<codinomes>");
		xml.append("<codinome>Lanterna Verde</codinome>");
		xml.append("<codinome>Flash</codinome>");
		xml.append("<codinome>Aquaman</codinome>");	
		xml.append("</codinomes>");
		xml.append("</liga_da_justica>");
		
		List<String> codinames = ParseFileUtils.getListLigaDaJustica(xml.toString());
		
		if(codinames.size() <= 0) {
			throw new Exception("Lista de jogadores vazia");
		}
	}
	
	@Test
	public void testeParseJson() throws Exception {
		StringBuilder json = new StringBuilder();
		
		json.append("{ \"vingadores\": [ { \"codinome\": \"Hulk\" }, ");
		json.append(" { \"codinome\": \"Capitão América\" }, ");
		json.append("{ \"codinome\": \"Pantera Negra\" }, ");
		json.append("{ \"codinome\": \"Homem de Ferro\" } ] } ");
			               				
		List<String> codinames = ParseFileUtils.getListVingadores(json.toString());
		
		if(codinames.size() <= 0) {
			throw new Exception("Lista de jogadores vazia");
		}
	}

}
