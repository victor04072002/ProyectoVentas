package controlador;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.BitacoraDAO;
import vistas.ImprovementVistaSistema;

public class ControladorBitacora {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(2);
        llenarListas();
    }

    public static void buscar() {
     

    }
    public static void llenarListas(){
        if (vista.getCbxBitacoraAccion().getItemCount()==0) {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            List<String> listado= new BitacoraDAO().getListadoAcciones();
            for (int i = 0; i < listado.size(); i++) {
                modelo.addElement(listado.get(i));
            }
            vista.getCbxBitacoraAccion().setModel(modelo);
        }

    }
}
