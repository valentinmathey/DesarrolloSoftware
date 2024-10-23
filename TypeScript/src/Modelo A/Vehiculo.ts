import { HojaRuta } from "./HojaRuta";

export class Vehiculo {
    public patente: string;
    public hojasRuta: HojaRuta[];

    constructor(patente: string) {
        this.patente = patente;
        this.hojasRuta = [];
    }

    // Getter y Setter para patente
    public getPatente(): string {
        return this.patente;
    }

    public setPatente(patente: string): void {
        this.patente = patente;
    }

    // Método para agregar hojas de ruta
    public agregarHojaRuta(hoja: HojaRuta): void {
        this.hojasRuta.push(hoja);
    }

    // Método privado para calcular los kilómetros recorridos en un rango de fechas
    private calcularTotalKilometrosRecorridos(fechaDesde: Date, fechaHasta: Date): number {
        return this.hojasRuta
            .filter(hoja => hoja.getFecha() >= fechaDesde && hoja.getFecha() <= fechaHasta)
            .reduce((total, hoja) => total + hoja.obtenerTotalKilometros(), 0);
    }

    // Método público para obtener los kilómetros recorridos
    public obtenerTotalKilometrosRecorridos(fechaDesde: Date, fechaHasta: Date): number {
        return this.calcularTotalKilometrosRecorridos(fechaDesde, fechaHasta);
    }
}
