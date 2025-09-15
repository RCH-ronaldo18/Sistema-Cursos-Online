package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialDTO {
    private Long id;
    private String tipo;   // aquí se maneja como String
    private String url;
    private String leccionTitulo;
}
