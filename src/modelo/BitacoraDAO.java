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
            conexion= new Conexion().getConection();
            String query="SELECT id,accion FROM bitacora_acciones;";
            preparedStatement=conexion.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
           listado.add(resultSet.getString(2));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }finally{
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
    
    
    }
        return listado;
 
    }

}
