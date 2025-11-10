package cms;

import java.util.Objects;


public class Etiqueta {
    private String nombre;

    public Etiqueta(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre requerido");
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre requerido");
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etiqueta)) return false;
        Etiqueta e = (Etiqueta) o;
        return nombre.equalsIgnoreCase(e.nombre);
    }

    @Override
    public int hashCode() { return Objects.hash(nombre.toLowerCase()); }

    @Override
    public String toString() { return nombre; }
}
