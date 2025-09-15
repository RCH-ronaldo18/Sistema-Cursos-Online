package com.example.demo.mapper;

import com.example.demo.dto.MaterialDTO;
import com.example.demo.model.Material;

public class MaterialMapper {
    public static MaterialDTO toDTO(Material material) {
        return MaterialDTO.builder()
                .id(material.getId())
                .tipo(material.getTipo().name()) // pasamos enum -> String
                .url(material.getUrl())
                .leccionTitulo(material.getLeccion().getTitulo())
                .build();
    }
}
