package br.com.uol.facade;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.uol.dto.PlayerDTO;
import br.com.uol.entity.PlayerEntity;
import br.com.uol.exception.CodeNameException;
import br.com.uol.service.PlayerService;
import br.com.uol.utils.ParseFileUtils;

@Component
public class PlayerFacadeImpl implements PlayerFacade {
	
	private PlayerService playerService;
	
	private ModelMapper modelMapper;
	
	private RestTemplate restTemplate;
	
	@Value("${url.file.ligadajustica}")
	private String urlLigaDaJustica;  
	
	@Value("${url.file.vingadores}")
	private String urlVingadores;
	
	@Autowired
	public PlayerFacadeImpl(PlayerService playerService, ModelMapper modelMapper, RestTemplate restTemplate) {
		this.playerService = playerService;
		this.modelMapper = modelMapper;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<PlayerDTO> findAll() {
		
		List<PlayerEntity> players = this.playerService.findAll();
		
		List<PlayerDTO> playersDTO = new ArrayList<PlayerDTO>();
		
		players.stream().forEach(player -> playersDTO.add(this.modelMapper.map(player, PlayerDTO.class)));
		
		return playersDTO;
	}

	@Override
	public void excluir(Long id) {
		this.playerService.excluir(id);
	}

	@Override
	public PlayerDTO findOne(Long id) {
		PlayerEntity player = this.playerService.findOne(id);
		
		PlayerDTO dto = null;
		
		if(player != null) {
			dto = this.modelMapper.map(player, PlayerDTO.class);
		}
		
		return dto;
	}

	@Override
	public void update(PlayerDTO playerDTO) {
		
		PlayerEntity player = this.modelMapper.map(playerDTO, PlayerEntity.class);
		
		this.playerService.update(player);
	}
	
	@Override
	public void cadastrar(PlayerDTO playerDTO) {
		
		PlayerEntity player = this.modelMapper.map(playerDTO, PlayerEntity.class);
		
		List<String> codinames = new ArrayList<String>();
		
		String group = "";
		
		List<String> codinamesCadastrados = new ArrayList<String>();
		
		if(playerDTO.getGroup().equals("1")) {
			group = "Liga da Justiça";
			String response = this.restTemplate.getForObject(this.urlLigaDaJustica, String.class);
			codinames = ParseFileUtils.getListLigaDaJustica(response);
			codinamesCadastrados = this.playerService.findIsCodinamesForUse(codinames, group);
		} else {
			group = "Vingadores";
			String response = this.restTemplate.getForObject(this.urlVingadores, String.class);
			codinames = ParseFileUtils.getListVingadores(response);
			codinamesCadastrados = this.playerService.findIsCodinamesForUse(codinames, group);
		}
		
		Boolean isSaveSuccess = false;
		for(String name : codinames) {
			if(!codinamesCadastrados.contains(name)) {
				player.setCodename(name);
				player.setGroup(group);
				this.playerService.cadastrar(player);
				isSaveSuccess = true;
			}
		}
		
		
		if(!isSaveSuccess) {
			throw new CodeNameException("001");
		}
		
	}

}
