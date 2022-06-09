package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.SituacaoMatricula;
import com.matheusbenevides.alunoscotistas.repository.SituacaoMatriculaRepository;
import com.matheusbenevides.alunoscotistas.service.SituacaoMatriculaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SituacaoMatriculaServiceImpl implements SituacaoMatriculaService {

    private final SituacaoMatriculaRepository situacaoMatriculaRepository;

    @Override
    public List<SituacaoMatricula> buscarSituacoesMatricula() {
        return situacaoMatriculaRepository.findAll();
    }

}
