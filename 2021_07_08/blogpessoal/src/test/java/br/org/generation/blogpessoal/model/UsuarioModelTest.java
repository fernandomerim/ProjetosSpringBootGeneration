package br.org.generation.blogpessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioModelTest {
	
	public Usuario usuario;
	
	/* Injeta um Objeto da Classe Validator, responsável pela Validação dos Atributos da Model*/
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	public void start() {
		// Incluir as informações de ID, nome de usuário, e-mail e senha.
		usuario = new Usuario(0L, "Fernando Silva", "fernandosilva@hotmail.com", "12345678");
	    
	}
	
	@Test
	// metodo para alterar - equivalente ao PUT
    public void testValidationAtributos(){
       
		usuario.setNome("Eduardo Oliveira");
		usuario.setUsuario("eduardooliveira@hotmail.com");
		usuario.setSenha("87654321");
        
		//Armazena a lista de Mensagens de Erros de Validação da Model
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        
		//Exibe as Mensagens de Erro se existirem
		System.out.println(violations.toString());
        
        //O Teste só passará se a Lista de Erros estiver vazia!
        assertTrue(violations.isEmpty());
                
    }

}
