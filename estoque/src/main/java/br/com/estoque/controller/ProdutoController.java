package br.com.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estoque.model.Produto;
import br.com.estoque.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String form() {
		return "produto/formulario";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String create(final Produto produto) {
		this.produtoService.save(produto);
		return "redirect:/produto/formulario";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelMap read(final ModelMap mp) {
		final List<Produto> produtos = this.produtoService.findAll();
		mp.addAttribute("produtos", produtos);
		return mp;
	}
}
