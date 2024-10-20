package com.Conversor.Monedas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Comvertir {

    public double busquedaMoneda(String base_code, String target_code) {
        String keyPag = "aafe184a177a3bd02957e5fd"; //clave API
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+keyPag+"/latest/"+ base_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Map responseMap = new Gson().fromJson(response.body(), Map.class);

            Map<String, Double> conversionRates = (Map<String, Double>) responseMap.get("conversion_rates");

            // Regresa la tasa de cambio correspondiente a la moneda de destino
            return conversionRates.get(target_code);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de conversión", e); // Incluye la excepción original para más detalles
        }
    }
}
