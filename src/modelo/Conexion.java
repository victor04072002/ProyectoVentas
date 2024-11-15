package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
//URL o direccion
//Puerto de conexion
//Nombre de la base de datos
//Nombre del usuario
//Contrasena

    private final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1450;databaseName=ventas;trustServerCertificate=true";
    private final String USER = "user_db";
    private final String PASSWORD = "Temporal123";


    Connection conexion;

    public Connection getConection() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return conexion;
    }
}
