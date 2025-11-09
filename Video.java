package model;

// Un video almacena una URL (por ejemplo de YouTube) y una descripcion.
// Para publicar pedimos que el usuario tenga permiso y que la URL exista.
public class Video extends Contenido {
    // Enlace del video
    private String url;
    // Breve descripcion del video
    private String descripcion;

    public Video(String id, String titulo, Usuario autor, String url, String descripcion){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.url = url;
        this.descripcion = descripcion;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public void publicar(Usuario u) {
        // Se publica si hay permiso y la URL no es vacia
        if (u != null && u.puedePublicar() && url != null && !url.isBlank()) {
            this.estado = Estado.PUBLICADO;
        }
    }

    @Override
    public String renderizar() {
        // Devuelve una linea con el titulo y la URL
        String link = (url == null || url.isBlank()) ? "(sin URL)" : url;
        return "[VIDEO] " + titulo + " -> " + link;
    }
}
