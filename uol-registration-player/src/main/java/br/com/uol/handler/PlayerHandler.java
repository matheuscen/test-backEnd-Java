package br.com.uol.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.uol.exception.CodeNameException;
import br.com.uol.exception.PlayerNotFoundException;

@ControllerAdvice
public class PlayerHandler {
	
	@ExceptionHandler(CodeNameException.class)
	public ResponseEntity<?> allCodeNameRegistration(Throwable ex) {
		return ResponseEntity.ok("001");
	}
	
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<?> playerNotFound(Throwable ex) {
		return ResponseEntity.ok("002");
	}
	
}
