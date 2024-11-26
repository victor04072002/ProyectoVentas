package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BitacoraDAO {

    Connection conexion;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public List getListadoAcciones() {
        List<String> listado = new ArrayList();
        listado.add("Todas");

        try {
            conexion = new Conexion().getConection();
            query = "SELECT id,accion FROM bitacora_acciones;";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listado.add(resultSet.getString(2));
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
            }

        }
        return listado;

    }

    public List getListadoSecciones() {
        List<String> listado = new ArrayList();
        listado.add("Todas");

        try {
            conexion = new Conexion().getConection();
            query = "SELECT id, seccion FROM bitacora_secciones;";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listado.add(resultSet.getString(2));
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
            }

        }
        return listado;

    }

    public ArrayList<Bitacora> getRegistros() {
        var registros = new ArrayList<Bitacora>();

        try {
            conexion = new Conexion().getConection();
            query = "SELECT b.hora, u.usuario, "
                    + "a.accion, "
                    + "s.seccion "
                    + "FROM bitacora AS b "
                    + "JOIN usuarios AS u ON u.id = b.id_usuario "
                    + "JOIN bitacora_acciones AS a ON a.id = b.id_accion "
                    + "JOIN bitacora_secciones AS s ON s.id = b.id_seccion "
                    + "WHERE b.estado = 1;";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            Bitacora registro;
            while (resultSet.next()) {
                registro = new Bitacora();
                registro.setHora(resultSet.getTimestamp(1));
                registro.setUsuario(resultSet.getString(2));
                registro.setAccion(resultSet.getString(3));
                registro.setSeccion(resultSet.getString(4));
                registros.add(registro);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
            }

        }
        return registros;

    }

}
