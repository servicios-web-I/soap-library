package com.example.gardeningstore.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OrderPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Long id;
    private Long customerId;
}
