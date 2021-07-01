package NossaFarmacia.controller;

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

import NossaFarmacia.model.Categoria;
import NossaFarmacia.repository.CategoriaRepository;

@RestController 
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CategoriaController {

	@Autowired
	private CategoriaRepository catRepository;

	// findAllCategoria = um endPoint com a capacidade de trazer todas as
	// categorias.
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(catRepository.findAll());

	}

	// findByIDCategoria = um endPoint com a função de trazer uma única categoria
	// por id.
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetbyId(@PathVariable long id) {
		return catRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// findByDescricaoCategoria = um endPoint com a função de trazer uma categoria por Descricao.
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> GetbyCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(catRepository.findAllByCategoriaContainingIgnoreCase(categoria));

	}
	
	//postCategoria = um endPoint com a função de gravar uma nova categoria no banco de dados.
	@PostMapping
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(catRepository.save(categoria));
		
	}
	
	// putCategoria = um endPoint com a função de atualizar dados de uma categoria.
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(catRepository.save(categoria));
	}
	
	// deleteCategoria = um endPoint com a função de apagar uma categoria do banco de dados).
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		catRepository.deleteById(id);
		
	}
	
	
}
