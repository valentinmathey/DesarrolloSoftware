import { Detalle } from '../../src/Modelo A/Detalle';
import { HojaRuta } from '../../src/Modelo A/HojaRuta';
import { Vehiculo } from '../../src/Modelo A/Vehiculo';

describe('Vehiculo', () => {
    // Prueba para verificar que el cálculo de kilómetros recorridos dentro de un rango de fechas es correcto
    test('Debe calcular correctamente los kilómetros recorridos en un rango de fechas', () => {
        const vehiculo = new Vehiculo('ABC123');

        // Crear dos hojas de ruta y agregar detalles
        const hoja1 = new HojaRuta(new Date(2023, 6, 1), 1);
        const hoja2 = new HojaRuta(new Date(2023, 7, 1), 2);

        hoja1.agregarDetalle(new Detalle(0, 100, new Date(2023, 6, 1)));
        hoja1.agregarDetalle(new Detalle(100, 200, new Date(2023, 6, 2)));
        hoja2.agregarDetalle(new Detalle(0, 150, new Date(2023, 7, 1)));

        // Agregar las hojas de ruta al vehículo
        vehiculo.agregarHojaRuta(hoja1);
        vehiculo.agregarHojaRuta(hoja2);

        // Verificar que el total de kilómetros recorridos en el rango de fechas sea correcto
        const totalKilometros = vehiculo.obtenerTotalKilometrosRecorridos(new Date(2023, 6, 1), new Date(2023, 7, 1));
        expect(totalKilometros).toBe(350); // Suma de las dos hojas de ruta
    });

    // Prueba para verificar que si no hay hojas de ruta en el rango de fechas, el total de kilómetros sea 0
    test('Debe devolver 0 si no hay hojas de ruta en el rango de fechas', () => {
        const vehiculo = new Vehiculo('ABC123');
        const hoja1 = new HojaRuta(new Date(2023, 6, 1), 1);
        hoja1.agregarDetalle(new Detalle(0, 100, new Date(2023, 6, 1)));

        vehiculo.agregarHojaRuta(hoja1);

        // Verificar que el total de kilómetros sea 0 cuando no hay hojas en el rango de fechas
        const totalKilometros = vehiculo.obtenerTotalKilometrosRecorridos(new Date(2023, 7, 1), new Date(2023, 8, 1));
        expect(totalKilometros).toBe(0);
    });

    // Prueba para verificar los getters y setters de patente
    test('Debe retornar y establecer correctamente la patente', () => {
        const vehiculo = new Vehiculo('ABC123');

        // Verificar que el getter devuelva la patente correcta
        expect(vehiculo.getPatente()).toBe('ABC123');

        // Cambiar la patente usando el setter
        vehiculo.setPatente('DEF456');

        // Verificar que el setter haya cambiado correctamente la patente
        expect(vehiculo.getPatente()).toBe('DEF456');
    });
});
