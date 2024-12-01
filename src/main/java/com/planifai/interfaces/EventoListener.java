package com.planifai.interfaces;

/**
 * Listener para cambios en eventos.
 *
 * @author Marta Rosado Nabais
 */
public interface EventoListener {

    /**
     * Método invocado cuando un documento ha sido eliminado.
     */
    void onEventoDeleted();

    /**
     * Método invocado cuando un evento ha sido creado.
     */
    void onEventoCreated();
}
