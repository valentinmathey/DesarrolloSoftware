import { Detalle } from '../../src/Modelo A/Detalle';
import { HojaRuta } from '../../src/Modelo A/HojaRuta';

describe('HojaRuta', () => {
    // Prueba para verificar el cálculo correcto del total de kilómetros en una hoja de ruta
    test('Debe calcular correctamente el total de kilómetros', () => {
        // Crear una hoja de ruta con tres detalles
        const hoja = new HojaRuta(new Date(2023, 6, 1), 1);
        hoja.agregarDetalle(new Detalle(0, 100, new Date(2023, 6, 1)));
        hoja.agregarDetalle(new Detalle(100, 200, new Date(2023, 6, 2)));
        hoja.agregarDetalle(new Detalle(200, 300, new Date(2023, 6, 3)));

        // Verificar que el total de kilómetros sea la suma de los tres detalles
        expect(hoja.obtenerTotalKilometros()).toBe(300); // 100 + 100 + 100 = 300 km
    });

    // Prueba para verificar los getters y setters de fecha y número
    test('Debe retornar y establecer correctamente los valores de fecha y numero', () => {
        const hoja = new HojaRuta(new Date(2023, 6, 1), 1);

        // Verificar que los getters devuelvan los valores correctos
        expect(hoja.getFecha()).toEqual(new Date(2023, 6, 1));
        expect(hoja.getNumero()).toBe(1);

        // Modificar los valores con los setters
        const nuevaFecha = new Date(2023, 6, 2);
        hoja.setFecha(nuevaFecha);
        hoja.setNumero(2);

        // Verificar que los setters hayan cambiado correctamente los valores
        expect(hoja.getFecha()).toEqual(nuevaFecha);
        expect(hoja.getNumero()).toBe(2);
    });

    // Prueba para verificar que si no hay detalles, el total de kilómetros es 0
    test('Debe devolver 0 si no hay detalles en la hoja de ruta', () => {
        const hoja = new HojaRuta(new Date(2023, 6, 1), 1);
        // Verificar que el total de kilómetros sea 0 cuando no hay detalles
        expect(hoja.obtenerTotalKilometros()).toBe(0);
    });
});
