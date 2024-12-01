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
 * Clase de servicio para manejar las operaciones relacionadas con eventos en el sistema.
 * Proporciona métodos para crear, obtener, actualizar y eliminar eventos en la base de datos.
 * 
 * <p>Esta clase utiliza la clase {@code DocumentoService} para manejar documentos
 * asociados a eventos, asegurando la integridad de los datos.</p>
 *
 * @author Marta Rosado Nabais
 */
public class EventoService {

    private DocumentoService documentoService;

    /**
     * Constructor por defecto que inicializa el servicio de documentos.
     */
    public EventoService() {
        this.documentoService = new DocumentoService();
    }

    /**
     * Crea un nuevo evento en la base de datos.
     *
     * @param descripcion Descripción del evento.
     * @param fechaEvento Fecha y hora del evento.
     * @param tipoEvento Tipo del evento (por ejemplo, conferencia, taller).
     * @param idAula ID del aula asociada al evento.
     * @param idDocumento ID del documento asociado al evento (opcional).
     */
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
     * Actualiza un evento existente en la base de datos.
     *
     * @param idEvento ID del evento a actualizar.
     * @param descripcion Nueva descripción del evento.
     * @param fechaEvento Nueva fecha y hora del evento.
     * @param tipoEvento Nuevo tipo del evento.
     * @param idAula Nuevo ID del aula asociada al evento.
     * @param idDocumento Nuevo ID del documento asociado al evento (opcional).
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     */
    public boolean actualizarEvento(int idEvento, String descripcion, Timestamp fechaEvento, String tipoEvento, int idAula, Integer idDocumento) {
        String sql = "UPDATE Eventos SET descripcion = ?, fecha_evento = ?, tipo_evento = ?, id_aula = ?, id_documento = ? WHERE id_evento = ?";

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
     * Obtiene todos los eventos de la base de datos, ordenados por fecha de evento.
     *
     * @return Lista de todos los eventos registrados.
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

                Integer idDocumento = rs.getObject("id_documento") != null ? rs.getInt("id_documento") : null;
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
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     */
    public boolean eliminarEventoPorId(int idEvento) {
        String sql = "DELETE FROM Eventos WHERE id_evento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEvento);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene un evento específico de la base de datos por su ID.
     *
     * @param idEvento ID del evento a obtener.
     * @return Objeto {@code Evento} correspondiente al ID, o {@code null} si no se encuentra.
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

                Integer idDocumento = rs.getObject("id_documento") != null ? rs.getInt("id_documento") : null;
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

    /**
     * Obtiene todos los eventos asociados a un aula específica.
     *
     * @param idAula ID del aula cuyos eventos se desean obtener.
     * @return Lista de eventos asociados al aula.
     */
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

                    Integer idDocumento = rs.getObject("id_documento") != null ? rs.getInt("id_documento") : null;
                    evento.setIdDocumento(idDocumento);

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
