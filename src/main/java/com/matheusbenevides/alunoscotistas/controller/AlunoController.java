package com.matheusbenevides.alunoscotistas.controller;

import com.matheusbenevides.alunoscotistas.entity.Aluno;
import com.matheusbenevides.alunoscotistas.enums.Campus;
import com.matheusbenevides.alunoscotistas.enums.Nivel;
import com.matheusbenevides.alunoscotistas.service.AlunoService;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    private final static Logger logger = LoggerFactory.getLogger(AlunoController.class);

    @GetMapping
    public List<Aluno> getAlunos(Aluno filtro) {
        return alunoService.buscarAlunos(filtro);
    }

    @PostMapping
    public Aluno saveAluno(@RequestBody Aluno aluno) {
        try {
            return alunoService.salvarAluno(aluno);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }

    @GetMapping("/campus")
    public List<Campus> getCampus() {
        return Arrays.asList(Campus.values());
    }

    @GetMapping("/nivel")
    public List<Nivel> getNiveis() {
        return Arrays.asList(Nivel.values());
    }

    @PostMapping("/importDb")
    public void importExcelToDb(@RequestPart(required = true) List<MultipartFile> files) {
        try {
            alunoService.importarDadosExcel(files);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }
}
