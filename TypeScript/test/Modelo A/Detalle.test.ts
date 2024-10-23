import { Detalle } from '../../src/Modelo A/Detalle';

describe('Detalle', () => {
    // Prueba para verificar que el cálculo de kilómetros es correcto
    test('Debe calcular correctamente los kilómetros recorridos', () => {
        // Se crea una instancia de Detalle con kmInicial = 0 y kmFinal = 100
        const detalle = new Detalle(0, 100, new Date(2023, 6, 1));
        // Se espera que los kilómetros recorridos sean 100 (kmFinal - kmInicial)
        expect(detalle.obtenerKilometros()).toBe(100); 

        // Se modifican los valores de kmInicial y kmFinal
        detalle.setKmInicial(50);
        detalle.setKmFinal(200);
        // Se espera que los kilómetros recorridos sean 150 (200 - 50)
        expect(detalle.obtenerKilometros()).toBe(150); 
    });

    // Prueba para verificar los getters y setters de kmInicial, kmFinal y fecha
    test('Debe retornar y establecer correctamente los valores de kmInicial, kmFinal y fecha', () => {
        const fecha = new Date(2023, 6, 1);
        const detalle = new Detalle(0, 100, fecha);

        // Verificar que los getters devuelvan los valores correctos
        expect(detalle.getKmInicial()).toBe(0);
        expect(detalle.getKmFinal()).toBe(100);
        expect(detalle.getFecha()).toBe(fecha);

        // Cambiar los valores con los setters
        detalle.setKmInicial(10);
        detalle.setKmFinal(90);
        const nuevaFecha = new Date(2023, 6, 2);
        detalle.setFecha(nuevaFecha);

        // Verificar que los setters hayan modificado correctamente los valores
        expect(detalle.getKmInicial()).toBe(10);
        expect(detalle.getKmFinal()).toBe(90);
        expect(detalle.getFecha()).toBe(nuevaFecha);
    });

    // Prueba para verificar cómo se maneja el caso de kilometraje negativo
    test('Debe manejar casos con kilometraje negativo', () => {
        // Se crea una instancia donde kmFinal es menor que kmInicial
        const detalle = new Detalle(200, 100, new Date(2023, 6, 1));
        // Se espera que los kilómetros recorridos sean negativos
        expect(detalle.obtenerKilometros()).toBe(-100);
    });
});

