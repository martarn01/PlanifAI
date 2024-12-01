package com.planifai.service;

import com.planifai.model.Aula;
import com.planifai.model.Documento;
import com.planifai.model.Evento;
import com.planifai.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que proporciona servicios para gestionar aulas en el sistema. Incluye
 * métodos para crear, obtener, actualizar y eliminar aulas de la base de datos.
 *
 * @author Marta Rosado Nabais
 */
public class AulaService {

    private final EventoService eventoService;
    private final DocumentoService documentoService;

    public AulaService() {
        this.eventoService = new EventoService();
        this.documentoService = new DocumentoService();
    }

    /**
     * Crea una nueva aula en la base de datos.
     *
     * @param nombre Nombre del aula.
     * @param asignatura Asignatura asociada al aula.
     */
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

    /**
     * Obtiene una lista de todas las aulas en la base de datos.
     *
     * @return Lista de objetos Aula.
     */
    public List<Aula> getAulas() {
        List<Aula> aulas = new ArrayList<>();
        String sql = "SELECT id_aula, nombre, asignatura FROM Aulas";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Aula aula = new Aula(
                        rs.getInt("id_aula"),
                        rs.getString("nombre"),
                        rs.getString("asignatura")
                );

                // Cargar documentos y eventos para cada aula
                List<Documento> documentos = documentoService.obtenerDocumentosPorAula(aula.getIdAula());
                List<Evento> eventos = eventoService.obtenerEventosPorAula(aula.getIdAula());

                aula.setDocumento(documentos);
                aula.setEventos(eventos);

                aulas.add(aula);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener las aulas: " + ex.getMessage());
        }

        return aulas;
    }

    /**
     * Actualiza la información de un aula existente.
     *
     * @param idAula ID del aula a actualizar.
     * @param nuevoNombre Nuevo nombre del aula.
     * @param nuevaAsignatura Nueva asignatura asociada al aula.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarAula(int idAula, String nuevoNombre, String nuevaAsignatura) {
        String sql = "UPDATE Aulas SET nombre = ?, asignatura = ? WHERE id_aula = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaAsignatura);
            pstmt.setInt(3, idAula);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el aula: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un aula de la base de datos por su ID.
     *
     * @param idAula ID del aula a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminarAulaPorId(int idAula) {
        String sql = "DELETE FROM Aulas WHERE id_aula = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el aula: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene un aula por su ID.
     *
     * @param idAula ID del aula a obtener.
     * @return Un objeto Aula correspondiente al ID, o null si no se encontró.
     */
    public Aula getAulaById(int idAula) {
        String sql = "SELECT id_aula, nombre, asignatura FROM Aulas WHERE id_aula = ?";
        Aula aula = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                aula = new Aula(
                        rs.getInt("id_aula"),
                        rs.getString("nombre"),
                        rs.getString("asignatura")
                );

                // Cargar documentos y eventos asociados
                List<Documento> documentos = documentoService.obtenerDocumentosPorAula(idAula);
                List<Evento> eventos = eventoService.obtenerEventosPorAula(idAula);

                aula.setDocumento(documentos);
                aula.setEventos(eventos);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener el aula por ID: " + ex.getMessage());
        }

        return aula;
    }
}
