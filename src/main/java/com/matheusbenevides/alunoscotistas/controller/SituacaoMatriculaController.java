package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.SituacaoMatricula;
import com.matheusbenevides.alunoscotistas.service.SituacaoMatriculaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/situacaomatricula")
@AllArgsConstructor
public class SituacaoMatriculaController {

    private final SituacaoMatriculaService situacaomatriculaService;

    private final static Logger logger = LoggerFactory.getLogger(SituacaoMatriculaController.class);

    @GetMapping
    public List<SituacaoMatricula> getSituacaoMatriculas() {
        return situacaomatriculaService.buscarSituacaoMatriculas();
    }    
}
