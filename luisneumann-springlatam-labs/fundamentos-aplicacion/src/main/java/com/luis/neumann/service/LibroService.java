package com.luis.neumann.service;

import com.luis.neumann.domain.Libro;

import java.util.Collection;

public interface LibroService {
    Libro save(Libro libro);

    Libro findById(int id);

    Collection<Libro> findAll();

    long count();

    Libro update(Libro libro);

    void delete(int id);

    void reporte(Libro libro);

    void reporte(Collection<Libro> libros);

    void reporte(long id);
}
