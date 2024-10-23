import { TestB } from "../../src/Modelo B/TestB";


describe('TestB - Ejecutar pruebas del Modelo B', () => {
    beforeEach(() => {
        console.log = jest.fn(); // Mockear console.log antes de cada test
    });

    test('Debe ejecutar las pruebas correctamente y mostrar los resultados esperados en la consola', () => {
        // Ejecutar la función TestB.ejecutar()
        TestB.ejecutar();

        // Verificar que se hayan hecho cuatro llamadas a console.log
        expect(console.log).toHaveBeenCalledTimes(4);

        // Verificar los mensajes impresos en consola con los valores actualizados
        expect(console.log).toHaveBeenCalledWith('Total facturado en efectivo (E):', 2200); // Total efectivo (factura1)
        expect(console.log).toHaveBeenCalledWith('Total facturado con tarjeta de crédito (TD):', 2250); // Total tarjeta (factura2)
        expect(console.log).toHaveBeenCalledWith('Total facturado en cuenta corriente (CC):', 1275); // Total cuenta corriente (factura3)
        expect(console.log).toHaveBeenCalledWith('Total facturado sin filtrar:', 5725); // Total sin filtrar
    });

    afterEach(() => {
        jest.clearAllMocks(); // Limpiar los mocks después de cada test
    });
});
