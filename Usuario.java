package model;

// Usuario base. Define nombre y dos metodos de permiso.
// Por defecto no puede publicar ni eliminar.
public abstract class Usuario {
    // Nombre visible del usuario
    protected String nombre;

    public Usuario(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    // Permisos basicos. Las subclases los sobrescriben si hace falta.
    public boolean puedePublicar(){ return false; }
    public boolean puedeEliminar(){ return false; }
}
