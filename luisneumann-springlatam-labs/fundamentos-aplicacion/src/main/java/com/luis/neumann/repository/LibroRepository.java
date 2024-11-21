package com.luis.neumann.repository;

import com.luis.neumann.domain.Libro;

import java.util.Collection;

public interface LibroRepository {
    Libro save(Libro libro);

    Libro findById(int id);

    Collection<Libro> findAll();

    long count();

    Libro update(Libro libro);

    void delete(int id);
}
