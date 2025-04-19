package com.example.sha256demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String aplicarSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();

            /* for (int i = 0; i < hashBytes.length; i++) {
	            byte b = hashBytes[i];
	            sb.append(String.format("%02x", b));
        	}*/
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // convierte a hexadecimal
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo SHA-256 no disponible", e);
        }
    }
}
