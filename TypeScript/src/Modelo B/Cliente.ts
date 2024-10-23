import { Factura } from './Factura';

export class Cliente {
    public numero: number;
    public razonSocial: string;
    public cuit: number;
    public facturas: Factura[];

    constructor(numero: number, razonSocial: string, cuit: number) {
        this.numero = numero;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.facturas = [];
    }

    // Función para agregar una factura
    public agregarFactura(factura: Factura): void {
        this.facturas.push(factura);
    }

    // Función para calcular el total facturado por tipo de pago
    public totalFacturadoXTipoPago(tipoPago: string | null): number {
        return this.facturas.reduce((total, factura) => {
            if (!tipoPago || factura.tipoPago === tipoPago) {
                factura.calcularTotalFinal();
                return total + factura.totalFinal;
            }
            return total;
        }, 0);
    }
}
