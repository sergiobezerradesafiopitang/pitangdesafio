package com.pitang.desafio.Util;

import java.util.Base64;

public class Utils {

    /**
     * Method responsible for encode password
     * @param password
     * @return String
     */
    public static String encodePassword(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    /**
     * Method responsible for decode password
     * @param password
     * @return String
     */
    public static String decodePassword(String password){
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        return new String(decodedBytes);
    }
}
