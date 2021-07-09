package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	public void start() {
		Usuario usuario = new Usuario(0L, "Chefe", "chefe@hotmail.com", "9xxxxxxx9");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Novo Chefe", "novochefe@hotmail.com", "8xxxxxxx8");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "chefe Mais Antigo", "chefeantigo@hotmail.com", "7xxxxxxx7");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
			usuarioRepository.save(usuario);

		usuario = new Usuario(0L, "Amigo", "chefeamigo@hotmail.com", "5xxxxxxx5");
		if (usuarioRepository.findFirstByNome(usuario.getNome()) == null)
			usuarioRepository.save(usuario);
	}

	@Test
	public void findByNomeRetornaUsuario() throws Exception {

		Usuario usuario = usuarioRepository.findFirstByNome("Chefe");

		assertTrue(usuario.getNome().equals("Chefe"));
	}

	@Test
	public void findAllByNomeIgnoreCaseRetornaTresUsuario() {

		List<Usuario> usuario = usuarioRepository.findAllByNomeIgnoreCaseContaining("chefe");

		assertEquals(3, usuario.size());
	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}