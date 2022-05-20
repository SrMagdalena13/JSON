import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjemploParse {
    public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {

        // creamos la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();

        // creamos el cliente
        HttpClient client = HttpClient.newHttpClient();

        // Enviamos la petición y obtenemos la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Mostramos el cuerpo de la respuesta
        System.out.println(response.body());

        // Añado Tratamiento de error de protocolo HTTP posibles
        int code = response.statusCode();
        System.out.println("Response code is :" + code);
        switch (code){
            case 200:
                System.out.println("Response is OK");
                parseBody(response.body());
                break;
            case 404:
                System.out.println("ERROR, NOT FOUND");
                break;
            case 403:
                System.out.println("ERROR, FORBIDDEN");
                break;
            case 500:
                System.out.println("ERROR, INTERNAL SERVER ERROR");
                break;
            case 502:
                System.out.println("ERROR, BAD GATEWAY");
                break;
        }

        /*String cadenaJSON = "";
        JSONObject obj = new JSONObject(cadenaJSON);
        String vivo = obj.getJSONObject("pageInfo").getString("pageName");
        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
        System.out.println(vivo);*/
    }
    // Método que parsea el cuerpo del URI y devuelve la información que se le pide
    private static void parseBody(String body) {
        String cadenaJSON = body;
        JSONObject obj = new JSONObject(cadenaJSON);
        String titulo = obj.getString("title ");
        System.out.println(titulo);
        /*String vivo = obj.getJSONObject("pageInfo").getString("pageName");*/
        /*JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
        System.out.println(vivo);*/
    }
}