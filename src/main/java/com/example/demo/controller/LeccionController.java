package com.example.demo.controller;

import com.example.demo.dto.LeccionDTO;
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

    @PostMapping("/{moduloId}")
    public ResponseEntity<LeccionDTO> crearLeccion(@PathVariable Long moduloId,
                                                   @RequestBody Leccion leccion) {
        return ResponseEntity.ok(leccionService.crearLeccion(moduloId, leccion));
    }

    @GetMapping("/modulo/{moduloId}")
    public ResponseEntity<List<LeccionDTO>> listarPorModulo(@PathVariable Long moduloId) {
        return ResponseEntity.ok(leccionService.listarPorModulo(moduloId));
    }
}
