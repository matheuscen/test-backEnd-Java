package br.com.uol.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.uol.dto.PlayerDTO;
import br.com.uol.facade.PlayerFacade;

@RestController("/")
public class PlayerController {
	
	private PlayerFacade playerFacade;
	
	@Autowired
	public PlayerController(PlayerFacade playerFacade) {
		this.playerFacade = playerFacade;
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.GET)
    public PlayerDTO findOne(@RequestParam Long id) {
          return this.playerFacade.findOne(id);
    }
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
    public ResponseEntity<?> player(@RequestBody PlayerDTO playerDTO) {
          this.playerFacade.cadastrar(playerDTO);
          return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "/player", method = RequestMethod.DELETE)
    public ResponseEntity<?> player(@RequestParam Long id) {
          this.playerFacade.excluir(id);
          return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "/player", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePlayer(@RequestBody PlayerDTO playerDTO) {
          this.playerFacade.update(playerDTO);
          return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<PlayerDTO> findAll(Model model) {
          return this.playerFacade.findAll();
    }
 

}
