package com.luis.neumann.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Libro implements Serializable {

    private int id;
    private String titulo;
    private String isbn;
    private int edicion;
    private LocalDate fechaPublicacion;
    private int capitulos;
    private int paginas;

    public Libro() {
        super();
        this.id = -1;
        this.titulo = "";
        this.isbn = "";
        this.edicion = -1;
        this.fechaPublicacion = null;
        this.capitulos = -1;
        this.paginas = -1;
    }

    public Libro(int id, String titulo, String isbn, int edicion, LocalDate fechaPublicacion, int capitulos, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicion = edicion;
        this.fechaPublicacion = fechaPublicacion;
        this.capitulos = capitulos;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return getId() == libro.getId() && getEdicion() == libro.getEdicion() && getCapitulos() == libro.getCapitulos() && getPaginas() == libro.getPaginas() && Objects.equals(getTitulo(), libro.getTitulo()) && Objects.equals(getIsbn(), libro.getIsbn()) && Objects.equals(getFechaPublicacion(), libro.getFechaPublicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getIsbn(), getEdicion(), getFechaPublicacion(), getCapitulos(), getPaginas());
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", edicion=" + edicion +
                ", fechaPublicacion=" + fechaPublicacion +
                ", capitulos=" + capitulos +
                ", paginas=" + paginas +
                '}';
    }
}
