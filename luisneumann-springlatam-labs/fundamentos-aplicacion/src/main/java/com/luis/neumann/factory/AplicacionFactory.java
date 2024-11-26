package com.luis.neumann.factory;

import com.luis.neumann.config.InfrastructureConfig;
import com.luis.neumann.repository.LibroRepository;
import com.luis.neumann.repository.jdbc.LibroJdbcRepository;
import com.luis.neumann.service.LibroService;
import com.luis.neumann.service.impl.LibroServiceImpl;

public class AplicacionFactory {
    LibroServiceImpl libroService;

    private static InfrastructureConfig createInfrastructureConfig() {
        return new InfrastructureConfig();
    }

    private static LibroRepository createLibroRepository() {
        return new LibroJdbcRepository();
    }

    private static void createLibroService() {
        LibroServiceImpl libroService = new LibroServiceImpl();
    }

    public static void createAplicacion() {
        ;
    }

    public static LibroService getLibroService() {
        return new LibroServiceImpl();
    }

    public AplicacionFactory() {
        super();
    }

    public AplicacionFactory(LibroServiceImpl libroService) {
        this.libroService = libroService;
    }
}
