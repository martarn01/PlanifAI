package com.planifai.service;

import com.planifai.model.Documento;
import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que proporciona servicios para gestionar documentos en el sistema.
 * Incluye métodos para crear, obtener y eliminar documentos de la base de
 * datos.
 *
 * @author Marta Rosado Nabais
 */
public class DocumentoService {

    /**
     * Crea un nuevo documento en la base de datos.
     *
     * @param titulo Título del documento.
     * @param contenido Contenido del documento.
     * @param tipoDocumento Tipo del documento.
     * @param idAula ID del aula asociada al documento (puede ser null).
     * @param idEvento ID del evento asociado al documento (puede ser null).
     */
    public void crearDocumento(String titulo, String contenido, String tipoDocumento, Integer idAula, Integer idEvento) {
        String sql = "INSERT INTO documentos (titulo, contenido, tipo_documento, id_aula, id_evento) VALUES (?, ?, ?, ?, ?)";
        System.out.println("Entrando en el documento");
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, contenido);
            pstmt.setString(3, tipoDocumento);
            pstmt.setObject(4, idAula);
            if (idEvento == null) {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            } else {
                pstmt.setInt(5, idEvento);
            }

            pstmt.executeUpdate();
            System.out.println("Documento guardado exitosamente.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar el documento: " + ex.getMessage());
        }
    }

    /**
     * Obtiene todos los documentos de la base de datos.
     *
     * @return Lista de objetos Documento.
     */
    public List<Documento> getDocumentos() {
        List<Documento> documentos = new ArrayList<>();
        String sql = "SELECT * FROM Documentos ORDER BY fecha_creacion DESC";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idDocumento = rs.getInt("id_documento");
                String titulo = rs.getString("titulo");
                String contenido = rs.getString("contenido");
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                String tipoDocumento = rs.getString("tipo_documento");
                Integer idAula = rs.getObject("id_aula") != null ? rs.getInt("id_aula") : null;
                Integer idEvento = rs.getObject("id_evento") != null ? rs.getInt("id_evento") : null;

                documentos.add(new Documento(idDocumento, titulo, contenido, fechaCreacion, tipoDocumento, idAula, idEvento, null, null));
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar documentos desde la base de datos: " + ex.getMessage());
        }
        return documentos;
    }

    /**
     * Actualiza la información de un documento existente.
     *
     * @param idDocumento ID del documento a actualizar.
     * @param nuevoTitulo Nuevo título del documento.
     * @param nuevoContenido Nuevo contenido del documento.
     * @param nuevoTipoDocumento Nuevo tipo del documento.
     * @param idAula ID del aula asociada al documento (puede ser null).
     * @param idEvento ID del evento asociado al documento (puede ser null).
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarDocumento(int idDocumento, String nuevoTitulo, String nuevoContenido, String nuevoTipoDocumento, Integer idAula, Integer idEvento) {
        String sql = "UPDATE documentos SET titulo = ?, contenido = ?, tipo_documento = ?, id_aula = ?, id_evento = ? WHERE id_documento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoTitulo);
            pstmt.setString(2, nuevoContenido);
            pstmt.setString(3, nuevoTipoDocumento);
            pstmt.setObject(4, idAula); // id_aula puede ser NULL
            if (idEvento == null) {
                pstmt.setNull(5, java.sql.Types.INTEGER);
            } else {
                pstmt.setInt(5, idEvento);
            }
            pstmt.setInt(6, idDocumento);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el documento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un documento de la base de datos por su ID.
     *
     * @param idDocumento ID del documento a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarDocumentoPorId(int idDocumento) {
        String sql = "DELETE FROM Documentos WHERE id_documento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDocumento);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el documento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene un documento por su ID.
     *
     * @param idDocumento ID del documento a obtener.
     * @return Un objeto {@link Documento} correspondiente al ID proporcionado,
     * o null si no se encontró un documento con ese ID.
     */
    public Documento getDocumentoById(int idDocumento) {
        String sql = "SELECT id_documento, titulo, contenido, fecha_creacion, tipo_documento, id_aula, id_evento FROM Documentos WHERE id_documento = ?";
        Documento documento = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDocumento);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int idDoc = rs.getInt("id_documento");
                String titulo = rs.getString("titulo");
                String contenido = rs.getString("contenido");
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                String tipoDocumento = rs.getString("tipo_documento");
                Integer idAula = rs.getObject("id_aula") != null ? rs.getInt("id_aula") : null;
                Integer idEvento = rs.getObject("id_evento") != null ? rs.getInt("id_evento") : null;

                documento = new Documento(idDoc, titulo, contenido, fechaCreacion, tipoDocumento, idAula, idEvento, null, null);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el documento por ID: " + ex.getMessage());
        }

        return documento;
    }

    /**
     * Obtiene una lista de documentos asociados a un aula específica desde la
     * base de datos. Este método ejecuta una consulta SQL para obtener todos
     * los documentos que están relacionados con el aula cuyo ID se pasa como
     * parámetro.
     *
     * @param idAula El identificador del aula cuyos documentos se desean
     * obtener.
     * @return Una lista de objetos {@link Documento} que representan los
     * documentos asociados al aula especificada. Si no se encuentran documentos
     * para el aula, se retorna una lista vacía.
     */
    public List<Documento> obtenerDocumentosPorAula(int idAula) {
        List<Documento> documentos = new ArrayList<>();
        String query = "SELECT * FROM documentos WHERE id_aula = ?";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, idAula);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Documento documento = new Documento();
                    documento.setIdDocumento(rs.getInt("id_documento"));
                    documento.setTitulo(rs.getString("titulo"));
                    documento.setContenido(rs.getString("contenido"));
                    documento.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                    documento.setTipoDocumento(rs.getString("tipo_documento"));
                    documento.setIdAula(rs.getInt("id_aula"));
                    documentos.add(documento);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener documentos por aula: " + e.getMessage());
        }
        return documentos;
    }
}
