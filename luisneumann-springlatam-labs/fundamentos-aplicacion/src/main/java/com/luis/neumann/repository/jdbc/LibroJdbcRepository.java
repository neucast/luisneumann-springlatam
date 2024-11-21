package com.luis.neumann.repository.jdbc;

import com.luis.neumann.domain.Libro;
import com.luis.neumann.repository.LibroRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;

public class LibroJdbcRepository implements LibroRepository {
    @Override
    public Libro save(Libro libro) {
        String sql = "INSERT INTO XXX(titulo, isbn, edicion, fecha_publicacion, capitulos, paginas)" +
                "VALUES(?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.XXX);) {
            ps.setXXX(1, libro.getXXX());
            ps.setXXX(2, libro.getXXX());
            ps.setInt(3, libro.getXXX());
            ps.setDate(4, java.sql.Date.valueOf(libro.getFechaPublicacion()));
            ps.setInt(5, libro.getCapitulos());
            ps.setXXX(6, libro.getPaginas());
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                try (ResultSet rs = ps.getGeneratedKeys();) {
                    while (rs.next()) {
                        libro.setId(rs.getInt(1));
                    }
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }

    @Override
    public Libro findById(int id) {
        Libro libro = null;
        String sql = "SELECT * FROM libro l WHERE XXX";
        try (Connection conn = dataSource.XXX;
             PreparedStatement ps = conn.XXX(sql);) {
            ps.setInt(XXX, XXX);
            try (ResultSet rs = ps.XXX) {
                while (rs.XXX()) {
                    libro = mapLibro(rs);
                }
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }

    @Override
    public Collection<Libro> findAll() {
        Collection<Libro> libros = new LinkedHashSet<>();
        String sql = "SELECT * FROM XXX";
        try (Connection conn = dataSource.XXX();
             PreparedStatement ps = conn.XXX(sql);
             ResultSet rs = ps.XXX();) {
            while (rs.XXX()) {
                libros.add(mapLibro(rs));
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libros;
    }

    @Override
    public long count() {
        long count = 0;
        String sql = "SELECT COUNT(*) FROM XXX";
        try (Connection conn = dataSource.XXX();
             PreparedStatement ps = conn.XXX(sql);
             ResultSet rs = ps.XXX();) {
            while (rs.XXX()) {
                count = rs.getLong(1);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return count;
    }

    @Override
    public Libro update(Libro libro) {
        String sql = "UPDATE XXX SET titulo=?, isbn=? WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setXXX(1, libro.getXXX());
            ps.setXXX(2, libro.getXXX());
            ps.setXXX(3, libro.getXXX());
            int rowcount = ps.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("El 'update' no ocurrio, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM XXX WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setXXX(1, id);
            int rowcount = ps.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("El 'delete' no ocurrio, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
    }
}
