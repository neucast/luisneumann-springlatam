package com.luis.neumann.service.impl;

import com.luis.neumann.domain.Libro;
import com.luis.neumann.repository.LibroRepository;
import com.luis.neumann.repository.jdbc.LibroJdbcRepository;
import com.luis.neumann.service.LibroService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LibroServiceImpl implements LibroService {

    LibroRepository libroRepository = new LibroJdbcRepository();

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro findById(int id) {
        return libroRepository.findById(id);
    }

    @Override
    public Collection<Libro> findAll() {
        return List.of((Libro) libroRepository.findAll());
    }

    @Override
    public long count() {
        return libroRepository.count();
    }

    @Override
    public Libro update(Libro libro) {
        return libroRepository.update(libro);
    }

    @Override
    public void delete(int id) {
        libroRepository.delete(id);
    }

    @Override
    public void reporte(Libro libro) {
        System.out.println(libro);
    }

    @Override
    public void reporte(Collection<Libro> libros) {

        Iterator<Libro> iterator = libros.iterator();

        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            System.out.println(libro);
        }
    }

    @Override
    public void reporte(long id) {
        Libro libro = libroRepository.findById((int) id);
        System.out.println(libro);
    }
}
