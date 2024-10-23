import { Articulo } from './Articulo';

export class DetalleFactura {
    public cantidad: number;
    public subtotal: number;
    public articulo: Articulo;

    constructor(cantidad: number, articulo: Articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.subtotal = 0;
    }

    // Función para calcular el subtotal
    public calcularSubTotal(): void {
        this.subtotal = this.cantidad * this.articulo.precio;
    }
}
