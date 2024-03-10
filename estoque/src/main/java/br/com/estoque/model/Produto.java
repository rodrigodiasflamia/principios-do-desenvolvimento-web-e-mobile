package br.com.estoque.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "Quantidade é um campo obrigatório!")
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@NotNull(message = "Quantidade é um campo obrigatório!")
	@Column(name = "QUANTIDADE", nullable = false)
	private Long quantidade;

	@NotNull(message = "Valor de Custo é um campo obrigatório!")
	@Column(name = "VALOR_CUSTO", nullable = false)
	private Float custo;

	@NotNull(message = "Valor de Venda é um campo obrigatório!")
	@Column(name = "VALOR_VENDA", nullable = false)
	private Float venda;

	public Long getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Long getQuantidade() {
		return this.quantidade;
	}

	public Float getCusto() {
		return this.custo;
	}

	public Float getVenda() {
		return this.venda;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidade(final Long quantidade) {
		this.quantidade = quantidade;
	}

	public void setCusto(final Float custo) {
		this.custo = custo;
	}

	public void setVenda(final Float venda) {
		this.venda = venda;
	}
}