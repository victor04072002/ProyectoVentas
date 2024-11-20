
package modelo;

public class Cliente {
 private int id;
 private String rfc;
 private String nombre;
 private String apellidoPaterno;
 private String apellidoMaterno;
 private String correo;
 private String telefono;
 private int estado;

    public Cliente() {
    }

    public Cliente(int id, String rfc, String nombre, String apellido_paterno, String apellido_materno, String correo, String telefono, int estado) {
        this.id = id;
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellido_paterno;
        this.apellidoMaterno = apellido_materno;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellidoPaterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellidoPaterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellidoMaterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellidoMaterno = apellido_materno;
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
