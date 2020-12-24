package com.lama.todo.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String userId;

    private String password;
}
