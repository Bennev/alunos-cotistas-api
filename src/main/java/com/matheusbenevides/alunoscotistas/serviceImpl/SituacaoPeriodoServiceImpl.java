package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.SituacaoPeriodo;
import com.matheusbenevides.alunoscotistas.repository.SituacaoPeriodoRepository;
import com.matheusbenevides.alunoscotistas.service.SituacaoPeriodoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SituacaoPeriodoServiceImpl implements SituacaoPeriodoService {

    private final SituacaoPeriodoRepository situacaoPeriodoRepository;

    @Override
    public List<SituacaoPeriodo> buscarSituacoesPeriodo() {
        return situacaoPeriodoRepository.findAll();
    }

}
