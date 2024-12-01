package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioDAO {

    Connection conexion;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public UsuarioDAO() {
        conexion = new Conexion().getConection();
    }

    public Usuario getUsuarioById(int id) {
        var usuario = new Usuario();
        try {
            query = "SELECT * FROM usuarios where id=?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt(1));
                usuario.setUsuario(resultSet.getString(2));
                usuario.setContrasena(resultSet.getString(3));
                usuario.setNombre(resultSet.getString(4));
                usuario.setApellidoPaterno(resultSet.getString(5));
                usuario.setApellidoMaterno(resultSet.getString(6));
                usuario.setEstado(resultSet.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuario;
    }

    public int registrar(Usuario usuario) {
        try {
            query = "SELECT usuario FROM usuarios where usuario=?;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return 2;
            }
            query = "INSERT INTO usuarios ("
                    + "nombre, apellido_paterno, apellido_materno, usuario, contrasena)"
                    + " VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidoPaterno());
            preparedStatement.setString(3, usuario.getApellidoMaterno());
            preparedStatement.setString(4, usuario.getUsuario());
            preparedStatement.setString(5, getMd5(usuario.getContrasena()));
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

    public ArrayList<Usuario> getUsuarios() {
        var usuarios = new ArrayList<Usuario>();

        try {
            query = "SELECT id, usuario, nombre, apellido_paterno, apellido_materno, estado "
                    + "FROM usuarios WHERE estado <> 0;";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            Usuario usuario;
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt(1));
                usuario.setUsuario(resultSet.getString(2));
                usuario.setNombre(resultSet.getString(3));
                usuario.setApellidoPaterno(resultSet.getString(4));
                usuario.setApellidoMaterno(resultSet.getString(5));
                usuario.setEstado(resultSet.getInt(6));
                usuarios.add(usuario);

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
        return usuarios;
    }

    public boolean modificar(Usuario usuario) {

        try {
            query = "UPDATE usuarios SET usuario=?, nombre=?, apellido_paterno=?,"
                    + " apellido_materno=? WHERE id=?";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getNombre());

            preparedStatement.setString(3, usuario.getApellidoPaterno());
            preparedStatement.setString(4, usuario.getApellidoMaterno());
            preparedStatement.setInt(5, usuario.getId());
            var numResultados = preparedStatement.executeUpdate();
            if (numResultados == 1) {
                return true;
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
        return false;
    }

    public boolean activarDesactivar(int id, int estado) {

        try {
            var accion = 0;
            if (estado == 1) {
                accion = 2;
            } else {
                accion = 1;
            }
            query = "UPDATE usuarios SET estado = ? WHERE id =?;";
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

    public int login(String usuario, String contrasena) {
        try {
            query = "SELECT usuario, contrasena, estado FROM usuarios WHERE usuario=? AND contrasena=? AND estado<>0;";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, getMd5(contrasena));
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("estado") == 1) {
                    return 1;
                } else {
                    return 2;
                }
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

    public static String getMd5(String contrasena) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] digest = m.digest(contrasena.getBytes());
            BigInteger bigInt = new BigInteger(1, digest);
            String encriptado = bigInt.toString(16);
            while (encriptado.length() < 32) {
                encriptado = "0" + encriptado;
            }
            return encriptado;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        return "";
    }

}
