package controlador;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.BitacoraDAO;
import vistas.ImprovementVistaSistema;

public class ControladorBitacora {
    
    public static ImprovementVistaSistema vista = ControladorSistema.vista;
    
    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(2);
        llenarListas();
        llenarFechas();
        llenarTablaRegistros();
    }
    
    public static void buscar() {
        
    }
    
    public static void llenarTablaRegistros() {
        var registros = new BitacoraDAO().getRegistros();
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
