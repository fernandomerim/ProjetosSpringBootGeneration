package LojaDeGames.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Criar tabela

@Entity //create table
@Table(name = "tb_produtos") //dando nome a tabela

// Inserir atributos na tabela
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	@NotNull(message = "O atributo nomeProduto é obrigatório!")
	@Size(min =3, max = 100, message = "O atributo nomeProduto deve ter no minimo 03 e no maximo 100 caracterers")
	private String nomeProduto;
	
	@NotNull(message = "O atributo preço é obrigatório!")
	private BigDecimal preco;
	
	@NotNull(message = "O atributo quantidade é obrigatório!")
	private int qtdEstoque;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

}
