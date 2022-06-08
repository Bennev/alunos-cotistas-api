package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.Curso;
import com.matheusbenevides.alunoscotistas.repository.CursoRepository;
import com.matheusbenevides.alunoscotistas.service.CursoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService  {
    
    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

}
