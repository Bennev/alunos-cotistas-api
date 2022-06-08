package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.Cota;
import com.matheusbenevides.alunoscotistas.service.CotaService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cota")
@AllArgsConstructor
public class CotaController {

    private final CotaService cotaService;

    private final static Logger logger = LoggerFactory.getLogger(CotaController.class);

    @GetMapping
    public List<Cota> getCotas() {
        return cotaService.buscarCotas();
    }
}
