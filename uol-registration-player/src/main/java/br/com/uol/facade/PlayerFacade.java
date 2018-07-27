package br.com.uol.facade;

import java.util.List;

import br.com.uol.dto.PlayerDTO;

public interface PlayerFacade {
	
	public List<PlayerDTO> findAll();
	
	public void cadastrar(PlayerDTO playerDTO);

	public void excluir(Long id);

	public PlayerDTO findOne(Long id);

	public void update(PlayerDTO playerDTO);

}
