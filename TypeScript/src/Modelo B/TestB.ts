import { Articulo } from "./Articulo";
import { Cliente } from "./Cliente";
import { DetalleFactura } from "./DetalleFactura";
import { Factura } from "./Factura";

export class TestB {
    public static ejecutar(): void {
        // Crear cliente
        const cliente = new Cliente(1, 'Cliente Ejemplo', 123456789);

        // Crear 5 instancias de Artículo
        const articulo1 = new Articulo(1, 'Laptop', 1000, 'unidad');
        const articulo2 = new Articulo(2, 'Mouse', 50, 'unidad');
        const articulo3 = new Articulo(3, 'Teclado', 150, 'unidad');
        const articulo4 = new Articulo(4, 'Monitor', 500, 'unidad');
        const articulo5 = new Articulo(5, 'Cargador', 25, 'unidad');

        // Crear 3 instancias de Factura
        const factura1 = new Factura('A', 1001, 50, 'E', new Date());
        const factura2 = new Factura('B', 1002, 100, 'TD', new Date());
        const factura3 = new Factura('C', 1003, 150, 'CC', new Date());

        // Agregar al menos 2 instancias de DetalleFactura a cada factura
        factura1.agregarDetalle(new DetalleFactura(2, articulo1)); // 2 laptops
        factura1.agregarDetalle(new DetalleFactura(3, articulo2)); // 3 mouses

        factura2.agregarDetalle(new DetalleFactura(1, articulo3)); // 1 teclado
        factura2.agregarDetalle(new DetalleFactura(4, articulo4)); // 4 monitores

        factura3.agregarDetalle(new DetalleFactura(5, articulo5)); // 5 cargadores
        factura3.agregarDetalle(new DetalleFactura(1, articulo1)); // 1 laptop

        // Asignar facturas al cliente
        cliente.agregarFactura(factura1);
        cliente.agregarFactura(factura2);
        cliente.agregarFactura(factura3);

        // Calcular total facturado para distintos tipos de pago y mostrar los resultados
        console.log('Total facturado en efectivo (E):', cliente.totalFacturadoXTipoPago('E'));
        console.log('Total facturado con tarjeta de crédito (TD):', cliente.totalFacturadoXTipoPago('TD'));
        console.log('Total facturado en cuenta corriente (CC):', cliente.totalFacturadoXTipoPago('CC'));
        console.log('Total facturado sin filtrar:', cliente.totalFacturadoXTipoPago(null));
    }
}

// Ejecutar el test
TestB.ejecutar();
