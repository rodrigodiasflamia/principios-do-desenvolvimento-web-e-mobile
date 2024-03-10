package br.com.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estoque.model.Produto;
import br.com.estoque.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String form(final Produto produto) {
		return "produto/formulario";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String create(final Produto produto) {
		this.produtoService.save(produto);
		return "redirect:/cadastrar";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String read(final ModelMap mp) {
		final List<Produto> produtos = this.produtoService.findAll();
		mp.addAttribute("produtos", produtos);
		return "listar";
	}

	@RequestMapping(value = "/excluir/{codigo}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo") final Long codigo) {
		this.produtoService.deleteById(codigo);
		return "redirect:/listar";
	}
}