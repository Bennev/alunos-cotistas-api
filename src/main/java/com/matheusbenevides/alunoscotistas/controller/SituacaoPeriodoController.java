package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.SituacaoPeriodo;
import com.matheusbenevides.alunoscotistas.service.SituacaoPeriodoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/situacaoperiodo")
@AllArgsConstructor
public class SituacaoPeriodoController {

    private final SituacaoPeriodoService situacaoperiodoService;

    private final static Logger logger = LoggerFactory.getLogger(SituacaoPeriodoController.class);

    @GetMapping
    public List<SituacaoPeriodo> getSituacaoPeriodos() {
        return situacaoperiodoService.buscarSituacoes_periodo();
    }      
}
