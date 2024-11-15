package com.planifai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos PostgreSQL de la
 * aplicación. Proporciona un método para obtener la conexión a la base de datos
 * mediante JDBC.
 *
 * @author Marta Rosado Nabais
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/PlanifAI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "OQC3xBhUo673yz7eH1gr";

    /**
     * Establece la conexión a la base de datos PostgreSQL.
     *
     * @return Un objeto {@link Connection} que representa la conexión
     * establecida.
     * @throws SQLException si ocurre un error durante la conexión.
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}
