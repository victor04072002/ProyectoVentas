
package modelo;

public class Categoria {
 private int id;
 private String categoria;
 private int estado;
 public Categoria(){}

    public Categoria(int id, String categoria, int estado) {
        this.id = id;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
}
