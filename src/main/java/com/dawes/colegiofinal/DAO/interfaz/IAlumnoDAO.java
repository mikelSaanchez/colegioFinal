package com.dawes.colegiofinal.DAO.interfaz;

import com.dawes.colegiofinal.DTO.AlumnoDTO;

import java.util.ArrayList;

public interface IAlumnoDAO {
    ArrayList<AlumnoDTO> buscarAlumnos(String nombre, String apellido, boolean familiaNumerosa, boolean activo);
}
