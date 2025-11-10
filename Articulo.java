public class Articulo extends Contenido {
    private String cuerpoMarkdown;

    public Articulo(String id, String titulo, Usuario autor, String cuerpoMarkdown) {
        super(id, titulo, autor);
        this.cuerpoMarkdown = cuerpoMarkdown;
    }

    public String renderizar() {
        return "Artículo: " + titulo + "\n" + cuerpoMarkdown;
    }
}
