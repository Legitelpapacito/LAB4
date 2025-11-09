package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

enum Estado { BORRADOR, PUBLICADO }

// Clase base para cualquier tipo de contenido del CMS.
// Aqui ponemos lo comun: titulo, autor, estado, categorias y etiquetas.
// Las subclases (Articulo, Video, Imagen) heredan esto para no repetir codigo.
public abstract class Contenido {
    // Identificador unico para poder guardar y buscar
    protected String id;
    // Titulo visible del contenido
    protected String titulo;
    // Usuario que creo el contenido
    protected Usuario autor;
    // Cuándo se creo el contenido, util para ordenar o reportar
    protected LocalDateTime fechaCreacion = LocalDateTime.now();
    // Si esta en BORRADOR o PUBLICADO
    protected Estado estado = Estado.BORRADOR;
    // Lista de categorias para clasificar
    protected List<Categoria> categorias = new ArrayList<>();
    // Lista de etiquetas simples para busqueda rapida
    protected List<String> etiquetas = new ArrayList<>();

    // Getters y setters basicos
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }

    public Estado getEstado() { return estado; }

    public List<Categoria> getCategorias() { return categorias; }
    // Agrega una categoria al contenido
    public void agregarCategoria(Categoria c) { if (c != null) categorias.add(c); }

    public List<String> getEtiquetas() { return etiquetas; }
    // Agrega una etiqueta en texto
    public void agregarEtiqueta(String e) { if (e != null && !e.isBlank()) etiquetas.add(e); }

    // Cada tipo decide como se publica. Aqui solo definimos la firma.
    // El usuario u sirve para verificar permisos.
    public abstract void publicar(Usuario u);

    // Devuelve una version en texto para mostrar en pantalla o web.
    // Cada tipo lo implementa a su manera.
    public abstract String renderizar();
}
