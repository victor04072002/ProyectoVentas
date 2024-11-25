package modelo;

import java.sql.Timestamp;

public class Bitacora {

    private int id;
    private int idUsuario;
    private int idAccion;
    private int idSeccion;
    private Timestamp hora;

    public Bitacora() {
    }

    public Bitacora(int id, int idUsuario, int idAccion, int idSeccion, Timestamp hora) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idAccion = idAccion;
        this.idSeccion = idSeccion;
        this.hora = hora;
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

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Timestamp getHora() {
        return hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }

}
