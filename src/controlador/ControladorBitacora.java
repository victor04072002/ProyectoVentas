package controlador;

import vistas.ImprovementVistaSistema;

public class ControladorBitacora {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(2);
    }
}
