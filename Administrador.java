package model;

// Administrador con permisos completos
public class Administrador extends Usuario {
    public Administrador(String nombre){
        super(nombre);
    }

    @Override public boolean puedePublicar(){ return true; }
    @Override public boolean puedeEliminar(){ return true; }
}
