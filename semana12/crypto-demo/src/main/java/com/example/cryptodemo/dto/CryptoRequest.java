package com.example.cryptodemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CryptoRequest {
    private String message;
    private String encrypted;
    private String publicKey;
    private String privateKey;
}
