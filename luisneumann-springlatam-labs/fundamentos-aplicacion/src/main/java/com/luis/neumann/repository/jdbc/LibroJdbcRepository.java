package com.luis.neumann.repository.jdbc;

import com.luis.neumann.config.InfrastructureConfig;
import com.luis.neumann.domain.Libro;
import com.luis.neumann.repository.LibroRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;

public class LibroJdbcRepository implements LibroRepository {

    InfrastructureConfig infrastructureConfig = new InfrastructureConfig();
    DataSource dataSource = infrastructureConfig.createDataSourceMysql();

    private Libro mapLibro(ResultSet resultSet) {
        Libro libro = new Libro();

        try {
            libro.setId(resultSet.getInt("id"));
            libro.setTitulo(resultSet.getString("titulo"));
            libro.setIsbn(resultSet.getString("isbn"));
            libro.setEdicion(resultSet.getInt("edicion"));
            libro.setFechaPublicacion(resultSet.getDate("fecha_publicacion").toLocalDate());
            libro.setCapitulos(resultSet.getInt("capitulos"));
            libro.setPaginas(resultSet.getInt("paginas"));
        } catch (SQLException sqle) {
            System.err.println("ERROR:" + sqle.getMessage());
            throw new RuntimeException(sqle);
        }

        return libro;
    }

    @Override
    public Libro save(Libro libro) {
        String sql = "INSERT INTO libro(titulo, isbn, edicion, fecha_publicacion, capitulos, paginas) VALUES(?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getIsbn());
            preparedStatement.setInt(3, libro.getEdicion());
            preparedStatement.setDate(4, java.sql.Date.valueOf(libro.getFechaPublicacion()));
            preparedStatement.setInt(5, libro.getCapitulos());
            preparedStatement.setInt(6, libro.getPaginas());

            int rowcount = preparedStatement.executeUpdate();

            if (rowcount == 1) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {
                    while (resultSet.next()) {
                        libro.setId(resultSet.getInt(1));
                    }
                }
            } else {
                throw new SQLException("El 'insert' no ocurrió, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libro;
    }

    @Override
    public Libro findById(int id) {
        Libro libro = null;

        String sql = "SELECT * FROM libro l WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    libro = mapLibro(resultSet);
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

        String sql = "SELECT * FROM libro";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

             ResultSet resultSet = preparedStatement.getResultSet();) {

            while (resultSet.next()) {
                libros.add(mapLibro(resultSet));
            }

        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return libros;
    }

    @Override
    public long count() {
        long count = 0;
        String sql = "SELECT COUNT(*) FROM libro";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.getResultSet();) {
            while (resultSet.next()) {
                count = resultSet.getLong(1);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return count;
    }

    @Override
    public Libro update(Libro libro) {
        String sql = "UPDATE libro SET titulo=?, isbn=? WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getIsbn());
            preparedStatement.setInt(3, libro.getId());

            int rowcount = preparedStatement.executeUpdate();

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
        String sql = "DELETE FROM libro WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);

            int rowcount = preparedStatement.executeUpdate();

            if (rowcount != 1) {
                throw new SQLException("El 'delete' no ocurrio, valor de: " + rowcount);
            }
        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
    }
}
