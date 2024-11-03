package com.planifai.service;

import com.planifai.model.Evento;
import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta
 */
public class EventoService {

    // Método para crear un evento
    public void crearEvento(String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula) {
        String sql = "INSERT INTO Eventos (descripcion, fecha_evento, tipo_evento, id_aula) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setTimestamp(2, fechaEvento);
            pstmt.setString(3, tipoEvento);
            pstmt.setInt(4, idAula);
            pstmt.executeUpdate();
            System.out.println("Evento guardado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar el evento: " + ex.getMessage());
        }
    }

    // Método para obtener todos los eventos
    public List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT id_evento, descripcion, fecha_evento, tipo_evento, id_aula FROM Eventos";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idEvento = rs.getInt("id_evento");
                String descripcion = rs.getString("descripcion");
                Timestamp fechaEvento = rs.getTimestamp("fecha_evento");
                String tipoEvento = rs.getString("tipo_evento");
                int idAula = rs.getInt("id_aula");

                eventos.add(new Evento(idEvento, descripcion, fechaEvento, tipoEvento, idAula, null, null, null));
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar eventos desde la base de datos: " + ex.getMessage());
        }
        return eventos;
    }

    // Método para eliminar un evento por ID
    public boolean eliminarEventoPorId(int idEvento) {
        String sql = "DELETE FROM Eventos WHERE id_evento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEvento);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // True si se eliminó al menos una fila
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
            return false;
        }
    }
}