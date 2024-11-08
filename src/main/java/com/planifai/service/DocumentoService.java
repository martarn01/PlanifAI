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
    public void crearDocumento(String titulo, String contenido, String tipoDocumento, int idAula, int idEvento) {
        String sql = "INSERT INTO Documentos (titulo, contenido, tipo_documento, id_aula, id_evento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, contenido);
            pstmt.setString(3, tipoDocumento);
            pstmt.setObject(4, idAula); // id_aula puede ser NULL
            pstmt.setObject(5, idEvento); // id_evento puede ser NULL
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
        String sql = "SELECT id_documento, titulo, contenido, fecha_creacion, tipo_documento, id_aula, id_evento FROM Documentos";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idDocumento = rs.getInt("id_documento");
                String titulo = rs.getString("titulo");
                String contenido = rs.getString("contenido");
                Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                String tipoDocumento = rs.getString("tipo_documento");
                Integer idAula = rs.getObject("id_aula") != null ? rs.getInt("id_aula") : null; // Maneja NULL
                Integer idEvento = rs.getObject("id_evento") != null ? rs.getInt("id_evento") : null; // Maneja NULL

                documentos.add(new Documento(idDocumento, titulo, contenido, fechaCreacion, tipoDocumento, idAula, idEvento, null, null, null));
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
    public boolean actualizarDocumento(int idDocumento, String nuevoTitulo, String nuevoContenido, String nuevoTipoDocumento, int idAula, int idEvento) {
        String sql = "UPDATE Documentos SET titulo = ?, contenido = ?, tipo_documento = ?, id_aula = ?, id_evento = ? WHERE id_documento = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoTitulo);
            pstmt.setString(2, nuevoContenido);
            pstmt.setString(3, nuevoTipoDocumento);
            pstmt.setObject(4, idAula); // id_aula puede ser NULL
            pstmt.setObject(5, idEvento); // id_evento puede ser NULL
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
            return rowsAffected > 0; // True si se eliminó al menos una fila
        } catch (SQLException e) {
            System.out.println("Error al eliminar el documento: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene un documento por su ID.
     *
     * @param idDocumento ID del documento a obtener.
     * @return Un objeto Documento correspondiente al ID, o null si no se
     * encontró.
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
                Integer idAula = rs.getObject("id_aula") != null ? rs.getInt("id_aula") : null; // Maneja NULL
                Integer idEvento = rs.getObject("id_evento") != null ? rs.getInt("id_evento") : null; // Maneja NULL

                documento = new Documento(idDoc, titulo, contenido, fechaCreacion, tipoDocumento, idAula, idEvento, null, null, null);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el documento por ID: " + ex.getMessage());
        }

        return documento;
    }
}
