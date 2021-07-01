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

import NossaFarmacia.model.Produto;
import NossaFarmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")

public class ProdutoController {

	@Autowired
	private ProdutoRepository prodRepository;

	// findAllProduto = um endPoint com a capacidade de trazer todos os Produtos .
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(prodRepository.findAll());
	}

	// findByIDProduto = um endPoint com a função de trazer uma único Produto por
	// id.
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetbyId(@PathVariable long id) {
		return prodRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// findByDescricaoTitulo = um endPoint com a função de trazer um único Produto
	// por Titulo.
	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Produto>> GetbyProduto(@PathVariable String nomeProduto) {
		return ResponseEntity.ok(prodRepository.findAllBynomeProdutoContainingIgnoreCase(nomeProduto));

	}

	// postProduto = um endPoint com a função de gravar um novo Produto no banco de
	// dados.
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(prodRepository.save(produto));

	}

	// putProduto = um endPoint com a função de atualizar dados de um Produto .
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(prodRepository.save(produto));
	}

	// deleteProduto = um endPoint com a função de apagar um Produto do banco de dados).
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		prodRepository.deleteById(id);

	}

}
