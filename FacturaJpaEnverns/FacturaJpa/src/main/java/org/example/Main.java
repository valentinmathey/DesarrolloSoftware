package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Crear el EntityManagerFactory y el EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Iniciar la transacción
            entityManager.getTransaction().begin();

            // Crear las categorías de artículos
            Categoria perecedero = Categoria.builder()
                    .denominacion("Perecederos")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacion("Lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            // Crear los artículos
            Articulo leche = Articulo.builder()
                    .cantidad(3)
                    .denominacion("leche 1")
                    .precio(1000)
                    .build();

            Articulo detergente = Articulo.builder()
                    .cantidad(4)
                    .denominacion("detergente")
                    .precio(500)
                    .build();

            // Asignar categorías a los artículos
            leche.getCategorias().add(perecedero);
            leche.getCategorias().add(lacteos);

            // Asociar los artículos con las categorías
            lacteos.getArticulos().add(leche);
            perecedero.getArticulos().add(leche);
            detergente.getCategorias().add(limpieza);
            limpieza.getArticulos().add(detergente);

            // Crear la factura
            Factura fac1 = Factura.builder()
                    .fecha("27/08/2024")
                    .numero(40)
                    .build();

            // Crear el cliente y su domicilio
            Cliente cliente = Cliente.builder()
                    .apellido("Mathey")
                    .dni(44)
                    .nombre("Valentin")
                    .build();

            Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("moreno")
                    .numero(245)
                    .build();

            // Asignar el domicilio al cliente
            cliente.setDomicilio(domicilio);

            // Asignar el cliente a la factura
            fac1.setCliente(cliente);

            // Crear los detalles de la factura
            DetalleFactura linea1 = new DetalleFactura();
            linea1.setArticulo(leche);
            linea1.setCantidad(4);
            linea1.setSubtotal(450);
            linea1.setFactura(fac1);
            // fac1.getDetalles().add(linea1); // Asegúrate de descomentar esta línea para agregar el detalle a la factura

            DetalleFactura linea2 = new DetalleFactura();
            linea2.setArticulo(detergente);
            linea2.setCantidad(1);
            linea2.setSubtotal(50);
            linea2.setFactura(fac1);
            // fac1.getDetalles().add(linea2); // Asegúrate de descomentar esta línea para agregar el detalle a la factura

            // Calcular y asignar el total de la factura
            fac1.setTotal(linea1.getSubtotal() + linea2.getSubtotal());

            // Persistir las entidades en la base de datos
            entityManager.persist(perecedero);
            entityManager.persist(lacteos);
            entityManager.persist(limpieza);
            entityManager.persist(leche);
            entityManager.persist(detergente);
            entityManager.persist(domicilio);
            entityManager.persist(cliente);
            entityManager.persist(linea1);
            entityManager.persist(linea2);
            entityManager.persist(fac1);

            // Asegurar que los datos se hayan enviado a la base de datos
            entityManager.flush();

            // Confirmar la transacción
            entityManager.getTransaction().commit();

            // Consultar y mostrar la entidad persistida
            Factura recuperoCFactura = entityManager.find(Factura.class, fac1.getId());
            System.out.println("RECUPERAMOS AL Factura: " + fac1);

        } catch (Exception e) {
            // Si ocurre un error, revertir la transacción
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Factura");
        }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
