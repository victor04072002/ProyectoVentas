
package modelo;

public class BitacoraAcciones {
private int id;
private String accion;
private int estado;

    public BitacoraAcciones() {
    }

    public BitacoraAcciones(int id, String accion, int estado) {
        this.id = id;
        this.accion = accion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
