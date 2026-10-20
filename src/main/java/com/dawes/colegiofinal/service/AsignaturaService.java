package com.dawes.colegiofinal.service;

import com.dawes.colegiofinal.DAO.impl.AsignaturaDAO;
import com.dawes.colegiofinal.DTO.AsignaturaDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaService {
   private final AsignaturaDAO asignaturaDAO;

   public AsignaturaService(AsignaturaDAO asignaturaDAO) {
       this.asignaturaDAO = asignaturaDAO;
   }
   public Optional<AsignaturaDTO> obtenerAsignaturaPorId(String id) {
       return asignaturaDAO.obtenerAsignaturaPorId(id);
   }
}
