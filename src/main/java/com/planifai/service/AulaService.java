package com.planifai.service;

import com.planifai.model.Aula;
import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta
 */
public class AulaService {

    public void crearAula(String nombre, String asignatura) {
        // No especificamos id_aula porque se genera automáticamente
        String sql = "INSERT INTO Aulas (nombre, asignatura) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, asignatura);
            pstmt.executeUpdate();
            System.out.println("Aula guardada exitosamente.");

        } catch (SQLException ex) {
            System.out.println("Error al guardar el aula: " + ex.getMessage());
        }
    }

    public List<Aula> getAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT id_aula, nombre, asignatura FROM Aulas ORDER BY nombre";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_aula");
                String nombre = rs.getString("nombre");
                String asignatura = rs.getString("asignatura");

                aulas.add(new Aula(id, nombre, asignatura, null, null, null));
            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar aulas desde la base de datos: " + ex.getMessage());
        }
        return aulas;
    }

     public boolean actualizarAula(int idAula, String nuevoNombre, String nuevaAsignatura) {
        String sql = "UPDATE Aulas SET nombre = ?, asignatura = ? WHERE id_aula = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaAsignatura);
            pstmt.setInt(3, idAula);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // True si se actualizó al menos una fila
        } catch (SQLException e) {
            System.out.println("Error al actualizar el aula: " + e.getMessage());
            return false;
        }
    }
     
    public boolean eliminarAulaPorId(int idAula) {
        String sql = "DELETE FROM Aulas WHERE id_aula = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0; // True si se eliminó al menos una fila
        } catch (SQLException e) {
            System.out.println("Error al eliminar el aula: " + e.getMessage());
            return false;
        }
    }
    
        public Aula getAulaById(int idAula) {
        String sql = "SELECT id_aula, nombre, asignatura FROM Aulas WHERE id_aula = ?";
        Aula aula = null;

        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_aula");
                String nombre = rs.getString("nombre");
                String asignatura = rs.getString("asignatura");

                aula = new Aula(id, nombre, asignatura, null, null, null); // Ajusta el constructor según sea necesario
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el aula por ID: " + ex.getMessage());
        }

        return aula;
    }
}
