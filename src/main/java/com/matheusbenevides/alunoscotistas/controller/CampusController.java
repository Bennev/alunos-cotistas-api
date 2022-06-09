package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.Campus;
import com.matheusbenevides.alunoscotistas.service.CampusService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campus")
@AllArgsConstructor
public class CampusController {

    private final CampusService campusService;

    private final static Logger logger = LoggerFactory.getLogger(CampusController.class);

    @GetMapping
    public List<Campus> getCampusList() {
        return campusService.buscarCampusList();
    }
}
