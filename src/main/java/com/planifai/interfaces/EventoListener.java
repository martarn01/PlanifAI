package com.planifai.interfaces;

/**
 * Listener para eventos de eliminación de un documento.
 *
 * @author Marta Rosado Nabais
 */
public interface EventoListener {

    /**
     * Método invocado cuando un documento ha sido eliminado.
     */
    void onEventoDeleted();
}
