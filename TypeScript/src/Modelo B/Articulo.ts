export class Articulo {
    public codigo: number;
    public denominacion: string;
    public precio: number;
    public unidadMedida: string;

    constructor(codigo: number, denominacion: string, precio: number, unidadMedida: string) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
    }
}
