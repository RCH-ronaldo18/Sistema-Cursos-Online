package com.example.demo.controller;

import com.example.demo.dto.ModuloDTO;
import com.example.demo.model.Modulo;
import com.example.demo.service.ModuloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/api/modulos")
@RequiredArgsConstructor
public class ModuloController {

    private final ModuloService moduloService;

    // Crear un módulo dentro de un curso
    @PostMapping("/curso/{cursoId}")
    public ResponseEntity<ModuloDTO> crearModulo(
            @PathVariable Long cursoId,
            @RequestBody ModuloDTO moduloDTO) {
        ModuloDTO nuevoModulo = moduloService.crearModuloEnCurso(cursoId, moduloDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoModulo);
    }

    // Listar módulos de un curso
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<ModuloDTO>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(moduloService.listarPorCurso(cursoId));
    }

    // Obtener un módulo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ModuloDTO> obtenerModulo(@PathVariable Long id) {
        return ResponseEntity.ok(moduloService.obtenerModulo(id));
    }
}
