package com.example.demo.service;

import com.example.demo.model.Leccion;
import com.example.demo.repository.LeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeccionService {

    private final LeccionRepository leccionRepository;

    public Leccion crearLeccion(Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    public List<Leccion> listarPorModulo(Long moduloId) {
        return leccionRepository.findByModuloId(moduloId);
    }

    public Leccion actualizarLeccion(Long id, Leccion leccionActualizada) {
        return leccionRepository.findById(id)
                .map(leccion -> {
                    leccion.setTitulo(leccionActualizada.getTitulo());
                    leccion.setContenido(leccionActualizada.getContenido());
                    return leccionRepository.save(leccion);
                })
                .orElseThrow(() -> new RuntimeException("Lección no encontrada"));
    }

    public void eliminarLeccion(Long id) {
        leccionRepository.deleteById(id);
    }
}
