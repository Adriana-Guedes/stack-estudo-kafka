package com.alves.paymentservice.model;


import lombok.Getter;

import java.io.Serializable;

@Getter //metodos getters
public class Payment implements Serializable {

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;

    }
