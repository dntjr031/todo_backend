package com.lama.todo.account.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String token;

    public LoginResponse(String token) {
        this.token = token;
    }
}
