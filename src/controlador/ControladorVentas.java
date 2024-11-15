package controlador;

import vistas.ImprovementVistaSistema;

public class ControladorVentas {

    static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(0);
    }
}
