
package controlador;

import vistas.VistaLogin;


public class ControladorLogin {
    public static VistaLogin vista= new VistaLogin();
     
        public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public static void login() {
        var nombreUsuario = vista.getTextLoginUsername().getText().trim();
        var passwordUsuario = vista.getTextLoginPassword().getText().trim();
        ControladorSistema.mostrar();
        ocultar();
    }
    public static void ocultar(){
    vista.setVisible(false);
    }

    static void limpiar() {
        vista.getTextLoginUsername().setText("");
        vista.getTextLoginPassword().setText("");
    }
    
}
