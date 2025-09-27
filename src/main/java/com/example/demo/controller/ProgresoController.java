package com.example.demo.controller;

import com.example.demo.dto.ProgresoDTO;
import com.example.demo.service.ProgresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progreso")
public class ProgresoController {

    private final ProgresoService progresoService;

    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    // Consultar progreso de un estudiante en una lección
    @GetMapping("/usuario/{usuarioId}/leccion/{leccionId}")
    public ResponseEntity<ProgresoDTO> obtenerProgreso(
            @PathVariable Long usuarioId, 
            @PathVariable Long leccionId) {
        ProgresoDTO progreso = progresoService.obtenerProgreso(usuarioId, leccionId);
        return ResponseEntity.ok(progreso);
    }

    // Crear o Actualizar progreso de un estudiante en una lección
    @PutMapping("/usuario/{usuarioId}/leccion/{leccionId}")
    public ResponseEntity<ProgresoDTO> actualizarProgreso(
            @PathVariable Long usuarioId, 
            @PathVariable Long leccionId, 
            @RequestBody ProgresoDTO progresoDTO) {
        ProgresoDTO progresoActualizado = progresoService.actualizarProgreso(usuarioId, leccionId, progresoDTO);
        return ResponseEntity.ok(progresoActualizado);
    }
}
