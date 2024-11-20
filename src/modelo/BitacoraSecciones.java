package modelo;

public class BitacoraSecciones {

    private int id;
    private String seccion;
    private int estado;

    public BitacoraSecciones() {
    }

    public BitacoraSecciones(int id, String seccion, int estado) {
        this.id = id;
        this.seccion = seccion;
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
