import { TestA } from "../../src/Modelo A/TestA";


describe('TestA - Ejecutar y verificar los cálculos', () => {
    beforeEach(() => {
        // Mockear console.log antes de cada test
        console.log = jest.fn();
    });

    test('Debe ejecutar correctamente y mostrar los resultados esperados en la consola', () => {
        // Ejecutar la función TestA.ejecutar()
        TestA.ejecutar();

        // Verificar que se hayan hecho dos llamadas a console.log
        expect(console.log).toHaveBeenCalledTimes(2);

        // Verificar los mensajes impresos en consola
        expect(console.log).toHaveBeenCalledWith('Total kilómetros de la Hoja 1: 300'); // Total de la primera hoja de ruta
        expect(console.log).toHaveBeenCalledWith(
            'Total kilómetros recorridos entre el 01/07/2023 y el 01/09/2023: 750' // Total entre las fechas indicadas
        );
    });

    afterEach(() => {
        jest.clearAllMocks(); // Limpiar los mocks después de cada test
    });
});
