package com.luis.neumann.service.impl;

import com.luis.neumann.domain.Libro;
import com.luis.neumann.service.LibroService;

import java.util.Collection;
import java.util.List;

public class LibroServiceImpl implements LibroService {
    @Override
    public Libro save(Libro libro) {
        return null;
    }

    @Override
    public Libro findById(int id) {
        return null;
    }

    @Override
    public Collection<Libro> findAll() {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Libro update(Libro libro) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void reporte(Libro libro) {

    }

    @Override
    public void reporte(Collection<Libro> libros) {

    }

    @Override
    public void reporte(long id) {

    }
}
