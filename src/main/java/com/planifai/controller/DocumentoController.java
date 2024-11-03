package com.planifai.controller;

import com.planifai.service.DocumentoService;


/**
 
 * @author marta
 */
public class DocumentoController {

    private DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    // Método para eliminar un documento por ID
    public boolean eliminarDocumento(int idDocumento) {
      return documentoService.eliminarDocumentoPorId(idDocumento);
        
    }

}
