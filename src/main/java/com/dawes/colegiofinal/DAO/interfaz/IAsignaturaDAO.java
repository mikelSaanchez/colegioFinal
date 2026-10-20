package com.dawes.colegiofinal.DAO.interfaz;

import com.dawes.colegiofinal.DTO.AsignaturaDTO;

import java.util.Optional;

public interface IAsignaturaDAO {
    Optional<AsignaturaDTO> obtenerAsignaturaPorId(String id);
}
