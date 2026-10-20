package com.dawes.colegiofinal.DAO.impl;

import com.dawes.colegiofinal.DAO.interfaz.IMunicipioDAO;
import com.dawes.colegiofinal.DTO.DesplegableDTO;
import com.dawes.colegiofinal.repository.MunicipioRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MunicipioDAO implements IMunicipioDAO {
    private final MunicipioRepository municipioRepository;
    public MunicipioDAO(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }
    @Override
    public ArrayList<DesplegableDTO> listarParaDesplegable() {
        return municipioRepository.listarParaDesplegable();
    }
}
