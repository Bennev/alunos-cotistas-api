package com.mateusbenevides.alunoscotistas.controller;

import com.mateusbenevides.alunoscotistas.entity.Cota;
import com.mateusbenevides.alunoscotistas.service.CotaService;
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
