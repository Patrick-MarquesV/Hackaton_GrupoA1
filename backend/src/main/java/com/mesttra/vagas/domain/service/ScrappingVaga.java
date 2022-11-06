package com.mesttra.vagas.domain.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.mesttra.vagas.domain.model.Vaga;

@Service
public class ScrappingVaga {

	private static final String PRIMARY_URL = "https://www.vagas.com.br/vagas-de-";

	private static List<Vaga> vagas = new ArrayList<>();

	public List<Vaga> findVagas(String vagaTarget) {
		
		vagas.clear();

		String vagaDesejada = vagaTarget;

		String url = String.format("%s%s", PRIMARY_URL, vagaDesejada);

		managerScrapping(1, url, new ArrayList<String>());

		return vagas;

	}

	private static void managerScrapping(int level, String url, ArrayList<String> visited) {

		if (level <= 5) {

			Document doc = request(url, visited);
			String oddString = "vaga odd ";
			String evenString = "vaga even ";

			scrapping(doc, oddString);
			scrapping(doc, evenString);

		}

	}

	private static void scrapping(Document doc, String tipoVaga) {

		for (Element link : doc.getElementsByClass(tipoVaga)) {

			String cargo = link.getElementsByClass("link-detalhes-vaga").text();
			String linkVaga = String.format("https://www.vagas.com.br%s",
					link.getElementsByClass("link-detalhes-vaga").attr("href"));
			String empresa = link.getElementsByClass("emprVaga").text();
			String nivelVaga = link.getElementsByClass("nivelVaga").text();
			String detalheVaga = link.getElementsByClass("detalhes").text();
			String localidade = link.getElementsByClass("vaga-local").text();
			String dataPublicacao = link.getElementsByClass("data-publicacao").text();

			vagas.add(new Vaga(cargo, linkVaga, empresa, nivelVaga, detalheVaga, localidade, dataPublicacao));

		}

	}

	private static Document request(String url, ArrayList<String> v) {

		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();

			if (con.response().statusCode() == 200) {
				v.add(url);

				return doc;
			}
			return null;

		} catch (IOException e) {
			return null;
		}

	}

}
