package com.cabidiomas.cadastro.exception;

public class UsuariocadastradoException extends RuntimeException {
    public UsuariocadastradoException(String login){
        super("Usuário já cadastrado para o login " + login);
    }
}
