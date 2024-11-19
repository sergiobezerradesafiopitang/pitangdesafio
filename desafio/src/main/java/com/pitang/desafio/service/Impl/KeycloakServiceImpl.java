package com.pitang.desafio.service.Impl;

import com.google.gson.Gson;
import com.pitang.desafio.constants.Constantes;
import com.pitang.desafio.security.keycloak.KeycloakToken;
import com.pitang.desafio.model.Usuario;
import com.pitang.desafio.service.IKeykloakService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

@Service
public class KeycloakServiceImpl implements IKeykloakService {

    @Value("${spring.security.oauth2.client.grant-type}")
    private String grantType;
    @Value("${spring.security.oauth2.client.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.access-token-uri}")
    private String accessTokenUri;

    private Gson gson = new Gson();

    /**
     * Method responsible for get Bearer Token from Keykloak
     * @param usuario
     * @return String
     */
    @Override
    public String getTokenFromHttpRequest(Usuario usuario) throws ServiceUnavailableException {

        var urlParameters = format("%s=%s&%s=%s&%s=%s&%s=%s", Constantes.GRANT_TYPE, this.grantType, Constantes.CLIENT_ID, this.clientId,
                Constantes.USERNAME, usuario.getFirstName(), Constantes.PASSWORD, usuario.getPassword());
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(this.accessTokenUri))
                    .POST(HttpRequest.BodyPublishers.ofString(urlParameters))
                    .headers(Constantes.CONTENT_TYPE, Constantes.CONTENT_TYPE_VALUE)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            var token = gson.fromJson(response.body(), KeycloakToken.class);

            return format("%s%s", Constantes.BEARER, token.getAccess_token());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ServiceUnavailableException();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new ServiceUnavailableException();
        }

    }

}
