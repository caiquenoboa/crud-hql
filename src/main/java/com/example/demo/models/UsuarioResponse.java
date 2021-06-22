package com.example.demo.models;

public class UsuarioResponse {
    private Long id;
    private String userName;

    public UsuarioResponse() {
    }

    public UsuarioResponse(UsuarioModel usuarioModel) {
        this.id = usuarioModel.getId();
        this.userName = usuarioModel.getUserName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
