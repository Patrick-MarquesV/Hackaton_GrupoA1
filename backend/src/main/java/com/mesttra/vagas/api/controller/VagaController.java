package com.mesttra.vagas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mesttra.vagas.domain.model.Vaga;
import com.mesttra.vagas.domain.service.ScrappingVaga;

@RestController
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	private ScrappingVaga scrappingVaga;

	// http://domain.com/vagas/parametro
	// http://domain.com/vagas?pesquisa=desenvolvedor

	@GetMapping
	public StringBuilder findVagas(@RequestParam String pesquisa) {
		List<Vaga> vagas = scrappingVaga.findVagas(pesquisa);
		
		/*
		StringBuilder str = new StringBuilder();
		str.append(String.valueOf(vagas));
		
		String vagaStr;
		for (Vaga vaga: vagas) {
			vagaStr += vaga.toString();
		}
		
		JSONObject jsonObject= new JSONObject(vagaStr);

		
		Gson gson = new Gson();
		String json = gson.toJson(vagas);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(json);
		*/

		return null;
	}

}
