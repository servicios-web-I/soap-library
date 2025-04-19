package com.example.cryptodemo.controller;

import com.example.cryptodemo.dto.CryptoRequest;
import com.example.cryptodemo.util.AESUtil;
import com.example.cryptodemo.util.RSAUtil;
import org.springframework.web.bind.annotation.*;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    private KeyPair rsaKeys;

    public CryptoController() throws Exception {
        rsaKeys = RSAUtil.generateKeyPair();
    }

    @PostMapping("/aes/encrypt")
    public String encryptAES(@RequestBody CryptoRequest req) throws Exception {
        return AESUtil.encrypt(req.getMessage());
    }

    @PostMapping("/aes/decrypt")
    public String decryptAES(@RequestBody CryptoRequest req) throws Exception {
        return AESUtil.decrypt(req.getEncrypted());
    }

    @GetMapping("/rsa/keys")
    public Map<String, String> getRSAKeys() {
        return Map.of(
                "publicKey", Base64.getEncoder().encodeToString(rsaKeys.getPublic().getEncoded()),
                "privateKey", Base64.getEncoder().encodeToString(rsaKeys.getPrivate().getEncoded())
        );
    }

    @PostMapping("/rsa/encrypt")
    public String encryptRSA(@RequestBody CryptoRequest req) throws Exception {
        byte[] pubBytes = Base64.getDecoder().decode(req.getPublicKey());
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(pubBytes));
        return RSAUtil.encrypt(req.getMessage(), pubKey);
    }

    @PostMapping("/rsa/decrypt")
    public String decryptRSA(@RequestBody CryptoRequest req) throws Exception {
        byte[] privBytes = Base64.getDecoder().decode(req.getPrivateKey());
        PrivateKey privKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privBytes));
        return RSAUtil.decrypt(req.getEncrypted(), privKey);
    }
}
