package model;

// Un articulo es texto. Guarda un cuerpo en Markdown o texto plano.
// Publicar cambia el estado si el usuario tiene permiso.
public class Articulo extends Contenido {
    // Contenido del articulo
    private String cuerpoMarkdown;

    public Articulo(String id, String titulo, Usuario autor, String cuerpoMarkdown){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.cuerpoMarkdown = cuerpoMarkdown;
    }

    public String getCuerpoMarkdown() { return cuerpoMarkdown; }
    public void setCuerpoMarkdown(String cuerpoMarkdown) { this.cuerpoMarkdown = cuerpoMarkdown; }

    @Override
    public void publicar(Usuario u) {
        // Solo se publica si el usuario puede publicar
        if (u != null && u.puedePublicar()) {
            this.estado = Estado.PUBLICADO;
        }
    }

    @Override
    public String renderizar() {
        // Devuelve titulo y cuerpo. Se puede adaptar a HTML si hace falta.
        String cuerpo = (cuerpoMarkdown == null) ? "" : cuerpoMarkdown;
        return "# " + titulo + "\n\n" + cuerpo;
    }
}
