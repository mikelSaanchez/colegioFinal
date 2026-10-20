package com.dawes.colegiofinal.controlador;

import com.dawes.colegiofinal.DTO.AlumnoDTO;
import com.dawes.colegiofinal.service.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {
    private final AlumnoService alumnoService;

    public AlumnoControlador(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/listadoAlumnos")
    public String listadoAlumnos(Model model) {
        ArrayList<AlumnoDTO> listaAlumnos = alumnoService.buscarAlumnos("", "", false, true);
        model.addAttribute("listaAlumnos", listaAlumnos);
        return "alumnos/listado";
    }

    @PostMapping("/listadoAlumnos")
    public String buscarAlumnos(@RequestParam String nombre, @RequestParam String apellido, @RequestParam(required = false) Boolean familiaNumerosa, @RequestParam(required = false) Boolean activo, Model model) {
        // Un checkbox desmarcado no llega como parámetro
        boolean filtroFamiliaNumerosa = false;
        if (familiaNumerosa != null && familiaNumerosa) {
            filtroFamiliaNumerosa = true;
        }
        boolean filtroActivo = false;
        if (activo != null && activo) {
            filtroActivo = true;
        }
        ArrayList<AlumnoDTO> listaAlumnos = alumnoService.buscarAlumnos(nombre, apellido, filtroFamiliaNumerosa, filtroActivo);
        model.addAttribute("listaAlumnos", listaAlumnos);
        return "alumnos/listado";
    }

    @GetMapping("/insertarAlumno")
    public String mostrarFormularioAlta(Model model) {
        model.addAttribute("alumno", new AlumnoDTO());
        model.addAttribute("desplegableMunicipios", alumnoService.obtenerDesplegableMunicipios());
        return "alumnos/insertar";
    }

    @PostMapping("/insertarAlumno")
    public String insertarAlumno(@ModelAttribute("alumno") AlumnoDTO alumno, Model model) {
        int filasAfectadas = alumnoService.insertarAlumno(alumno);
        model.addAttribute("resultado", filasAfectadas == 1);
        model.addAttribute("alumno", new AlumnoDTO());
        model.addAttribute("desplegableMunicipios", alumnoService.obtenerDesplegableMunicipios());
        return "alumnos/insertar";
    }
}

