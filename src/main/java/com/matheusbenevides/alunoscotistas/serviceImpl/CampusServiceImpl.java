package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.Campus;
import com.matheusbenevides.alunoscotistas.repository.CampusRepository;
import com.matheusbenevides.alunoscotistas.service.CampusService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampusServiceImpl implements CampusService {

    private final CampusRepository campusRepository;

    @Override
    public List<Campus> buscarCampusList() {
        return campusRepository.findAll();
    }

}
