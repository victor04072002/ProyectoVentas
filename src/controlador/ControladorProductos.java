package controlador;

import vistas.ImprovementVistaSistema;

public class ControladorProductos {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;
    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(3);
    }

}
