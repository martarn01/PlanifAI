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
 * Clase de servicio para manejar las operaciones de eventos en el sistema.
 * Proporciona métodos para crear, obtener, actualizar y eliminar eventos en la
 * base de datos.
 *
 * @author Marta Rosado Nabais
 */
public class EventoService { 

    /**
     * Crea un nuevo evento en la base de datos.
     *
     * @param descripcion Descripción del evento.
     * @param fechaEvento Fecha y hora del evento.
     * @param tipoEvento Tipo del evento.
     * @param idAula ID del aula asociada al evento.
     */
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

    /**
     * Obtiene todos los eventos de la base de datos, ordenados por fecha.
     *
     * @return Lista de objetos Evento.
     */
    public List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT id_evento, descripcion, fecha_evento, tipo_evento, id_aula FROM Eventos ORDER BY fecha_evento";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id_evento");
                String descripcion = rs.getString("descripcion");
                Timestamp fecha = rs.getTimestamp("fecha_evento");
                String tipo = rs.getString("tipo_evento");
                int idAula = rs.getInt("id_aula");

                // Se eliminó idDocumento
                eventos.add(new Evento(id, descripcion, fecha, tipo, idAula, null, null, null)); // Ajustar según tus necesidades
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar eventos desde la base de datos: " + ex.getMessage());
        }
        return eventos;
    }

    /**
     * Actualiza un evento existente en la base de datos.
     *
     * @param idEvento ID del evento a actualizar.
     * @param nuevaDescripcion Nueva descripción del evento.
     * @param nuevaFechaEvento Nueva fecha y hora del evento.
     * @param nuevoTipoEvento Nuevo tipo del evento.
     * @param idAula Nuevo ID del aula asociada al evento.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarEvento(int idEvento, String nuevaDescripcion, Timestamp nuevaFechaEvento, String nuevoTipoEvento, int idAula) {
        String sql = "UPDATE Eventos SET descripcion = ?, fecha_evento = ?, tipo_evento = ?, id_aula = ? WHERE id_evento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevaDescripcion);
            pstmt.setTimestamp(2, nuevaFechaEvento);
            pstmt.setString(3, nuevoTipoEvento);
            pstmt.setInt(4, idAula);
            pstmt.setInt(5, idEvento);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el evento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un evento de la base de datos por su ID.
     *
     * @param idEvento ID del evento a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarEventoPorId(int idEvento) {
        String sql = "DELETE FROM Eventos WHERE id_evento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEvento);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene un evento de la base de datos por su ID.
     *
     * @param idEvento ID del evento a obtener.
     * @return Objeto Evento correspondiente al ID, o null si no se encuentra.
     */
    public Evento getEventoById(int idEvento) {
        String sql = "SELECT id_evento, descripcion, fecha_evento, tipo_evento, id_aula FROM Eventos WHERE id_evento = ?";
        Evento evento = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEvento);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_evento");
                String descripcion = rs.getString("descripcion");
                Timestamp fecha = rs.getTimestamp("fecha_evento");
                String tipo = rs.getString("tipo_evento");
                int idAula = rs.getInt("id_aula");

                // Se eliminó idDocumento
                evento = new Evento(id, descripcion, fecha, tipo, idAula, null, null, null); // Ajustar según tus necesidades
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el evento por ID: " + ex.getMessage());
        }

        return evento;
    }
}
