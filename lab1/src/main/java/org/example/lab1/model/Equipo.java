//Creacion de el modelo para eequipos
package org.example.lab1.model;
// clase POJO basica, aca solo guardamos los datos de un equipo tecnologico
// no tiene logica, solo atributos con sus geters y setters
public class Equipo {
    private int id;
    private String nombre;
    private String tipo;
    private String codigoActivo;
    private String fechaAdquisicion;
    // constructor vacio, lo necesitamos porque en el controlador vamos a
    // instanciar el objeto primero y luego ir llenando cada campo con los

    public Equipo() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoActivo() {
        return codigoActivo;
    }
    public void setCodigoActivo(String codigoActivo) {
        this.codigoActivo = codigoActivo;
    }
    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }
    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }
}