package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registro de usuario
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        if (usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
            return ResponseEntity.badRequest().body("⚠️ Usuario ya existe");
        }
        Usuario nuevo = usuarioRepository.save(usuario);
        return ResponseEntity.ok(nuevo);
    }

    // Login simple (sin JWT por ahora)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        return usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario())
                .map(u -> {
                    if (u.getPassword().equals(usuario.getPassword())) {
                        return ResponseEntity.ok("Login exitoso");
                    } else {
                        return ResponseEntity.badRequest().body("Contraseña incorrecta");
                    }
                })
                .orElse(ResponseEntity.badRequest().body("Usuario no encontrado"));
    }
}
