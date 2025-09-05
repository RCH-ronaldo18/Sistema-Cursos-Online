package com.example.demo.controller;

import com.example.demo.dto.UsuarioRequest;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Endpoint: registrar usuario
   @PostMapping("/registrar")
public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRequest request) {
    Usuario usuario = usuarioService.registrarUsuario(
            request.getNombreUsuario(),
            request.getPassword(),
            request.getRol()
    );
    return ResponseEntity.ok(usuario);
}

    // Endpoint: listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    // Endpoint: buscar usuario por nombre
    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<Usuario> buscarPorNombre(@PathVariable String nombreUsuario) {
        return ResponseEntity.ok(usuarioService.buscarPorNombre(nombreUsuario));
    }
}
