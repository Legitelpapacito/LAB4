package model;

// Una imagen guarda la ruta del archivo y un texto alternativo para accesibilidad.
public class Imagen extends Contenido {
    // Ruta del archivo de imagen
    private String rutaArchivo;
    // Texto alternativo por si la imagen no carga
    private String textoAlternativo;

    public Imagen(String id, String titulo, Usuario autor, String rutaArchivo, String textoAlternativo){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.rutaArchivo = rutaArchivo;
        this.textoAlternativo = textoAlternativo;
    }

    public String getRutaArchivo() { return rutaArchivo; }
    public void setRutaArchivo(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }
    public String getTextoAlternativo() { return textoAlternativo; }
    public void setTextoAlternativo(String textoAlternativo) { this.textoAlternativo = textoAlternativo; }

    @Override
    public void publicar(Usuario u) {
        // Se publica si hay permiso y tenemos una ruta valida
        if (u != null && u.puedePublicar() && rutaArchivo != null && !rutaArchivo.isBlank()) {
            this.estado = Estado.PUBLICADO;
        }
    }

    @Override
    public String renderizar() {
        // Muestra titulo y el texto alternativo entre parentesis
        String alt = (textoAlternativo == null) ? "" : textoAlternativo;
        return "[IMG] " + titulo + " (" + alt + ")";
    }
}
