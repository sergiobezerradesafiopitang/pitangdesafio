package com.pitang.desafio.service;

import com.pitang.desafio.model.Usuario;

import javax.naming.ServiceUnavailableException;

public interface IKeykloakService {

    /**
     * Method responsible for get Bearer Token from Keykloak
     * @param usuario
     * @return String
     */
    String getTokenFromHttpRequest(Usuario usuario) throws ServiceUnavailableException;

}
