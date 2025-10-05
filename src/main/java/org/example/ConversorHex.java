package org.example;

import java.util.Base64;

public class ConversorHex {

    public static void main(String[] args) {
        byte b = convertHexToByte("29");
        byte[] ar = {0x03, b};

        String base64Payload = new String(Base64.getEncoder().encode(ar));
        System.out.println(base64Payload);
    }
    private static byte convertHexToByte(String hex) {
        if (hex == null || hex.length() != 2) {
            throw new IllegalArgumentException("Invalid hex string: " + hex);
        }
        return (byte) Integer.parseInt(hex, 16);
    }
}
