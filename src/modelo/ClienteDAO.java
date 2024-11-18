package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    Connection conexion;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public ClienteDAO() {
        conexion = new Conexion().getConection();
    }

    public Cliente getClienteById(int id) {
        var cliente = new Cliente();
        try {
            query = "SELECT * FROM clientes where id = ?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente.setId(resultSet.getInt(1));
                cliente.setRfc(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(3));
                cliente.setApellido_paterno(resultSet.getString(4));
                cliente.setApellido_materno(resultSet.getString(5));
                cliente.setCorreo(resultSet.getString(6));
                cliente.setTelefono(resultSet.getString(7));
                cliente.setEstado(resultSet.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cliente;
    }

    public int registrar(Cliente cliente) {
        try {
            /*Esta primera consulta es para verificar que no exista ya un
            cliente con el mismo RFC*/
            query = "SELECT rfc FROM clientes WHERE rfc=? OR correo = ? OR telefono = ?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cliente.getRfc());
            preparedStatement.setString(2, cliente.getCorreo());
            preparedStatement.setString(3, cliente.getTelefono());
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

    public int actualizar(Cliente cliente) {
        /*Se inicializa la query con StringBuilder para posteriormente
        agregar los campos que se van a actualizar
         */
        try {
            query = "SELECT rfc FROM clientes WHERE rfc=? OR correo = ? OR telefono = ?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cliente.getRfc());
            preparedStatement.setString(2, cliente.getCorreo());
            preparedStatement.setString(3, cliente.getTelefono());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return 2;
            }

            StringBuilder sql = new StringBuilder("UPDATE clientes SET ");

            //Variable para saber si se ha actualizado un campo previo
            boolean hasPrevious = false;

            if (cliente.getRfc() != null) {
                sql.append("rfc = ?");
                hasPrevious = true;
            }
            if (cliente.getNombre() != null) {
                if (hasPrevious) {
                    sql.append(", ");
                }
                sql.append("nombre = ?");
                hasPrevious = true;
            }
            if (cliente.getApellido_paterno() != null) {
                if (hasPrevious) {
                    sql.append(", ");
                }
                sql.append("apellido_paterno = ?");
                hasPrevious = true;
            }
            if (cliente.getApellido_materno() != null) {
                if (hasPrevious) {
                    sql.append(", ");
                }
                sql.append("apellido_materno = ?");
                hasPrevious = true;
            }
            if (cliente.getCorreo() != null) {
                if (hasPrevious) {
                    sql.append(", ");
                }
                sql.append("correo = ?");
                hasPrevious = true;
            }
            if (cliente.getTelefono() != null) {
                if (hasPrevious) {
                    sql.append(", ");
                }
                sql.append("telefono = ?");
            }

            sql.append(" WHERE id = ?;");

            preparedStatement = conexion.prepareStatement(sql.toString());
            int indice = 1;
            if (cliente.getRfc() != null) {
                preparedStatement.setString(indice, cliente.getRfc());
                indice++;
            }
            if (cliente.getNombre() != null) {
                preparedStatement.setString(indice, cliente.getNombre());
                indice++;
            }
            if (cliente.getApellido_paterno() != null) {
                preparedStatement.setString(indice, cliente.getApellido_paterno());
                indice++;
            }
            if (cliente.getApellido_materno() != null) {
                preparedStatement.setString(indice, cliente.getApellido_materno());
                indice++;
            }
            if (cliente.getCorreo() != null) {
                preparedStatement.setString(indice, cliente.getCorreo());
                indice++;
            }
            if (cliente.getTelefono() != null) {
                preparedStatement.setString(indice, cliente.getTelefono());
                indice++;
            }
            preparedStatement.setInt(indice, cliente.getId());
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

    public ArrayList<Cliente> getClientes() {
        var clientes = new ArrayList<Cliente>();

        try {
            query = "SELECT id, rfc, nombre, apellido_paterno, apellido_materno, "
                    + "correo, telefono, estado "
                    + "FROM clientes WHERE estado <> 0;";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            Cliente cliente;
            while (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt(1));
                cliente.setRfc(resultSet.getString(2));
                cliente.setNombre(resultSet.getString(3));
                cliente.setApellido_paterno(resultSet.getString(4));
                cliente.setApellido_materno(resultSet.getString(5));
                cliente.setCorreo(resultSet.getString(6));
                cliente.setTelefono(resultSet.getString(7));
                cliente.setEstado(resultSet.getInt(8));
                clientes.add(cliente);

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
        return clientes;
    }

    public boolean activarDesactivar(int id, int estado) {

        try {
            var accion = 0;
            if (estado == 1) {
                accion = 2;
            } else {
                accion = 1;
            }
            query = "UPDATE clientes SET estado = ? WHERE id = ?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, accion);
            preparedStatement.setInt(2, id);
            var numResultados = preparedStatement.executeUpdate();
            if (numResultados == 1) {
                return true;
            }
        } catch (SQLException e) {

        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return false;
    }

    public boolean eliminar(int id) {
        try {
            query = "UPDATE clientes SET estado = 0 WHERE id = ?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            var numResultados = preparedStatement.executeUpdate();
            if (numResultados == 1) {
                return true;
            }
        } catch (SQLException e) {
            
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }
}
