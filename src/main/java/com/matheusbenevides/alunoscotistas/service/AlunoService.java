package com.matheusbenevides.alunoscotistas.service;

import com.matheusbenevides.alunoscotistas.entity.Aluno;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AlunoService {

    Aluno salvarAluno(Aluno aluno);

    List<Aluno> buscarAlunos(Aluno alunoFiltro);

    void importarDadosExcel(List<MultipartFile> multipartFiles);

}
