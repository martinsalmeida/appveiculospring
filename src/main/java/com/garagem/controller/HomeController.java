package com.garagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/") // Mapeamento da url da aplicação
	public String home() {
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		return "index"; // "index" é o nome do arquivo. Será feito um redirect para a página index.jsp
	}
}
