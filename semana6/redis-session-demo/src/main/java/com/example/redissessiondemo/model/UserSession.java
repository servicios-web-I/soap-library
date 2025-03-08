package com.example.redissessiondemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@RedisHash("UserSession") // Almacena en Redis como un Hash
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserSession implements Serializable {
    @Id
    private String id;
    private String username;
    private String token;

    @TimeToLive // Define la expiración en segundos
    private Long expiration;
}
