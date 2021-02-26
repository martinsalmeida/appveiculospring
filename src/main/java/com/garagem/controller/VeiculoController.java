package com.garagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.garagem.entity.Veiculo;
import com.garagem.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	VeiculoService service;

	@GetMapping("/novo")
	public String novo(Veiculo veiculo) {
		return "frmveiculo";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("lstVeiculos", service.findAll());
		return "lstveiculos";
	}

	@PostMapping("/salvar")
	public String salvar(Veiculo veiculo, RedirectAttributes attr) {
		service.saveOrUpdate(veiculo);
		attr.addFlashAttribute("msg", "Veículo inserido com sucesso!");
		return "redirect:/novo";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Veiculo objVeiculo, ModelMap model) {
		model.addAttribute("objVeiculo", objVeiculo);
		return "frmveiculo";
	}

	@PostMapping("/editar")
	public String editar(Veiculo veiculo, RedirectAttributes attr) {
		service.saveOrUpdate(veiculo);
		attr.addFlashAttribute("msg", "Veículo alterado com sucesso!");
		return "redirect:/novo";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.delete(id);
		model.addAttribute("msg", "Veículo excluído com sucesso!");
		return listar(model);
	}

}
