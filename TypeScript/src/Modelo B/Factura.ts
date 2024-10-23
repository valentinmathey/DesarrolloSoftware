import { DetalleFactura } from './DetalleFactura';

export class Factura {
    public letra: string;
    public numero: number;
    public recargo: number;
    public tipoPago: string;
    public totalItems: number;
    public totalFinal: number;
    public fecha: Date;
    public detalles: DetalleFactura[];

    constructor(letra: string, numero: number, recargo: number, tipoPago: string, fecha: Date) {
        this.letra = letra;
        this.numero = numero;
        this.recargo = recargo;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.detalles = [];
        this.totalItems = 0;
        this.totalFinal = 0;
    }

    // Función para agregar detalles a la factura
    public agregarDetalle(detalle: DetalleFactura): void {
        this.detalles.push(detalle);
    }

    // Función para calcular el total de ítems (sumar los subtotales)
    public calcularTotalItems(): void {
        this.totalItems = this.detalles.reduce((total, detalle) => {
            detalle.calcularSubTotal();
            return total + detalle.subtotal;
        }, 0);
    }

    // Función para calcular el total final (total ítems + recargo)
    public calcularTotalFinal(): void {
        this.calcularTotalItems();
        this.totalFinal = this.totalItems + this.recargo;
    }
}
