package com.example.demo.controller;

import com.example.demo.dto.EvaluacionDTO;
import com.example.demo.service.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    // Listar todas las evaluaciones de una lección
    @GetMapping("/leccion/{leccionId}")
    public ResponseEntity<List<EvaluacionDTO>> listarEvaluacionesPorLeccion(@PathVariable Long leccionId) {
        return ResponseEntity.ok(evaluacionService.listarEvaluacionesPorLeccion(leccionId));
    }

    // Crear una nueva evaluación
    @PostMapping("/leccion/{leccionId}")
    public ResponseEntity<EvaluacionDTO> crearEvaluacion(
            @PathVariable Long leccionId, 
            @RequestBody EvaluacionDTO evaluacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(evaluacionService.crearEvaluacion(leccionId, evaluacionDTO));
    }
}
