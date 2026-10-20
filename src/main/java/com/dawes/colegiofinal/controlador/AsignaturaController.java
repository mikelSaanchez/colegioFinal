package com.dawes.colegiofinal.controlador;

import com.dawes.colegiofinal.DTO.AsignaturaDTO;
import com.dawes.colegiofinal.service.AsignaturaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class AsignaturaController {
    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }
    @RequestMapping("/asignatura/{id}")
    public String obtenerAsignaturaPorId(@PathVariable String id, Model model) {
        Optional<AsignaturaDTO> asignatura = asignaturaService.obtenerAsignaturaPorId(id);
        if (asignatura.isPresent()) {
            model.addAttribute("asignatura", asignatura.get());
            return "asignatura";
        } else {
            return "asignatura-no-encontrada";
        }
    }
}
