package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.Curso;
import com.matheusbenevides.alunoscotistas.service.CursoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    private final static Logger logger = LoggerFactory.getLogger(CursoController.class);

    @GetMapping
    public List<Curso> getCursos() {
        return cursoService.buscarCursos();
    }  
}
