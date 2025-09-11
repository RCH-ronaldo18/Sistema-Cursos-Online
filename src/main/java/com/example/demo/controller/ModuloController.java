package com.example.demo.controller;

import com.example.demo.model.Modulo;
import com.example.demo.service.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
@RequiredArgsConstructor
public class ModuloController {

    private final ModuloService moduloService;

    // Crear módulo dentro de un curso
    @PostMapping("/curso/{cursoId}")
    public ResponseEntity<Modulo> crearModulo(@PathVariable Long cursoId, @RequestBody Modulo modulo) {
        return ResponseEntity.ok(moduloService.crearModulo(cursoId, modulo));
    }

    // Listar módulos de un curso
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Modulo>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(moduloService.listarPorCurso(cursoId));
    }

    // Actualizar módulo
    @PutMapping("/{id}")
    public ResponseEntity<Modulo> actualizarModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        return ResponseEntity.ok(moduloService.actualizarModulo(id, modulo));
    }

    // Eliminar módulo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModulo(@PathVariable Long id) {
        moduloService.eliminarModulo(id);
        return ResponseEntity.noContent().build();
    }
}
