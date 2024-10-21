package com.mycompany.planifai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marta
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/PlanifAI";
    private static final String USER = "postgres";
    private static final String PASSWORD = "OQC3xBhUo673yz7eH1gr";

    // Método para establecer la conexión
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
            throw e;  // para que se propague el error
        }
        return connection;
    }
}
