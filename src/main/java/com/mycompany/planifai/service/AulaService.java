package com.mycompany.planifai.service;

import com.mycompany.planifai.model.Aula;
import com.mycompany.planifai.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaService {

    // Método para crear una nueva aula
    public void crearAula(Aula aula) {
        String sql = "INSERT INTO Aulas (nombre, asignatura) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, aula.getNombre());
            pstmt.setString(2, aula.getAsignatura());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las aulas
    public List<Aula> obtenerAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT * FROM Aulas";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Aula aula = new Aula();
                aula.setIdAula(rs.getInt("id_aula"));
                aula.setNombre(rs.getString("nombre"));
                aula.setAsignatura(rs.getString("asignatura"));
                aulas.add(aula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aulas;
    }

    // Método para actualizar un aula
    public void actualizarAula(Aula aula) {
        String sql = "UPDATE Aulas SET nombre = ?, asignatura = ? WHERE id_aula = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, aula.getNombre());
            pstmt.setString(2, aula.getAsignatura());
            pstmt.setInt(3, aula.getIdAula());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un aula
    public void eliminarAula(int idAula) {
        String sql = "DELETE FROM Aulas WHERE id_aula = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un aula por ID
    public Aula obtenerAulaPorId(int idAula) {
        Aula aula = null;
        String sql = "SELECT * FROM Aulas WHERE id_aula = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                aula = new Aula();
                aula.setIdAula(rs.getInt("id_aula"));
                aula.setNombre(rs.getString("nombre"));
                aula.setAsignatura(rs.getString("asignatura"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aula;
    }
}
