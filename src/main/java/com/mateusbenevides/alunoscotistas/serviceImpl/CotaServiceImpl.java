package com.mateusbenevides.alunoscotistas.serviceImpl;

import com.mateusbenevides.alunoscotistas.entity.Cota;
import com.mateusbenevides.alunoscotistas.repository.CotaRepository;
import com.mateusbenevides.alunoscotistas.service.CotaService;
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
