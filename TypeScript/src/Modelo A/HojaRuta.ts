import { Detalle } from "./Detalle";

export class HojaRuta {
    public fecha: Date;
    public numero: number;
    public detalles: Detalle[];

    constructor(fecha: Date, numero: number) {
        this.fecha = fecha;
        this.numero = numero;
        this.detalles = [];
    }

    // Getter y Setter para fecha
    public getFecha(): Date {
        return this.fecha;
    }

    public setFecha(fecha: Date): void {
        this.fecha = fecha;
    }

    // Getter y Setter para numero
    public getNumero(): number {
        return this.numero;
    }

    public setNumero(numero: number): void {
        this.numero = numero;
    }

    // Método para agregar detalles a la hoja de ruta
    public agregarDetalle(detalle: Detalle): void {
        this.detalles.push(detalle);
    }

    // Método privado para calcular el total de kilómetros
    private calcularTotalKilometros(): number {
        return this.detalles.reduce((total, detalle) => total + detalle.obtenerKilometros(), 0);
    }

    // Método público para obtener el total de kilómetros
    public obtenerTotalKilometros(): number {
        return this.calcularTotalKilometros();
    }
}
