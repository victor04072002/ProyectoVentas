
package modelo;

public class Marca {
    private int id;
    private String marca;
    private int estado;

    public Marca() {
    }

    public Marca(int id, String marca, int estado) {
        this.id = id;
        this.marca = marca;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
