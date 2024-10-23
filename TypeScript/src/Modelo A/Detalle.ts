export class Detalle {
    public kmInicial: number;
    public kmFinal: number;
    public fecha: Date;

    constructor(kmInicial: number, kmFinal: number, fecha: Date) {
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.fecha = fecha;
    }

    // Getter y Setter para kmInicial
    public getKmInicial(): number {
        return this.kmInicial;
    }

    public setKmInicial(kmInicial: number): void {
        this.kmInicial = kmInicial;
    }

    // Getter y Setter para kmFinal
    public getKmFinal(): number {
        return this.kmFinal;
    }

    public setKmFinal(kmFinal: number): void {
        this.kmFinal = kmFinal;
    }

    // Getter y Setter para fecha
    public getFecha(): Date {
        return this.fecha;
    }

    public setFecha(fecha: Date): void {
        this.fecha = fecha;
    }

    // Método para calcular los kilómetros recorridos (privado, ya que es solo para uso interno)
    private calcularKilometros(): number {
        return this.kmFinal - this.kmInicial;
    }

    // Exponemos este método si es necesario a través de un método público
    public obtenerKilometros(): number {
        return this.calcularKilometros();
    }
}


