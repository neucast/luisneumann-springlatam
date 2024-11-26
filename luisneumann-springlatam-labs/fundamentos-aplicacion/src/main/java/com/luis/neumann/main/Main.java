package com.luis.neumann.main;

import com.luis.neumann.factory.AplicacionFactory;
import com.luis.neumann.service.LibroService;
import com.luis.neumann.service.impl.LibroServiceImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("****************************************");
        System.out.println("Main - 'fundamentos-aplicacion' - Inicio");
        System.out.println("****************************************");
        AplicacionFactory AplicacionFactory = new AplicacionFactory();
        com.luis.neumann.factory.AplicacionFactory.createAplicacion();
        LibroService libroService = com.luis.neumann.factory.AplicacionFactory.getLibroService();
        System.out.println("");

        System.out.println("--------------------");
        System.out.println("Reporte - 'findById'");
        System.out.println("--------------------");
        System.out.println("");
        libroService.reporte(libroService.findById(1));
        libroService.reporte(libroService.findById(15));
        libroService.reporte(libroService.findById(27));
        System.out.println("");

        System.out.println("-------------------");
        System.out.println("Reporte - 'findAll'");
        System.out.println("-------------------");
        System.out.println("");
        libroService.reporte(libroService.findAll());
        System.out.println("");

        System.out.println("----------------------");
        System.out.println("Reporte - 'count'");
        System.out.println("----------------------");
        System.out.println("");
        libroService.reporte(libroService.count());
        System.out.println("");

        System.out.println("*************************************");
        System.out.println("Main - 'fundamentos-aplicacion' - Fin");
        System.out.println("*************************************");
    }
}
