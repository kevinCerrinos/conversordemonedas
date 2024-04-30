import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {

    Moneda requestData(String codMoneda){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/ce464b9e3a3139f9174c3026/latest/"+codMoneda);

        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return new Gson().fromJson(response.body(),Moneda.class);
    }
}
