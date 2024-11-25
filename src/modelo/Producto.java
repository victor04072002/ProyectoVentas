
package modelo;

public class Producto {
private int serial;
private int idCategoria;
private int idMarca;
private int idProveedor;
private String producto;
private String descripcion;
private double precio;
private int inventario;
private int estado;

    public Producto() {
    }

    public Producto(int serial, int id_categoria, int id_marca, int id_proveedor, String producto, String descripcion, double precio, int inventario, int estado) {
        this.serial = serial;
        this.idCategoria = id_categoria;
        this.idMarca = id_marca;
        this.idProveedor = id_proveedor;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.inventario = inventario;
        this.estado = estado;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getId_categoria() {
        return idCategoria;
    }

    public void setId_categoria(int id_categoria) {
        this.idCategoria = id_categoria;
    }

    public int getId_marca() {
        return idMarca;
    }

    public void setId_marca(int id_marca) {
        this.idMarca = id_marca;
    }

    public int getId_proveedor() {
        return idProveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.idProveedor = id_proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
