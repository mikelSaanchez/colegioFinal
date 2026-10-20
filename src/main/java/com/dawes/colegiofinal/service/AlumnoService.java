package com.dawes.colegiofinal.service;

import com.dawes.colegiofinal.DAO.interfaz.IAlumnoDAO;
import com.dawes.colegiofinal.DAO.interfaz.IMunicipioDAO;
import com.dawes.colegiofinal.DTO.AlumnoDTO;
import com.dawes.colegiofinal.DTO.DesplegableDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoService {
    private final IAlumnoDAO alumnoDAO;
    private final IMunicipioDAO municipioDAO;

    public AlumnoService(IAlumnoDAO alumnoDAO, IMunicipioDAO municipioDAO) {
        this.alumnoDAO = alumnoDAO;
        this.municipioDAO = municipioDAO;
    }

    public ArrayList<AlumnoDTO> buscarAlumnos(String nombre, String apellido, boolean familiaNumerosa, boolean activo) {
        return alumnoDAO.buscarAlumnos(nombre, apellido, familiaNumerosa, activo);
    }

    public int insertarAlumno(AlumnoDTO alumno) {
        return alumnoDAO.insertarAlumno(alumno);
    }

    public ArrayList<DesplegableDTO> obtenerDesplegableMunicipios() {
        return municipioDAO.listarParaDesplegable();
    }
}
