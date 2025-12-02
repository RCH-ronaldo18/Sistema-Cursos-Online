package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistroPublicoRequest {
    private String nombreUsuario;
    private String password;
}
