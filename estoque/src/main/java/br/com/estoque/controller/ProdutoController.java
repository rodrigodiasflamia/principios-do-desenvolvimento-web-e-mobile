package br.com.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.estoque.model.Produto;
import br.com.estoque.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/cadastrar")
	public String form(final Produto produto) {
		return "produto/formulario";
	}

	@PostMapping("/salvar")
	public String create(final Produto produto) {
		this.produtoService.save(produto);
		return "redirect:/cadastrar";
	}

	@GetMapping("/listar")
	public String read(final ModelMap mp) {
		final List<Produto> produtos = this.produtoService.findAll();
		mp.addAttribute("produtos", produtos);
		return "listar";
	}

	@GetMapping("/excluir/{codigo}")
	public String delete(@PathVariable("codigo") final Long codigo) {
		this.produtoService.deleteById(codigo);
		return "redirect:/listar";
	}
}