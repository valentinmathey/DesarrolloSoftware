import { Detalle } from "./Detalle";
import { HojaRuta } from "./HojaRuta";
import { Vehiculo } from "./Vehiculo";

export class TestA {
    public static ejecutar(): void {
        const vehiculo = new Vehiculo("ABC123");

        const hoja1 = new HojaRuta(new Date(2023, 6, 1), 1);
        hoja1.agregarDetalle(new Detalle(0, 100, new Date(2023, 6, 1)));
        hoja1.agregarDetalle(new Detalle(100, 200, new Date(2023, 6, 2)));
        hoja1.agregarDetalle(new Detalle(200, 300, new Date(2023, 6, 3)));

        const hoja2 = new HojaRuta(new Date(2023, 7, 1), 2);
        hoja2.agregarDetalle(new Detalle(0, 150, new Date(2023, 7, 1)));
        hoja2.agregarDetalle(new Detalle(150, 300, new Date(2023, 7, 2)));
        hoja2.agregarDetalle(new Detalle(300, 450, new Date(2023, 7, 3)));

        vehiculo.agregarHojaRuta(hoja1);
        vehiculo.agregarHojaRuta(hoja2);

        console.log(`Total kilómetros de la Hoja 1: ${hoja1.obtenerTotalKilometros()}`);
        console.log(`Total kilómetros recorridos entre el 01/07/2023 y el 01/09/2023: ${vehiculo.obtenerTotalKilometrosRecorridos(new Date(2023, 6, 1), new Date(2023, 8, 1))}`);
    }
}

TestA.ejecutar();
