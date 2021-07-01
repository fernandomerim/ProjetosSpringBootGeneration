package LojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LojaDeGames.model.Categoria;
import LojaDeGames.repository.CategoriaRepository;


// “End point”, é a camada responsável por manipular todas as
//requisições feitas do lado de fora da nossa API, essas requisições são feitas através
//de URL’s seguindo o protocolo HTTP

@RestController 
@RequestMapping("/categorias")
@CrossOrigin("*")


public class CategoriaController {
	
	@Autowired
	private CategoriaRepository catRepository;	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll (){
		return ResponseEntity.ok(catRepository.findAll());
	}

	//Crie um método findById no controller
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> GetbyId(@PathVariable long id) {
		return catRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Crie um método findByDescricaoCategoria no Controller
		@GetMapping ("/genero{genero}")
		public ResponseEntity<List<Categoria>> GetbyGenero(@PathVariable String genero) {
			return ResponseEntity.ok(catRepository.findAllByGeneroContainingIgnoreCase(genero));
		
		}
				
	// Crie um endPoint com a função de gravar uma nova categoria no banco de dados.
		@PostMapping
		public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(catRepository.save(categoria));
		}
	
	// Crie um endPoint com a função de atualizar dados de uma categoria.
		@PutMapping
		public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.OK).body(catRepository.save(categoria));
		}
	
	// Crie um endPoint com a função de apagar uma categoria do banco de dados.
		@DeleteMapping("/{id}")
		public void deleteCategoria(@PathVariable long id) {
			catRepository.deleteById(id);

		}
		
}
