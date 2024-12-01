package com.planifai.service;

import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author marta
 */
public class NoteService {

    public void crearNota(String contenido, int idAula) {
        String sql = "INSERT INTO nota (contenido, id_aula) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contenido);
            pstmt.setInt(2, idAula);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al crear la nota: " + ex.getMessage());
            throw new RuntimeException("Error al crear la nota", ex);
        }
    }

    public String obtenerNotaPorAula(int idAula) {
        String sql = "SELECT contenido FROM nota WHERE id_aula = ?";
        String contenido = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                contenido = rs.getString("contenido");
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener la nota: " + ex.getMessage());
        }

        return contenido;
    }
}
