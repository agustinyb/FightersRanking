package com.sherdog.FightersRanking;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ChatGPTClient {

                public String preguntar(String pregunta) {

                        String respuesta= "";
                        try {

                                // Configura el modelo y el punto de acceso de la API
                                String model = "gpt-3.5-turbo";
                                URL url = new URL("https://api.openai.com/v1/chat/completions");
//establecer los encabezados de la solicitud
                                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                                conn.setRequestMethod("POST");

                                conn.setRequestProperty("Content-Type", "application/json");
                                conn.setRequestProperty("Authorization", "Bearer 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");

                                conn.setDoOutput(true);
                                DataOutputStream os = new DataOutputStream(conn.getOutputStream()) ;

                                // Configura la solicitud de API
                                int maxTokens=200;
                                String json = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"system\",\"content\":\"" + pregunta + "\"}," +
                                        "{\"role\":\"user\",\"content\":\"necesito que me devuelvas solamente el formato json de un peleador" +
                                        " real con los siguientes atributos, name, lastname, nickname, age, height, yearsOfExperience, fights, championships, record, weight\"}]," +
                                        "\"max_tokens\":" + maxTokens + "}";


                                os.writeBytes(json);
                                os.flush();
                                os.close();

                                // Realiza la llamada a la API
                                int responseCode = conn.getResponseCode();
                                BufferedReader inputReader;
                                if(responseCode == HttpURLConnection.HTTP_OK){
                                        inputReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                } else{
                                        inputReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                                }

                                String inputLine;
                                StringBuilder response = new StringBuilder();

                                while ((inputLine = inputReader.readLine()) != null) {
                                        response.append(inputLine);
                                }
                                inputReader.close();

                                System.out.println(response.toString());
                                respuesta = response.toString();
                                // Aquí puedes manejar la respuesta del modelo según tus necesidades

                               // conn.disconnect();
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                return respuesta;
                }
        }


