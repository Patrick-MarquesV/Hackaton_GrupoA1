package app;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class app {

    public static void main(String[] args) {
        String primaryUrl = "https://www.vagas.com.br/vagas-de-";

        String vagaDesejada = "desenvolvedor";

        String url = String.format("%s%s", primaryUrl, vagaDesejada);

        crawl(1,url, new ArrayList<String>());
    }
    private static void crawl(int level, String url, ArrayList<String> visited) {
        if(level<=5){

            Document doc = request(url, visited);
            String oddString = "vaga odd ";
            String evenString = "vaga even ";
            int contador = 0;

            coletaDadosVaga(doc, oddString, contador);
            coletaDadosVaga(doc, evenString, contador);

//                    System.out.println(next_link);
//
//                    if(visited.contains(next_link)== false){
//                        crawl(level++, url, visited);
//                    }
        }
    }

    private static void coletaDadosVaga (Document doc, String tipoVaga, int contador) {

        for (Element link : doc.getElementsByClass(tipoVaga)) {
            String cargo = link.getElementsByClass("link-detalhes-vaga").text();
            String linkVaga = String.format("https://www.vagas.com.br%s", link.getElementsByClass("link-detalhes-vaga").attr("href"));
            String empresa = link.getElementsByClass("emprVaga").text();
            String nivelVaga = link.getElementsByClass("nivelVaga").text();
            String detalheVaga = link.getElementsByClass("detalhes").text();
            String localidade = link.getElementsByClass("vaga-local").text();
            String dataPublicacao = link.getElementsByClass("data-publicacao").text();


            System.out.println(cargo);
            System.out.println(linkVaga);
            System.out.println(empresa);
            System.out.println(nivelVaga);
            System.out.println(detalheVaga);
            System.out.println(localidade);
            System.out.println(dataPublicacao);

            contador++;

        }
    }

    private static Document request(String url, ArrayList<String> v){
        try{
            Connection con = Jsoup.connect(url);
            Document doc = con.get();

            if(con.response().statusCode() == 200){
//                System.out.println("Link: " + url );
//                System.out.println(doc.title());
                v.add(url);

                return doc;
            }
            return null;

        } catch(IOException e){
            return null;
        }
    }

}



