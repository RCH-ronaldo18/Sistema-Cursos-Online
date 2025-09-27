package com.example.demo.controller;

import com.example.demo.dto.ResultadoDTO;
import com.example.demo.service.ResultadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    // Registrar el resultado de un quiz
    @PostMapping("/evaluacion/{evaluacionId}")
    public ResponseEntity<ResultadoDTO> registrarResultado(
            @PathVariable Long evaluacionId, 
            @RequestBody ResultadoDTO resultadoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(resultadoService.registrarResultado(evaluacionId, resultadoDTO));
    }

    // Consultar los resultados de un usuario en una evaluación
    @GetMapping("/usuario/{usuarioId}/evaluacion/{evaluacionId}")
    public ResponseEntity<ResultadoDTO> obtenerResultado(
            @PathVariable Long usuarioId, 
            @PathVariable Long evaluacionId) {
        return ResponseEntity.ok(resultadoService.obtenerResultado(usuarioId, evaluacionId));
    }
}
