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
 *
 * @author marta
 */
public class DocumentoService {

    // Método para crear un nuevo documento
    public void crearDocumento(String titulo, String contenido, String tipoDocumento, Integer idAula, Integer idEvento) {
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

    // Método para obtener todos los documentos
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

    // Método para eliminar un documento por ID
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
}
