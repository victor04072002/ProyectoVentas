package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    Connection conexion;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ClienteDAO() {
        conexion = new Conexion().getConection();
    }

    public int registrar(Cliente cliente) {
        try {
            query = "SELECT rfc FROM clientes where rfc=?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cliente.getRfc());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return 2;
            }
            query = "INSERT INTO clientes ("
                    + "rfc, nombre, apellido_paterno, apellido_materno, correo, telefono)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cliente.getRfc());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido_paterno());
            preparedStatement.setString(4, cliente.getApellido_materno());
            preparedStatement.setString(5, cliente.getCorreo());
            preparedStatement.setString(6, cliente.getTelefono());
            var numRegistrosAfectados = preparedStatement.executeUpdate();

            if (numRegistrosAfectados > 0) {
                return 1;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return 0;

    }
}
