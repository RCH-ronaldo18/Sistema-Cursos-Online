package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.model.Modulo;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.ModuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuloService {

    private final ModuloRepository moduloRepository;
    private final CursoRepository cursoRepository;

    // Crear módulo en un curso
    public Modulo crearModulo(Long cursoId, Modulo modulo) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id " + cursoId));

        modulo.setCurso(curso);
        return moduloRepository.save(modulo);
    }

    // Listar módulos de un curso
    public List<Modulo> listarPorCurso(Long cursoId) {
        return moduloRepository.findByCursoId(cursoId);
    }

    // Actualizar módulo
    public Modulo actualizarModulo(Long id, Modulo datos) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado con id " + id));

        modulo.setTitulo(datos.getTitulo());
        modulo.setDescripcion(datos.getDescripcion());

        return moduloRepository.save(modulo);
    }

    // Eliminar módulo
    public void eliminarModulo(Long id) {
        moduloRepository.deleteById(id);
    }
}
