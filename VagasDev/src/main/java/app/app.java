package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import domain.model.Vaga;

public class app {
	public static List<Vaga> vagas = new ArrayList<>();
    final static String PRIMARY_URL = "https://www.vagas.com.br/vagas-de-";

    public static void main(String[] args) {

        String vagaDesejada = "desenvolvedor";

        String url = String.format("%s%s", PRIMARY_URL, vagaDesejada);

        crawl(1,url, new ArrayList<String>());
    }
    private static void crawl(int level, String url, ArrayList<String> visited) {
        if(level<=5){

            Document doc = request(url, visited);
            String oddString = "vaga odd ";
            String evenString = "vaga even ";

            coletaDadosVaga(doc, oddString);
            coletaDadosVaga(doc, evenString);

            for (Vaga vaga :
                    vagas) {
                System.out.println(vaga.toString());
            }

        }
    }

    private static void coletaDadosVaga (Document doc, String tipoVaga) {

        for (Element link : doc.getElementsByClass(tipoVaga)) {
            String cargo = link.getElementsByClass("link-detalhes-vaga").text();
            String linkVaga = String.format("https://www.vagas.com.br%s", link.getElementsByClass("link-detalhes-vaga").attr("href"));
            String empresa = link.getElementsByClass("emprVaga").text();
            String nivelVaga = link.getElementsByClass("nivelVaga").text();
            String detalheVaga = link.getElementsByClass("detalhes").text();
            String localidade = link.getElementsByClass("vaga-local").text();
            String dataPublicacao = link.getElementsByClass("data-publicacao").text();

            vagas.add(new Vaga(cargo, linkVaga, empresa, nivelVaga, detalheVaga, localidade, dataPublicacao));

        }
    }

    private static Document request(String url, ArrayList<String> v){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusCode() == 200){
                v.add(url);

                return doc;
            }
            return null;

        } catch(IOException e){
            return null;
        }
    }

}



