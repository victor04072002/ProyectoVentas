package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vistas.ImprovementVistaSistema;

public class ControladorClientes {

    public static ImprovementVistaSistema vista = ControladorSistema.vista;

    public static void mostrar() {
        ControladorSistema.vista.getVistasMultiple().setSelectedIndex(4);
        Llenartabla();
    }

    public static void Llenartabla() {
        var clientes = new ClienteDAO().getClientes();
        var modelo = (DefaultTableModel) vista.getTblClientes().getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        var estadoString = "";
        for (var i = 0; i < clientes.size(); i++) {
            estadoString = clientes.get(i).getEstado() == 1 ? "Activo" : "Inactivo";
            Object[] renglon = {
                clientes.get(i).getId(),
                clientes.get(i).getRfc(),
                clientes.get(i).getNombre(),
                clientes.get(i).getApellido_paterno(),
                clientes.get(i).getApellido_materno(),
                clientes.get(i).getCorreo(),
                clientes.get(i).getTelefono(),
                estadoString};
            modelo.addRow(renglon);
        }

        vista.getTblClientes().setModel(modelo);
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
                    limpiar();
                    Llenartabla();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "No puede registrar un cliente con el mismo\nRFC, Correo o Teléfono",
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

    public static void actualizar() {
        var errores = new StringBuilder();
        var clienteActualizado = new Cliente();
        boolean algunCambio = false;
        if (!vista.getTxtClientesId().getText().trim().equals("")) {
            var cliente = new ClienteDAO().getClienteById(
                    Integer.parseInt(vista.getTxtClientesId().getText().trim()));

            clienteActualizado.setId(cliente.getId());

            if (!vista.getTxtClientesRfc().getText().trim().equals("")) {
                if (!vista.getTxtClientesRfc().getText().trim().equals(cliente.getRfc())) {
                    clienteActualizado.setRfc(vista.getTxtClientesRfc().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo RFC no debe ser vacío\n");
            }
            if (!vista.getTxtClientesNombre().getText().trim().equals("")) {
                if (!vista.getTxtClientesNombre().getText().trim().equals(cliente.getNombre())) {
                    clienteActualizado.setNombre(vista.getTxtClientesNombre().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo Nombre no debe ser vacío\n");
            }
            if (!vista.getTxtClientesApellidoPaterno().getText().trim().equals("")) {
                if (!vista.getTxtClientesApellidoPaterno().getText().trim().equals(cliente.getApellido_paterno())) {
                    clienteActualizado.setApellido_paterno(vista.getTxtClientesApellidoPaterno().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo Apellido Paterno no debe ser vacío\n");
            }
            if (!vista.getTxtClientesApellidoMaterno().getText().trim().equals("")) {
                if (!vista.getTxtClientesApellidoMaterno().getText().trim().equals(cliente.getApellido_materno())) {
                    clienteActualizado.setApellido_materno(vista.getTxtClientesApellidoMaterno().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo Apellido Materno no debe ser vacío\n");
            }
            if (!vista.getTxtClientesCorreo().getText().trim().equals("")) {
                if (!vista.getTxtClientesCorreo().getText().trim().equals(cliente.getCorreo())) {
                    clienteActualizado.setCorreo(vista.getTxtClientesCorreo().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo Correo no debe ser vacío\n");
            }
            if (!vista.getTxtClientesTelefono().getText().trim().equals("")) {
                if (!vista.getTxtClientesTelefono().getText().trim().equals(cliente.getTelefono())) {
                    clienteActualizado.setTelefono(vista.getTxtClientesTelefono().getText().trim());
                    algunCambio = true;
                }
            } else {
                errores.append("El campo Teléfono no debe ser vacío\n");
            }

            if (!algunCambio) {
                errores.append("Debe actualizar al menos un campo\n");
            }
        } else {
            errores.append("Debe seleccionar un cliente para actualizar sus datos");
        }
        if (errores.length() > 0) {
            JOptionPane.showMessageDialog(
                    null,
                    errores.toString(),
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            switch (new ClienteDAO().actualizar(clienteActualizado)) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                            "La actualización de datos fue exitosa",
                            "Actualización exitosa",
                            JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    Llenartabla();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Ese RFC, Correo o Teléfono ya existe en el sistema",
                            "Actualización fallida",
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

    public static void activarDesactivar() {
        if (vista.getTxtClientesId().getText().trim().length() > 0) {
            var estado = vista.getTxtClientesEstado().getText().equals("Activo") ? 1 : 2;

            if (new ClienteDAO().activarDesactivar(Integer.parseInt(
                    vista.getTxtClientesId().getText().trim()), estado)) {

                JOptionPane.showMessageDialog(null,
                        "El cliente ha sido modificado exitosamente",
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
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un cliente de la tabla",
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void eliminar() {
        if (vista.getTxtClientesId().getText().trim().length() > 0) {
            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas eliminar al cliente?",
                    "Confirmar acción",
                    JOptionPane.YES_NO_OPTION
            );
            if (opcion == JOptionPane.YES_OPTION) {
                if (new ClienteDAO().eliminar(Integer.parseInt(
                        vista.getTxtClientesId().getText().trim()))) {

                    JOptionPane.showMessageDialog(null,
                            "El cliente ha sido eliminado exitosamente",
                            "Eliminación exiosa",
                            JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    Llenartabla();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Contacte al administrador del sistema",
                            "Algo ocurrio",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un cliente de la tabla",
                    "Errores de validación",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void elegirClientes(int renglon) {
        vista.getTxtClientesId().setText(vista.getTblClientes().getValueAt(renglon, 0).toString());
        vista.getTxtClientesRfc().setText(vista.getTblClientes().getValueAt(renglon, 1).toString());
        vista.getTxtClientesNombre().setText(vista.getTblClientes().getValueAt(renglon, 2).toString());
        vista.getTxtClientesApellidoPaterno().setText(vista.getTblClientes().getValueAt(renglon, 3).toString());
        vista.getTxtClientesApellidoMaterno().setText(vista.getTblClientes().getValueAt(renglon, 4).toString());
        vista.getTxtClientesCorreo().setText(vista.getTblClientes().getValueAt(renglon, 5).toString());
        vista.getTxtClientesTelefono().setText(vista.getTblClientes().getValueAt(renglon, 6).toString());
        vista.getTxtClientesEstado().setText(vista.getTblClientes().getValueAt(renglon, 7).toString());
    }

    public static void limpiar() {
        vista.getTxtClientesId().setText("");
        vista.getTxtClientesRfc().setText("");
        vista.getTxtClientesNombre().setText("");
        vista.getTxtClientesApellidoPaterno().setText("");
        vista.getTxtClientesApellidoMaterno().setText("");
        vista.getTxtClientesCorreo().setText("");
        vista.getTxtClientesTelefono().setText("");
        vista.getTxtClientesEstado().setText("");
    }
}
