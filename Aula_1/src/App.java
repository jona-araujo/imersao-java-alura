import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(req, BodyHandlers.ofString());
        String body = response.body();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> lista = parser.parse(body);
        System.out.println(lista.size());

        for (Map<String,String> filme : lista) {
            System.out.println(filme.get("rank") + " - " + filme.get("fullTitle"));
            System.out.println(filme.get("imDbRating")+ "-"+stars((filme.get("imDbRating")))+"\n");
            
        }
        
    }
    
    public static String stars(String notaString){
        int nota = (int) Math.abs(Double.parseDouble(notaString));
        String saida = "";
        char STAR_CH = '*';

        for(int i = 0; i < nota; i++){
            saida += STAR_CH;
        }
        
        return saida;
    }
}
