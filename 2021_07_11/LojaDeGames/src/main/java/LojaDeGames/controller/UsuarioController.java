package LojaDeGames.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LojaDeGames.model.Usuario;
import LojaDeGames.model.UsuarioLogin;
import LojaDeGames.service.UsuarioService;

@RestController 
@RequestMapping("/usuarios")
@CrossOrigin("*")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticationUsuario(@RequestBody Optional<UsuarioLogin> usuario) {
		return usuarioService.logarUsuario(usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Usuario>> postUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> novoUsuario = usuarioService.cadastrarUsuario(usuario);
		try {
				return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}


