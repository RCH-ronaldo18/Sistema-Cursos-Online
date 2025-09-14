package com.example.demo.controller;

import com.example.demo.model.Leccion;
import com.example.demo.service.LeccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecciones")
@RequiredArgsConstructor
public class LeccionController {

    private final LeccionService leccionService;

    @PostMapping
    public ResponseEntity<Leccion> crearLeccion(@RequestBody Leccion leccion) {
        return ResponseEntity.ok(leccionService.crearLeccion(leccion));
    }

    @GetMapping("/modulo/{idModulo}")
    public ResponseEntity<List<Leccion>> listarPorModulo(@PathVariable Long idModulo) {
        return ResponseEntity.ok(leccionService.listarPorModulo(idModulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leccion> actualizarLeccion(
            @PathVariable Long id,
            @RequestBody Leccion leccion) {
        return ResponseEntity.ok(leccionService.actualizarLeccion(id, leccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLeccion(@PathVariable Long id) {
        leccionService.eliminarLeccion(id);
        return ResponseEntity.noContent().build();
    }
}
