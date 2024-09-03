package com.JPAeHibernate.facturaJPA.Service;

import com.JPAeHibernate.facturaJPA.Entity.*;
import com.JPAeHibernate.facturaJPA.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaService {
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Transactional
    public void crearFactura() {

        Categoria perecedero = Categoria.builder()
                .denominacion("Perecederos")
                .build();

        Categoria lacteos = Categoria.builder()
                .denominacion("Lacteos")
                .build();

        Categoria limpieza = Categoria.builder()
                .denominacion("Limpieza").
                build();

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

        leche.getCategorias().add(perecedero);
        leche.getCategorias().add(lacteos);

        lacteos.getArticulos().add(leche);
        perecedero.getArticulos().add(leche);
        detergente.getCategorias().add(limpieza);
        limpieza.getArticulos().add(detergente);

        Factura fac1 = Factura.builder()
                .fecha("27/08/2024")
                .numero(40)
                .build();

        Cliente cliente = Cliente.builder()
                .apellido("Mathey")
                .dni(44)
                .nombre("Valentin")
                .build();

        Domicilio domicilio = Domicilio.builder()
                .nombreCalle("moreno")
                .numero(245)
                .build();

        cliente.setDomicilio(domicilio);

        fac1.setCliente(cliente);

        DetalleFactura linea1 = new DetalleFactura();
        linea1.setArticulo(leche);
        linea1.setCantidad(4);
        linea1.setSubtotal(450);
        fac1.getFacturas().add(linea1);

        DetalleFactura linea2 = new DetalleFactura();
        linea2.setArticulo(detergente);
        linea2.setCantidad(1);
        linea2.setSubtotal(50);
        fac1.getFacturas().add(linea2);

        categoriaRepository.save(perecedero);
        categoriaRepository.save(lacteos);
        categoriaRepository.save(limpieza);
        articuloRepository.save(leche);
        articuloRepository.save(detergente);
        domicilioRepository.save(domicilio);
        clienteRepository.save(cliente);
        facturaRepository.save(fac1);
        detalleFacturaRepository.save(linea1);
        detalleFacturaRepository.save(linea2);
    }
}
