package controlador;

import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vistas.ImprovementVistaSistema;

public class ControladorClientes {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(4);
    }

    public static void registrar() {
        var errores = new StringBuilder();
        var cliente = new Cliente();
        if (vista.getTxtClientesRfc().getText().trim().length() > 0) {
            cliente.setRfc(vista.getTxtClientesRfc().getText().trim());
        } else {
            errores.append("El campo RFC no debe ser vacio\n");
        }
        if (!vista.getTxtClientesNombre().getText().trim().equals("")) {
            cliente.setNombre(vista.getTxtClientesNombre().getText().trim());
        } else {
            errores.append("El campo nombre no debe ser vacio\n");
        }
        if (!vista.getTxtClientesApellidoPaterno().getText().trim().equals("")) {
            cliente.setApellido_paterno(vista.getTxtClientesApellidoPaterno().getText().trim());
        } else {
            errores.append("El campo apellido paterno no debe ser vacio\n");
        }
        if (!vista.getTxtClientesApellidoMaterno().getText().trim().equals("")) {
            cliente.setApellido_materno(vista.getTxtClientesApellidoMaterno().getText().trim());
        } else {
            errores.append("El campo apellido materno no debe ser vacio\n");
        }
        if (!vista.getTxtClientesCorreo().getText().trim().equals("")) {
            cliente.setCorreo(vista.getTxtClientesCorreo().getText().trim());
        } else {
            errores.append("El campo correo no debe ser vacio");
        }
        if (!vista.getTxtClientesTelefono().getText().trim().equals("")) {
            cliente.setTelefono(vista.getTxtClientesTelefono().getText().trim());
        } else {
            errores.append("El campo telefono no debe ser vacio");
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    errores.toString(),
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            switch (new ClienteDAO().registrar(cliente)) {
                case 1:

                    JOptionPane.showMessageDialog(null,
                            "El registro fue exitoso",
                            "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                    //limpiar();
                    //Llenartabla();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "El cliente ya existe en el sistema",
                            "Registro fallido",
                            JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Contacte al administrador del sistema",
                            "Algo ocurrio",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

    }
}
