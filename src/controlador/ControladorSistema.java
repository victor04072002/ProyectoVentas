package controlador;

import vistas.ImprovementVistaSistema;
//import vistas.VistaSistema;

public class ControladorSistema {

    public static ImprovementVistaSistema vista = new ImprovementVistaSistema();

    public static void mostrar() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public static void ocultar() {
        vista.setVisible(false);
    }

    public static void iniciarLogin() {
        ControladorLogin.mostrar();

    }

    public static void iniciarVentas() {
        ControladorVentas.mostrar();
    }

    public static void iniciarUsuarios() {
        ControladorUsuarios.mostrar();
    }

    public static void iniciarBitacora() {
        ControladorBitacora.mostrar();

    }

    public static void iniciarProductos() {
        ControladorProductos.mostrar();
    }

    public static void cerrarSesion() {
        ocultar();
        ControladorLogin.limpiar();
        ControladorLogin.mostrar();
    }

    public static void Salir() {
        System.exit(0);
    }

    public static void iniciarClientes() {
        ControladorClientes.mostrar();
    }

}
