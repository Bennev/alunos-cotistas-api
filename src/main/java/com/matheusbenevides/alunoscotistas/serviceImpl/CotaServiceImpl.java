package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.Cota;
import com.matheusbenevides.alunoscotistas.repository.CotaRepository;
import com.matheusbenevides.alunoscotistas.service.CotaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CotaServiceImpl implements CotaService {

    private final CotaRepository cotaRepository;

    @Override
    public List<Cota> buscarCotas() {
        return cotaRepository.findAll();
    }

}
