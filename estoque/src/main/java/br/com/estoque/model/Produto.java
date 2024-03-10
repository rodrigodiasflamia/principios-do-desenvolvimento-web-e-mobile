package br.com.estoque.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@NotBlank
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@NotBlank
	@Column(name = "QUANTIDADE", nullable = false)
	private long quantidade;

	@NotBlank
	@Column(name = "VALOR_CUSTO", nullable = false)
	private float custo;

	@NotBlank
	@Column(name = "VALOR_VENDA", nullable = false)
	private float venda;

	public long getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public long getQuantidade() {
		return this.quantidade;
	}

	public float getCusto() {
		return this.custo;
	}

	public float getVenda() {
		return this.venda;
	}

	public void setCodigo(final long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidade(final long quantidade) {
		this.quantidade = quantidade;
	}

	public void setCusto(final float custo) {
		this.custo = custo;
	}

	public void setVenda(final float venda) {
		this.venda = venda;
	}
}