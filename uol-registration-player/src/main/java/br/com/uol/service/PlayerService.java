package br.com.uol.service;

import java.util.List;

import br.com.uol.entity.PlayerEntity;

public interface PlayerService {
	
	
	public List<PlayerEntity> findAll();

	public void cadastrar(PlayerEntity player);

	public void excluir(Long id);

	public PlayerEntity findOne(Long id);

	public void update(PlayerEntity player);

	public List<String> findIsCodinamesForUse(List<String> codinames, String group);

}
