package com.luis.neumann.config;

import com.luis.neumann.domain.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class TestDBConnection {

    private static Libro mapLibro(ResultSet resultSet) {
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

    public static void main(String[] args) {
        Connection connection = null;
        ResultSet rs = null;
        Statement stmt = null;
        Collection<Libro> libros = new ArrayList();

        try {
            connection = DriverManager.getConnection(getUrl());

            // Do something with the connection.
            // assume that connection is an already created JDBC connection (see previous examples)

            stmt = null;
            rs = null;


            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM libro");

            while (rs.next()) {
                Libro libro = mapLibro(rs);
                libros.add(libro);
                System.out.println("Libro: " + libro);
            }
            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            // if (stmt.execute("SELECT foo FROM bar")) {
            //    rs = stmt.getResultSet();


            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    private static String getUrl() {
        return "jdbc:mysql://172.17.0.2:3306/springlatam_labs" + "?allowPublicKeyRetrieval=true&useSSL=false";
    }
}
