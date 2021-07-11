package LojaDeGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import LojaDeGames.model.Categoria;

@Repository 
// indica que a Classe é uma Repository,
// ou seja, é responsável pela comunicação com o Banco de dados através dos métodos
// padrão e das Method Queries, que são consultas personalizadas através de palavras
// chave que representam as instruções da linguagem SQL.

public interface CategoriaRepository extends JpaRepository<Categoria, Long> { 
	// Trazendo por herança a classe Categoria.	
	
	public List<Categoria> findAllByGeneroContainingIgnoreCase(String genero);
	// Criando método para efetuar consultas através do atributo Gênero.	


	
}
