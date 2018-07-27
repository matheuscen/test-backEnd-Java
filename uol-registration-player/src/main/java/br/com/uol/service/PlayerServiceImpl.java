package br.com.uol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uol.entity.PlayerEntity;
import br.com.uol.exception.PlayerNotFoundException;
import br.com.uol.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@Override
	public List<PlayerEntity> findAll() {
		return (List<PlayerEntity>) this.playerRepository.findAll();
	}

	@Override
	public void cadastrar(PlayerEntity player) {
		this.playerRepository.save(player);
	}

	@Override
	public void excluir(Long id) {
		this.playerRepository.delete(id);
	}

	@Override
	public PlayerEntity findOne(Long id) {
		
		PlayerEntity entity =  this.playerRepository.findOne(id);
		
		if(entity == null) {
			throw new PlayerNotFoundException("Jogador não encontrado");
		}	
		return entity;
	}

	@Override
	public void update(PlayerEntity player) {
		
		PlayerEntity entity = this.playerRepository.findOne(player.getId());
		
		if(entity != null) {
			entity.setEmail(player.getEmail());
			entity.setName(player.getName());
			entity.setPhone(player.getPhone());
			this.playerRepository.save(entity);
		} else {
			throw new PlayerNotFoundException("Jogador não encontrado");
		}	
	}

	@Override
	public List<String> findIsCodinamesForUse(List<String> codinames, String group) {
		List<String> codenames = this.playerRepository.findIsCodinamesForUse(codinames , group);
		return codenames;
	}

}
