package modelo;

import java.sql.Timestamp;

public class Venta {

    private int id;
    private int idUsuario;
    private int idCliente;
    private double monto;
    private Timestamp hora;
    private int estado;

    public Venta() {
    }

    public Venta(int id, int idUsuario, int idCliente, double monto, Timestamp hora, int estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.monto = monto;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
