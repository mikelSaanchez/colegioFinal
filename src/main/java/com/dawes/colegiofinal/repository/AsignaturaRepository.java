package com.dawes.colegiofinal.repository;

import com.dawes.colegiofinal.DTO.AsignaturaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class AsignaturaRepository {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoRepository.class);
    private final DataSource dataSource;

    public AsignaturaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<AsignaturaDTO> buscarPorId(String id) {
        String sql = "SELECT id, nombre, curso, tasa,activo FROM asignaturas WHERE id = ?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AsignaturaDTO asignatura = new AsignaturaDTO(rs.getString("id"), rs.getString("nombre"), rs.getString("curso"), rs.getDouble("tasa"), rs.getInt("activo"));
                return Optional.of(asignatura);
            }
            connection.close();
        } catch (SQLException e) {
            logger.error("Error al buscar la asignatura con id {}", id, e);
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return Optional.empty();
    }

}
