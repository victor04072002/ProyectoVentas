package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.Usuario;
import vistas.ImprovementVistaSistema;

public class ControladorUsuarios {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(1);
        Llenartabla();
    }

    public static Usuario getUsuarioById(int id) {
        return new UsuarioDAO().getUsuarioById(id);
    }

    public static void registrar() {
        var errores = new StringBuilder();
        var usuario = new Usuario();
        if (vista.getTxtUsuariosNombre().getText().trim().length() > 0) {
            usuario.setNombre(vista.getTxtUsuariosNombre().getText().trim());
        } else {
            errores.append("El campo nombre no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosApellidoPaterno().getText().trim().equals("")) {
            usuario.setApellidoPaterno(vista.getTxtUsuariosApellidoPaterno().getText().trim());
        } else {
            errores.append("El campo apellido paterno no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosApellidoMaterno().getText().trim().equals("")) {
            usuario.setApellidoMaterno(vista.getTxtUsuariosApellidoMaterno().getText());
        } else {
            errores.append("El campo apellido materno no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosUsuario().getText().trim().equals("")) {
            usuario.setUsuario(vista.getTxtUsuariosUsuario().getText());
        } else {
            errores.append("El campo usuario no debe ser vacio\n");
        }
        if (!vista.getTxtUsuariosContrasena().getText().trim().equals("")) {
            usuario.setContrasena(vista.getTxtUsuariosContrasena().getText());
        } else {
            errores.append("El campo contraseña no debe ser vacio");
        }

        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    errores.toString(),
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            switch (new UsuarioDAO().registrar(usuario)) {
                case 1:

                    JOptionPane.showMessageDialog(null,
                            "El registro fue exitoso",
                            "Registro exitoso",
                            JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    Llenartabla();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "El usuario ya existe en el sistema",
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

    public static void Llenartabla() {
        var usuarios = new UsuarioDAO().getUsuarios();
        var modelo = (DefaultTableModel) vista.getTblUsuarios().getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        var estadoString = "";
        for (var i = 0; i < usuarios.size(); i++) {
            estadoString = usuarios.get(i).getEstado() == 1 ? "Activo" : "Inactivo";
            Object[] renglon = {
                usuarios.get(i).getId(),
                usuarios.get(i).getUsuario(),
                usuarios.get(i).getNombre(),
                usuarios.get(i).getApellidoPaterno(),
                usuarios.get(i).getApellidoMaterno(),
                estadoString};
            modelo.addRow(renglon);
        }

        vista.getTblUsuarios().setModel(modelo);
    }

    public static void limpiar() {
        vista.getTxtUsuariosId().setText("");
        vista.getTxtUsuariosNombre().setText("");
        vista.getTxtUsuariosApellidoPaterno().setText("");
        vista.getTxtUsuariosApellidoMaterno().setText("");
        vista.getTxtUsuariosUsuario().setText("");
        vista.getTxtUsuariosContrasena().setText("");
        vista.getTxtUsuariosEstado().setText("");
    }

    public static void modificar() {
        var usuario = new Usuario();
        var errores = new StringBuilder();

        if (vista.getTxtUsuariosId().getText().length() > 0) {
            usuario.setId(Integer.parseInt(vista.getTxtUsuariosId().getText()));

            if (vista.getTxtUsuariosUsuario().getText().length() > 0) {
                usuario.setUsuario(vista.getTxtUsuariosUsuario().getText());
            } else {
                errores.append("El nombre del usuario no debe ser vacio");
            }
            if (vista.getTxtUsuariosNombre().getText().length() > 0) {
                usuario.setNombre(vista.getTxtUsuariosNombre().getText());
            } else {
                errores.append("El nombre no debe ser vacio");
            }
            if (vista.getTxtUsuariosApellidoPaterno().getText().length() > 0) {
                usuario.setApellidoPaterno(vista.getTxtUsuariosApellidoPaterno().getText());
            } else {
                errores.append("El apellido paterno no debe ser vacio");
            }
            if (vista.getTxtUsuariosApellidoMaterno().getText().length() > 0) {
                usuario.setApellidoMaterno(vista.getTxtUsuariosApellidoMaterno().getText());
            } else {
                errores.append("El apellido materno no debe ser vacio");
            }
            
            if (errores.length() > 0) {
                JOptionPane.showMessageDialog(null, errores,
                        "Errores de validación",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                if (new UsuarioDAO().modificar(usuario)) {
                    JOptionPane.showMessageDialog(null,
                            "El usuario ha sido modificado exitosamente",
                            "Modificación exiosa",
                            JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    Llenartabla();
                } else {

                }
            }

        } else {
            errores.append("Se debe seleccionar un usuario de la tabla");
            JOptionPane.showMessageDialog(null, errores,
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
           
        }
        

    }

    public static void activarDesactivar() {
        if (vista.getTxtUsuariosId().getText().trim().length() > 0) {
            var estado = vista.getTxtUsuariosEstado().getText().equals("Activo") ? 1 : 2;

            if (new UsuarioDAO().activarDesactivar(Integer.parseInt(
                    vista.getTxtUsuariosId().getText().trim()), estado)) {

                JOptionPane.showMessageDialog(null,
                        "El usuario ha sido modificado exitosamente",
                        "Modificación exiosa",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                Llenartabla();
            } else {

                JOptionPane.showMessageDialog(null,
                        "Contacte al administrador del sistema",
                        "Algo ocurrio",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un usuario de la tabla",
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void elegirUsuarios(int renglon) {
        vista.getTxtUsuariosId().setText(vista.getTblUsuarios().getValueAt(renglon, 0).toString());
        vista.getTxtUsuariosUsuario().setText(vista.getTblUsuarios().getValueAt(renglon, 1).toString());
        vista.getTxtUsuariosNombre().setText(vista.getTblUsuarios().getValueAt(renglon, 2).toString());
        vista.getTxtUsuariosApellidoPaterno().setText(vista.getTblUsuarios().getValueAt(renglon, 3).toString());
        vista.getTxtUsuariosApellidoMaterno().setText(vista.getTblUsuarios().getValueAt(renglon, 4).toString());
        vista.getTxtUsuariosEstado().setText(vista.getTblUsuarios().getValueAt(renglon, 5).toString());
    }

}
