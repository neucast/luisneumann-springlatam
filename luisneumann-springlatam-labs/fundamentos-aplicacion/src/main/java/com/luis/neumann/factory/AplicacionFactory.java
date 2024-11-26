package com.luis.neumann.factory;

import com.luis.neumann.config.InfrastructureConfig;
import com.luis.neumann.repository.LibroRepository;
import com.luis.neumann.repository.jdbc.LibroJdbcRepository;
import com.luis.neumann.service.LibroService;
import com.luis.neumann.service.impl.LibroServiceImpl;

public class AplicacionFactory {
    LibroService libroService = new LibroServiceImpl();

    private static InfrastructureConfig createInfrastructureConfig() {
        return new InfrastructureConfig();
    }

    private static LibroRepository createLibroRepository() {
        return new LibroJdbcRepository();
    }

    private static LibroService createLibroService() {
        return new LibroServiceImpl();
    }

    public static void createAplicacion() {
        ;
    }

    public LibroService getLibroService() {
        return libroService;
    }

    public void setLibroService(LibroService libroService) {
        this.libroService = libroService;
    }

    public AplicacionFactory() {
        super();
    }

    public AplicacionFactory(LibroService libroService) {
        this.libroService = libroService;
    }
}
