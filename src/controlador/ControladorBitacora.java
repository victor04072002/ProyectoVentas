package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.BitacoraDAO;
import vistas.ImprovementVistaSistema;

public class ControladorBitacora {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(2);
        llenarListas();
        llenarFechas();
        //llenarTablaRegistros();
    }

    public static void llenarTablaRegistros() {
        int idAccion;
        int idSeccion;
        //Obtener fechas para la el metodo getRegistros()
        Date dateInicio = vista.getDateBitacoraInicio().getDate();
        Date dateFinal = vista.getDateBitacoraFinal().getDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formatter.format(dateInicio) + " 00:00:00.000";
        String fechaFinal = formatter.format(dateFinal) + " 23:59:59.999";

        switch (vista.getCbxBitacoraAccion().getItemAt(vista.getCbxBitacoraAccion().getSelectedIndex())) {
            case "Alta" ->
                idAccion = 4000;
            case "Baja" ->
                idAccion = 4001;
            case "Modificación" ->
                idAccion = 4002;
            case "Consulta" ->
                idAccion = 4003;
            default ->
                idAccion = 0;
        }

        switch (vista.getCbxBitacoraSeccion().getItemAt(vista.getCbxBitacoraSeccion().getSelectedIndex())) {
            case "Usuarios" ->
                idSeccion = 5000;
            case "Clientes" ->
                idSeccion = 5001;
            case "Productos" ->
                idSeccion = 5002;
            case "Proveedores" ->
                idSeccion = 5003;
            case "Ventas" ->
                idSeccion = 5004;
            default ->
                idSeccion = 0;
        }

        var registros = new BitacoraDAO().getRegistros(fechaInicio, fechaFinal, idAccion, idSeccion);
        if (!registros.isEmpty()) {
            var modelo = (DefaultTableModel) vista.getTblBitacoraRegistros().getModel();
            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            for (int i = 0; i < registros.size(); i++) {
                Object[] renglon = {
                    registros.get(i).getHora(),
                    registros.get(i).getUsuario(),
                    registros.get(i).getAccion(),
                    registros.get(i).getSeccion()};
                modelo.addRow(renglon);
            }
            vista.getTblBitacoraRegistros().setModel(modelo);
        }else{
            JOptionPane.showMessageDialog(null,
                            "No existe ningún registro con esos parámetros",
                            "Fallo en la consulta",
                            JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void llenarListas() {
        if (vista.getCbxBitacoraAccion().getItemCount() == 0) {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            List<String> listado = new BitacoraDAO().getListadoAcciones();
            for (int i = 0; i < listado.size(); i++) {
                modelo.addElement(listado.get(i));
            }
            vista.getCbxBitacoraAccion().setModel(modelo);
        }
        if (vista.getCbxBitacoraSeccion().getItemCount() == 0) {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            List<String> listado = new BitacoraDAO().getListadoSecciones();
            for (int i = 0; i < listado.size(); i++) {
                modelo.addElement(listado.get(i));
            }
            vista.getCbxBitacoraSeccion().setModel(modelo);
        }
    }

    public static void llenarFechas() {
        var Date = new Date();
        vista.getDateBitacoraInicio().setDate(Date);
        vista.getDateBitacoraFinal().setDate(Date);
    }
}
