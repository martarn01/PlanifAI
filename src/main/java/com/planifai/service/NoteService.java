package com.planifai.service;

import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servicio para gestionar las notas asociadas a las aulas.
 * Proporciona métodos para crear una nueva nota y obtener el contenido de una nota asociada a un aula.
 *
 * <p>Esta clase permite crear notas con contenido específico y asociarlas a un aula. También permite recuperar 
 * el contenido de las notas asociadas a un aula.</p>
 * 
 * @author Marta Rosado Nabais
 */
public class NoteService {

    /**
     * Crea una nueva nota en la base de datos y la asocia a un aula.
     *
     * @param contenido Contenido de la nota a crear.
     * @param idAula ID del aula a la que se asociará la nota.
     * @throws RuntimeException Si ocurre un error al intentar crear la nota en la base de datos.
     */
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

    /**
     * Obtiene el contenido de la nota asociada a un aula específico.
     *
     * @param idAula ID del aula cuya nota se desea obtener.
     * @return El contenido de la nota asociada al aula, o {@code null} si no existe una nota asociada.
     */
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
