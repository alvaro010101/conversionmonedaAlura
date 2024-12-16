import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Tasa {
    private String json;
    private String operacionTasa;
    @SerializedName("conversion_rate")
    private double valorTasa;
    private String direccion = "https://v6.exchangerate-api.com/v6/45a02ac94e551bcd4fc35b76/pair/";



    public double getValorTasa() {
        return valorTasa;
    }

    public String getJson() {
        return json;
    }

    public void setOperacionTasa(String operacionTasa) {
        this.operacionTasa = operacionTasa;
    }

    public String getOperacionTasa() {
        return operacionTasa;
    }

    @Override
    public String toString() {
        return "Tasa{" +
                "valorTasa=" + valorTasa +
                '}';
    }

    public void tasaConsulta(){
        try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest resquest = HttpRequest.newBuilder()
                .uri(URI.create(direccion + operacionTasa)).build();
                HttpResponse<String> response;
                response = client.send(resquest, HttpResponse.BodyHandlers.ofString());

            json = response.body();}
            catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);}

    }



}
