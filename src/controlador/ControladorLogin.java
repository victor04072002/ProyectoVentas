package controlador;

import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import vistas.VistaLogin;

public class ControladorLogin {

    public static VistaLogin vista = new VistaLogin();

    public static void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public static void login() {
        if (vista.getTextLoginUsername().getText().trim().length() > 0 && vista.getTextLoginPassword().getText().trim().length() > 0) {
            switch (new UsuarioDAO().login(vista.getTextLoginUsername().getText().trim(), vista.getTextLoginPassword().getText().trim())) {
                case 1:
                    ControladorSistema.mostrar();
                    ocultar();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "El usuario está inactivo, contacte con el administrador",
                            "Usuario inactivo",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,
                            "El usuario y/o la contraseña son incorrectos",
                            "Datos incorrectos",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "El usuario y la contraseña son datos ",
                    "Datos incorrectos",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ocultar() {
        vista.setVisible(false);
    }

    static void limpiar() {
        vista.getTextLoginUsername().setText("");
        vista.getTextLoginPassword().setText("");
    }

}
