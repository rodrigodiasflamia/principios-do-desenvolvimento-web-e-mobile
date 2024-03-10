package br.com.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estoque.model.Produto;
import br.com.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = false)
	public void save(final Produto produto) {
		this.produtoRepository.save(produto);
	}

	public List<Produto> findAll(){
		return this.produtoRepository.findAll();
	}

	@Transactional(readOnly = false)
	public void deleteById(final Long codigo) {
		this.produtoRepository.deleteById(codigo);
	}
}
