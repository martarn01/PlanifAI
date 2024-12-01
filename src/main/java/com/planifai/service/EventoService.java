package com.planifai.service;

import com.planifai.model.Documento;
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

    private DocumentoService documentoService;

    public EventoService() {
        this.documentoService = new DocumentoService();
    }

    public void crearEvento(String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula, Integer idDocumento) {
        String sql = "INSERT INTO Eventos (descripcion, fecha_evento, tipo_evento, id_aula, id_documento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, descripcion);
            pstmt.setTimestamp(2, fechaEvento);
            pstmt.setString(3, tipoEvento);
            pstmt.setInt(4, idAula);

            if (idDocumento != null) {
                pstmt.setInt(5, idDocumento);
            } else {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            }

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al crear el evento: " + ex.getMessage());
        }
    }

    /**
     * Crea un nuevo evento en la base de datos.
     *
     * @param descripcion Descripción del evento.
     * @param fechaEvento Fecha y hora del evento.
     * @param tipoEvento Tipo del evento.
     * @param idAula ID del aula asociada al evento.
     * @param idDocumento ID del documento asociado al evento.
     */
    public boolean actualizarEvento(int idEvento, String descripcion, Timestamp fechaEvento,
            String tipoEvento, int idAula, Integer idDocumento) {
        String sql = "UPDATE Eventos SET descripcion = ?, fecha_evento = ?, tipo_evento = ?, "
                + "id_aula = ?, id_documento = ? WHERE id_evento = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, descripcion);
            pstmt.setTimestamp(2, fechaEvento);
            pstmt.setString(3, tipoEvento);
            pstmt.setInt(4, idAula);
            if (idDocumento != null) {
                pstmt.setInt(5, idDocumento);
            } else {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            }
            pstmt.setInt(6, idEvento);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al actualizar el evento: " + ex.getMessage());
            return false;
        }
    }

      /**
     * Obtiene todos los eventos de la base de datos.
     *
     * @return Lista de todos los eventos
     */
    public List<Evento> obtenerEventos() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM eventos ORDER BY fecha_evento";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setFechaEvento(rs.getTimestamp("fecha_evento"));
                evento.setTipoEvento(rs.getString("tipo_evento"));
                evento.setIdAula(rs.getInt("id_aula"));
                
                Integer idDocumento = rs.getObject("id_documento") != null ? 
                                    rs.getInt("id_documento") : null;
                evento.setIdDocumento(idDocumento);
                
                eventos.add(evento);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener los eventos: " + ex.getMessage());
        }

        return eventos;
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
        String sql = "SELECT * FROM eventos WHERE id_evento = ?";
        Evento evento = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEvento);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                evento = new Evento();
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setFechaEvento(rs.getTimestamp("fecha_evento"));
                evento.setTipoEvento(rs.getString("tipo_evento"));
                evento.setIdAula(rs.getInt("id_aula"));

                Integer idDocumento = rs.getObject("id_documento") != null
                        ? rs.getInt("id_documento") : null;
                evento.setIdDocumento(idDocumento);

                if (idDocumento != null) {
                    Documento documento = documentoService.getDocumentoById(idDocumento);
                    evento.setDocumento(documento);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el evento por ID: " + ex.getMessage());
        }

        return evento;
    }

    public List<Evento> obtenerEventosPorAula(int idAula) {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos WHERE id_aula = ?";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, idAula);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Evento evento = new Evento();
                    evento.setIdEvento(rs.getInt("id_evento"));
                    evento.setDescripcion(rs.getString("descripcion"));
                    evento.setFechaEvento(rs.getTimestamp("fecha_evento"));
                    evento.setTipoEvento(rs.getString("tipo_evento"));
                    evento.setIdAula(rs.getInt("id_aula"));

                    // Manejar el id_documento que puede ser null
                    Integer idDocumento = rs.getObject("id_documento") != null
                            ? rs.getInt("id_documento") : null;
                    evento.setIdDocumento(idDocumento);

                    // Si hay un documento asociado, cargarlo
                    if (idDocumento != null) {
                        Documento documento = documentoService.getDocumentoById(idDocumento);
                        evento.setDocumento(documento);
                    }

                    eventos.add(evento);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener eventos por aula: " + e.getMessage());
        }

        return eventos;
    }
}
