package com.planifai.controller;

import com.planifai.model.Documento;
import com.planifai.service.DocumentoService;
import java.util.List;


/**
 * Controlador para manejar las operaciones relacionadas con documentos.
 * Permite crear, obtener, actualizar y eliminar documentos utilizando
 * el servicio correspondiente.
 * 
 * @author Marta Rosado Nabais
 */
public class DocumentoController {

    private DocumentoService documentoService;

    /**
     * Constructor de la clase DocumentoController.
     *
     * @param documentoService Instancia del servicio de documentos.
     */
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    /**
     * Crea un nuevo documento utilizando el servicio de documentos.
     *
     * @param titulo Título del documento.
     * @param contenido Contenido del documento.
     * @param tipoDocumento Tipo del documento.
     * @param idAula ID del aula asociada al documento, puede ser null.
     * @param idEvento ID del evento asociado al documento, puede ser null.
     */
    public void crearDocumento(String titulo, String contenido, String tipoDocumento, Integer idAula, Integer idEvento) {
        documentoService.crearDocumento(titulo, contenido, tipoDocumento, idAula, idEvento);
    }

    /**
     * Obtiene un documento por su ID.
     *
     * @param idDocumento ID del documento a obtener.
     * @return Documento objeto que representa el documento encontrado, o null si no se encuentra.
     */
    public Documento getDocumentoById(int idDocumento) {
        return documentoService.getDocumentoById(idDocumento);
    }

    /**
     * Obtiene una lista de todos los documentos.
     *
     * @return List<Documento> Lista de documentos.
     */
    public List<Documento> obtenerDocumentos() {
        return documentoService.getDocumentos();
    }

    /**
     * Actualiza la información de un documento existente.
     *
     * @param idDocumento ID del documento a actualizar.
     * @param nuevoTitulo Nuevo título del documento.
     * @param nuevoContenido Nuevo contenido del documento.
     * @param nuevoTipoDocumento Nuevo tipo del documento.
     * @param idAula Nuevo ID del aula asociada al documento, puede ser null.
     * @param idEvento Nuevo ID del evento asociado al documento, puede ser null.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarDocumento(int idDocumento, String nuevoTitulo, String nuevoContenido, String nuevoTipoDocumento, Integer idAula, Integer idEvento) {
        return documentoService.actualizarDocumento(idDocumento, nuevoTitulo, nuevoContenido, nuevoTipoDocumento, idAula, idEvento);
    }

    /**
     * Elimina un documento por su ID.
     *
     * @param idDocumento ID del documento a eliminar.
     * @return true si el documento fue eliminado con éxito, false en caso contrario.
     */
    public boolean eliminarDocumento(int idDocumento) {
        return documentoService.eliminarDocumentoPorId(idDocumento);
    }
}