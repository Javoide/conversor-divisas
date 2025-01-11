import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    private static final String API_KEY = "44017df7da5db0cacfd5f28a";

    public Divisas consultaDivisa(String nombreDivisa) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + nombreDivisa);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la API: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), Divisas.class);
        } catch (Exception e) {
            throw new RuntimeException(" No se pudo procesar la solicitud. Verifica la divisa y tu conexión.");
        }
    }
}
