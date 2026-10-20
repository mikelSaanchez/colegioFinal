package com.dawes.colegiofinal.DAO.impl;

import com.dawes.colegiofinal.DAO.interfaz.IAsignaturaDAO;
import com.dawes.colegiofinal.DTO.AsignaturaDTO;
import com.dawes.colegiofinal.repository.AsignaturaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AsignaturaDAO implements IAsignaturaDAO {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaDAO(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public Optional<AsignaturaDTO> obtenerAsignaturaPorId(String id) {
        return asignaturaRepository.buscarPorId(id);
    }
}
