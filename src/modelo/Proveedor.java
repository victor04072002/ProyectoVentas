
package modelo;

public class Proveedor {
private int serial;
private String proveedor;
private String razonSocial;
private String contacto;
private String correo;
private String telefono;
private int estado;

    public Proveedor(int serial, String proveedor, String razon_social, String contacto, String correo, String telefono, int estado) {
        this.serial = serial;
        this.proveedor = proveedor;
        this.razonSocial = razon_social;
        this.contacto = contacto;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Proveedor() {
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRazon_social() {
        return razonSocial;
    }

    public void setRazon_social(String razon_social) {
        this.razonSocial = razon_social;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
